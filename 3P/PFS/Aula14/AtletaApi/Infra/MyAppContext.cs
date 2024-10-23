using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;

namespace AtletaApi;

public class AppContext : DbContext
{
    public DbSet<Atleta> Atletas { get; set; }

    public string DbPath { get; }

    public AppContext()
    {
        var folder = Environment.SpecialFolder.LocalApplicationData;
        var path = Environment.GetFolderPath(folder);
        DbPath = System.IO.Path.Join(path, "app.db");
    }

    // The following configures EF to create a Sqlite database file in the
    // special "local" folder for your platform.
    protected override void OnConfiguring(DbContextOptionsBuilder options)
        => options.UseSqlite($"Data Source={DbPath}");
}
