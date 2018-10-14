import sx.blah.discord.api.IDiscordClient;

public class Main {

    // Gets a provider instance
    public static RiotAPITokenProvider provider = RiotAPITokenProvider.getInstance();

    public static void main(String[] args) {
        // Token to use creating IDiscordClient
        var token = args[0];
        // IDiscordClient that uses getDiscordClient helper method in BotUtils to create client
        IDiscordClient client = BotUtils.getDiscordClient(token);

        // Uses provider instance to set token of riot api
        provider.setTOKEN(args[1]);

        // Registering all @EventSubscribers at BotEvents class
        client.getDispatcher().registerListeners(new BotEvents());
        // Logging in to app
        client.login();
    }
}