
from dash import Dash, html, dash_table, dcc, callback, Output, Input, State
import pandas as pd
import plotly.express as px
import plotly.graph_objects as go
import dash_bootstrap_components as dbc
from datetime import datetime as dt
import numpy as np

# Carregar e tratar os dados CORRETAMENTE
url = "https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/owid-covid-data.csv"
df = pd.read_csv(url)

# Filtrar colunas relevantes e tratar dados
df = df[['continent', 'location', 'date', 'total_cases', 'total_deaths', 
         'population', 'gdp_per_capita', 'human_development_index',
         'total_cases_per_million', 'total_deaths_per_million']]

# Calcular novas colunas CORRETAS
df['mortality_rate'] = (df['total_deaths'] / df['total_cases']) * 100
df['date'] = pd.to_datetime(df['date'])
df = df.dropna(subset=['continent'])  # Remover dados agregados (como 'World')

# Preencher valores nulos
df['mortality_rate'] = df['mortality_rate'].fillna(0)
df = df.fillna(0)

# Criar lista de continentes e países
continents = sorted(df['continent'].unique())
countries = sorted(df['location'].unique())

# Inicializar o app
external_stylesheets = [dbc.themes.FLATLY]
app = Dash(__name__, external_stylesheets=external_stylesheets, suppress_callback_exceptions=True)
server = app.server

# Layout do app
app.layout = dbc.Container([
    dbc.Row([
        dbc.Col(html.H1("Análise COVID-19 Global", className="text-center my-4"), width=12)
    ]),
    
    dbc.Row([
        dbc.Col([
            dbc.Card([
                dbc.CardHeader("Filtros", className="bg-primary text-white"),
                dbc.CardBody([
                    html.Label("Continente(s):"),
                    dcc.Dropdown(
                        id='continent-selector',
                        options=[{'label': c, 'value': c} for c in continents],
                        value=['Europe', 'Asia'],
                        multi=True
                    ),
                    
                    html.Label("País(es):", className="mt-3"),
                    dcc.Dropdown(
                        id='country-selector',
                        options=[{'label': c, 'value': c} for c in countries],
                        multi=True
                    ),
                    
                    html.Label("Intervalo de PIB per capita (US$):", className="mt-3"),
                    dcc.RangeSlider(
                        id='gdp-slider',
                        min=0,
                        max=100000,
                        step=1000,
                        value=[5000, 50000],
                        marks={i: f"{i//1000}k" for i in range(0, 100001, 10000)}
                    ),
                    
                    html.Label("Período:", className="mt-3"),
                    dcc.DatePickerRange(
                        id='date-range',
                        start_date=dt(2020, 1, 1),
                        end_date=dt(2023, 1, 1),
                        display_format='YYYY-MM-DD'
                    ),
                    
                    dbc.Button("Aplicar Filtros", id='apply-btn', color="primary", className="mt-4 w-100")
                ])
            ])
        ], width=3),
        
        dbc.Col([
            dbc.Tabs([
                dbc.Tab(label="Visão Geral", tab_id="overview"),
                dbc.Tab(label="Análise Detalhada", tab_id="detailed"),
                dbc.Tab(label="Estatísticas", tab_id="stats"),
            ], id="tabs", active_tab="overview"),
            
            html.Div(id="tab-content")
        ], width=9)
    ]),
    
    dcc.Store(id='filtered-data')
], fluid=True)

# Callbacks
@app.callback(
    Output('filtered-data', 'data'),
    Input('apply-btn', 'n_clicks'),
    [
        State('continent-selector', 'value'),
        State('country-selector', 'value'),
        State('gdp-slider', 'value'),
        State('date-range', 'start_date'),
        State('date-range', 'end_date')
    ]
)
def update_filtered_data(n_clicks, selected_continents, selected_countries, gdp_range, start_date, end_date):
    filtered = df.copy()
    
    # Aplicar filtros
    if selected_continents:
        filtered = filtered[filtered['continent'].isin(selected_continents)]
    if selected_countries:
        filtered = filtered[filtered['location'].isin(selected_countries)]
    
    filtered = filtered[
        (filtered['gdp_per_capita'] >= gdp_range[0]) & 
        (filtered['gdp_per_capita'] <= gdp_range[1])
    ]
    
    filtered = filtered[
        (filtered['date'] >= start_date) & 
        (filtered['date'] <= end_date)
    ]
    
    return filtered.to_json(date_format='iso', orient='split')

@app.callback(
    Output('tab-content', 'children'),
    [Input('tabs', 'active_tab'),
     Input('filtered-data', 'data')]
)
def render_tab_content(active_tab, data):
    if not data:
        return "Carregando dados..."
    
    filtered = pd.read_json(data, orient='split')
    
    if active_tab == "overview":
        return overview_tab(filtered)
    elif active_tab == "detailed":
        return detailed_tab(filtered)
    elif active_tab == "stats":
        return stats_tab(filtered)

