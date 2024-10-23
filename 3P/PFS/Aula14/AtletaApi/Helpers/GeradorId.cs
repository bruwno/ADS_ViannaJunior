namespace AtletaApi;
using SnowflakeGenerator;

public static class GeradorId
{
    static GeradorId()
    {
        Settings settings = new Settings 
        { 
            MachineID = 1,
            CustomEpoch = new DateTimeOffset(2024, 1, 1, 0, 0, 0, TimeSpan.Zero) 
        };
    
        snowflake = new Snowflake(settings);
    }

    public static long GetId() => snowflake.NextID();

    private static readonly Snowflake snowflake;
}
