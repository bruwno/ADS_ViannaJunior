import numpy as np
import matplotlib.pyplot as fig
from matplotlib import animation, cm
import random

fig.close('all')  # fecha figuras existentes

n = 80              # números de linhas
m = 80              # número de colunas

# inicializa com zeros
a = np.zeros((n+1,m+1))
novo_a = np.zeros((n+1,m+1))

#ESTRUTURA INICIAL
# a[4,1]=1
# a[4,2]=1
# a[6,2]=1 
# a[5,3]=1
# a[5,4]=1
# a[4,5]=1
# a[6,5]=1
# a[6,1]=1
# a[5,6]=1

#ESTRUTURA glider (planador)
# a[3,1]=1
# a[1,2]=1
# a[3,2]=1 
# a[2,3]=1
# a[3,3]=1

#ESTRUTURA spaceship
######## escolha da estrutura spaceship (espaçonave) ######
# a[2,10]=1
# a[3,10]=1
# a[4,10]=1 
# a[1,11]=1
# a[4,11]=1
# a[4,12]=1
# a[4,13]=1
# a[1,14]=1
# a[3,14]=1

#ESTRUTURA Pulsar
# a[15,30]=a[15,31]=a[15,32]=1
# a[16,30]=a[17,30]=a[18,30]=a[19,30]=1
# a[19,31]=a[19,32]=1
# a[16,32]=a[17,32]=a[18,32]=1

#ESTRUTURA Glider gun
a[5,1]=a[5,2]=1
a[6,1]=a[6,2]=1
a[3,13]=a[3,14]=1
a[4,12]=a[4,16]=1
a[5,11]=a[5,17]=1
a[6,11]=a[6,15]=a[6,17]=a[6,18]=1
a[7,11]=a[7,17]=1
a[8,12]=a[8,16]=1
a[9,13]=a[9,14]=1
a[1,25]=1
a[2,23]=a[2,25]=1
a[3,21]=a[3,22]=1
a[4,21]=a[4,22]=1
a[5,21]=a[5,22]=1
a[6,23]=a[6,25]=1
a[7,25]=1
a[3,35]=a[3,36]=1
a[4,35]=a[4,36]=1

for ger in range(50):
    for i in range(1,n):
        for j in range(1,m):
            vizinho = 0 # condição de fronteira, todos os elementos que estiverem na borda valem zero.

            if a[i-1,j-1]==1:
                    vizinho=vizinho+1                       
            if a[i,j-1]==1:
                    vizinho=vizinho+1                          
            if a[i+1,j-1]==1:
                    vizinho=vizinho+1                       
            if a[i+1,j]==1:
                    vizinho=vizinho+1                       
            if a[i+1,j+1]==1:
                    vizinho=vizinho+1                       
            if a[i,j+1]==1:
                    vizinho=vizinho+1                       
            if a[i-1,j+1]==1:
                    vizinho=vizinho+1                      
            if a[i-1,j]==1:
                    vizinho=vizinho+1
            # REGRAS                          
            if a[i,j]==1:
                if (vizinho==2) or (vizinho==3): ### se célula viva com 2
                       novo_a[i,j]=1             ### ou 3 vizinhos, permanece
                else:                            ### viva
                       novo_a[i,j]=0
            else:
                if vizinho==3:                   ### se espaço vazio com 2
                      novo_a[i,j]=1              ### ou 3 vizinhos, nasce
                else:
                      novo_a[i,j]=0              ### se espaço vazio com 1 ou 
                                                 ### 4 viz, permanece vazio
    a=novo_a                                     
    novo_a=np.zeros((n+1,m+1))                   ### atualiza a regra
            
    # EXIBINDO A MATRIZ
    fig.title('GERAÇÃO %d' % ger, fontsize=20)
    fig.xticks([])            # esconde os numeros do eixo x
    fig.yticks([])            # esconde os números do eixo y
    im = fig.imshow(a, interpolation = "nearest", cmap='Greys', animated=True)
    mgr = fig.get_current_fig_manager() # imagem gerada in the little window
    mgr.window.setGeometry = (20, 20, 1000, 1000) # janela fixa
    fig.pause(0.1)            # pausa para ver as células se moverem