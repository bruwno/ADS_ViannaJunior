var meuObj = new { Nome = "Blá", Teste = "Blé" };

Console.WriteLine(meuObj.Nome + " - " + meuObj.Teste);





// using Exemplo3.Models;

// var obj = new Contato
// {
//     Id = 1,
//     Nome = "Ana",
//     Email = "ana@email.com"
// };

// //Reflection

// var tipo = obj.GetType();

// var propriedade = tipo.GetProperty("Nome");

// propriedade.SetValue(obj, "Ana Maria");

// var valorPropriedade = propriedade.GetValue(obj);

// Console.WriteLine(valorPropriedade);






















// using Dapper;
// using Exemplo3.Models;
// using Microsoft.Data.Sqlite;

// var conectionString = @"Data Source=db\app.db";

// using (var conexao = new SqliteConnection(conectionString))
// {
//     conexao.Open();

//     var obj = new Contato
//     {
//         Id = 1,
//         Nome = "Ana",
//         Email = "ana@email.com"
//     };

//     var sql = "INSERT INTO contato (id, nome, email)" + 
//         " VALUES (@Id, @Nome, @Email)";

//     conexao.Execute(sql, obj);
// }









// using (var conexao = new SqliteConnection(conectionString))
// {
//     conexao.Open();

//     var cmd = conexao.CreateCommand();
//     cmd.CommandText = "INSERT INTO contato (id, nome, email) VALUES (@id, @nome, @email)";

//     cmd.Parameters.AddWithValue("id", 4);
//     cmd.Parameters.AddWithValue("nome", "João");
//     cmd.Parameters.AddWithValue("email", "joao@email.com");

//     var retorno = cmd.ExecuteNonQuery();

//     Console.WriteLine($"Comando executado com sucesso. {retorno} linhas alteradas.");
// }
