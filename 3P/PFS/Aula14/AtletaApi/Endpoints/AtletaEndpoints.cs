
using System.Reflection;
using System.Text.Json;

namespace AtletaApi;

public static class AtletaEndpoints
{
    
    internal static void AdicionarAtletaEndpoints(this WebApplication app)
    {
        app.MapGet("/atletas", Get);
        app.MapGet("/atletas/{id}", GetById);
        app.MapPost("/atletas", Post);
        app.MapPut("/atletas/{id}", Put);
        app.MapDelete("/atletas/{id}", Delete);
    }

    public static IResult Get(MyAppContext contexto)
    {
        return TypedResults.Ok(contexto.Atletas.ToList());
    }

    public static IResult GetById(long id, MyAppContext contexto)
    {
        var obj = contexto.Atletas.Find(id);

        if (obj == null)
            return TypedResults.NotFound();

        return TypedResults.Ok(obj);
    }
    
    public static IResult Post(Atleta obj, MyAppContext contexto)
    {
        obj.Id = GeradorId.GetId();
        
        contexto.Atletas.Add(obj);
        contexto.SaveChanges();
        
        return TypedResults.Created($"/atletas/{obj.Id}", obj);
    }

    public static IResult Put(long id, Atleta novoObjeto, MyAppContext contexto)
    {
        if (novoObjeto == null || novoObjeto.Id != id)
            return TypedResults.BadRequest();

        var obj = contexto.Atletas.Find(id);

        if (obj == null)
            return TypedResults.NotFound();

        obj.Nome = novoObjeto.Nome;
        obj.Altura = novoObjeto.Altura;
        obj.Peso = novoObjeto.Peso;

        contexto.SaveChanges();

        return TypedResults.NoContent();
    }

    public static IResult Delete(long id, MyAppContext contexto)
    {
        var obj = contexto.Atletas.Find(id);

        if (obj == null)
            return TypedResults.NotFound();

        contexto.Atletas.Remove(obj);

        contexto.SaveChanges();

        return TypedResults.NoContent();
    }
}
