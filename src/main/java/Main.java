import sx.blah.discord.api.IDiscordClient;

public class Main {
    public static void main(String[] args) {
        // Token to use creating IDiscordClient
        var token = "NDk5OTc3MjA5NTI4NzEzMjM3.DqPmcg.KBy7DvilolN3UMmQWIehwts5PQA";
        // IDiscordClient that uses getDiscordClient helper method in BotUtils to create client
        IDiscordClient client = BotUtils.getDiscordClient(token);

        // Registering all @EventSubscribers at BotEvents class
        client.getDispatcher().registerListeners(new BotEvents());
        // Logging in to app
        client.login();
    }
}