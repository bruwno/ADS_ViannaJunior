using System;
using System.Reflection;
using System.Text.Json;
using Aula1.Models;

namespace Aula1.Endpoints;

public static class AtletaEndpoints
{
    private static readonly IList<Atleta> objetos;
    private static readonly string caminho;

    static AtletaEndpoints()
    {
        caminho = Path.Combine(
            Path.GetDirectoryName(
                Assembly.GetExecutingAssembly().Location)!,
                "dados",
                "atletas.json"
                );

        if (!File.Exists(caminho)) 
        {
            objetos = [];
            return;
        }

        var conteudo = File.ReadAllText(caminho);

        if (string.IsNullOrEmpty(conteudo)) 
        {
            objetos = [];
            return;
        }

        objetos = JsonSerializer.Deserialize<IList<Atleta>>(conteudo) ?? [];
    }

    private static IResult Get() 
    {
        return objetos is not null ? TypedResults.Ok(objetos) 
                                   : TypedResults.NotFound();
    }

    private static IResult GetById(long id)
    {
        var obj = objetos.FirstOrDefault(x => x.Id == id);
        return obj is null ? TypedResults.NotFound() 
                           : TypedResults.Ok(obj);
    }

    private static IResult Post(Atleta obj)
    {
        obj.Id = objetos.Count == 0 ? 1 : objetos.Max(x => x.Id) + 1;
        objetos.Add(obj);
        SalvarDados();
        return TypedResults.Created($"/atletas/{obj.Id}", obj);
    }

    private static void SalvarDados() 
    {
        File.WriteAllText(caminho, JsonSerializer.Serialize(objetos));
    }

}
