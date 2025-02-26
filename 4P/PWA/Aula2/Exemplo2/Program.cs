using System;
using Microsoft.Data.Sqlite;

namespace Aula2 
{
    public class Program
    {
        public static void Main(string[] args)
        {
             var connectionString = @"Data Source=db\app.db";

            //  using (var conexao = new SqliteConnection(connectionString))
            //  {
            //     conexao.Open();

            //     var cmd = conexao.CreateCommand();
            //     cmd.CommandText = "INSERT INTO contatos (id, nome, email) VALUES (@id, @nome, @email)";

            //     cmd.Parameters.AddWithValue("id", 4);
            //     cmd.Parameters.AddWithValue("nome", "William");
            //     cmd.Parameters.AddWithValue("email", "william.silva@viannasempre.com.br");

            //     var retorno = cmd.ExecuteNonQuery();

            //     Console.WriteLine($"Comando executado com sucesso. {retorno} linhas alteradas.");

            //     //conexao.Close(); O using fecha a conexão automaticamente liberando os recursos.
            //  }

             using (var conexao = new SqliteConnection(connectionString))
             {
                conexao.Open();

                var cmd = conexao.CreateCommand();
                cmd.CommandText = "SELECT nome, email FROM contatos";

                using (var dr = cmd.ExecuteReader()) 
                {
                    while (dr.Read()) 
                    {
                        Console.WriteLine($"{dr["nome"]}: {dr["email"]}");
                    }
                }
             }

        }
    }
}