def overview_tab(df):
    # Calcular dados agregados
    latest = df.sort_values('date').groupby('location').last().reset_index()
    
    # Criar gráficos
    fig1 = px.scatter(
        latest,
        x='gdp_per_capita',
        y='mortality_rate',
        size='total_cases',
        color='continent',
        hover_name='location',
        log_x=True,
        title='Mortalidade vs PIB per capita',
        labels={'mortality_rate': 'Taxa de Mortalidade (%)', 'gdp_per_capita': 'PIB per capita (US$)'}
    )
    
    fig2 = px.choropleth(
        latest,
        locations='location',
        locationmode='country names',
        color='total_cases_per_million',
        hover_name='location',
        hover_data=['total_cases', 'total_deaths', 'mortality_rate'],
        title='Casos por milhão de habitantes',
        color_continuous_scale='Blues'
    )
    
    return [
        dbc.Row([
            dbc.Col(dcc.Graph(figure=fig1), width=6),
            dbc.Col(dcc.Graph(figure=fig2), width=6)
        ]),
        dbc.Row([
            dbc.Col(dcc.Graph(figure=time_series_plot(df)), width=12)
        ])
    ]

def detailed_tab(df):
    # Gráfico de linha para evolução temporal
    fig1 = time_series_plot(df)
    
    # Boxplot de mortalidade por continente
    latest = df.sort_values('date').groupby('location').last().reset_index()
    fig2 = px.box(
        latest,
        x='continent',
        y='mortality_rate',
        color='continent',
        title='Distribuição de Taxa de Mortalidade por Continente',
        labels={'mortality_rate': 'Taxa de Mortalidade (%)', 'continent': 'Continente'}
    )
    
    # Correlações
    corr_df = df[['total_cases', 'total_deaths', 'gdp_per_capita', 
                 'human_development_index', 'population']].corr()
    fig3 = go.Figure(data=go.Heatmap(
        z=corr_df.values,
        x=corr_df.columns,
        y=corr_df.columns,
        colorscale='Blues',
        zmin=-1,
        zmax=1
    ))
    fig3.update_layout(title='Matriz de Correlação')
    
    return [
        dbc.Row([
            dbc.Col(dcc.Graph(figure=fig1), width=12)
        ]),
        dbc.Row([
            dbc.Col(dcc.Graph(figure=fig2), width=6),
            dbc.Col(dcc.Graph(figure=fig3), width=6)
        ])
    ]

def stats_tab(df):
    # Dados agregados
    latest = df.sort_values('date').groupby('location').last().reset_index()
    stats = latest.groupby('continent').agg({
        'mortality_rate': ['mean', 'median', 'std'],
        'total_cases_per_million': ['mean', 'median'],
        'gdp_per_capita': ['mean', 'median']
    }).reset_index()
    
    # Renomear colunas para melhor visualização
    stats.columns = ['_'.join(col).strip('_') for col in stats.columns.values]
    stats = stats.rename(columns={
        'continent_': 'Continente',
        'mortality_rate_mean': 'Média Taxa Mortalidade',
        'mortality_rate_median': 'Mediana Taxa Mortalidade',
        'mortality_rate_std': 'Desvio Padrão Taxa Mortalidade',
        'total_cases_per_million_mean': 'Média Casos por Milhão',
        'total_cases_per_million_median': 'Mediana Casos por Milhão',
        'gdp_per_capita_mean': 'Média PIB per capita',
        'gdp_per_capita_median': 'Mediana PIB per capita'
    })
    
    # Tabela estatística
    stats_table = dash_table.DataTable(
        columns=[{"name": i, "id": i} for i in stats.columns],
        data=stats.to_dict('records'),
        style_table={'overflowX': 'auto'},
        style_cell={'textAlign': 'left', 'padding': '10px'},
        style_header={'fontWeight': 'bold'}
    )
    
    # Histograma
    fig = px.histogram(
        latest,
        x='mortality_rate',
        color='continent',
        nbins=30,
        barmode='overlay',
        title='Distribuição da Taxa de Mortalidade',
        labels={'mortality_rate': 'Taxa de Mortalidade (%)', 'continent': 'Continente'}
    )
    
    return [
        dbc.Row([
            dbc.Col(stats_table, width=12)
        ]),
        dbc.Row([
            dbc.Col(dcc.Graph(figure=fig), width=12)
        ])
    ]

def time_series_plot(df):
    # Agrupar por data e continente
    ts = df.groupby(['date', 'continent'])['total_cases'].sum().reset_index()
    return px.line(
        ts,
        x='date',
        y='total_cases',
        color='continent',
        title='Evolução de Casos ao Longo do Tempo',
        labels={'total_cases': 'Total de Casos', 'date': 'Data', 'continent': 'Continente'}
    )

# Callback para atualizar países com base no continente
@app.callback(
    Output('country-selector', 'options'),
    Input('continent-selector', 'value')
)
def update_countries(selected_continents):
    if not selected_continents:
        return [{'label': c, 'value': c} for c in countries]
    filtered = df[df['continent'].isin(selected_continents)]
    country_list = sorted(filtered['location'].unique())
    return [{'label': c, 'value': c} for c in country_list]

if __name__ == '__main__':
    app.run(debug=True, port=8050)