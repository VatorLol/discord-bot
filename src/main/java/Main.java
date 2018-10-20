import com.merakianalytics.orianna.Orianna;
import sx.blah.discord.api.IDiscordClient;

public class Main {

    public static void main(String[] args) {
        // Creating new configuration file for Orianna framework to setup Riot API Key
        Orianna.Configuration config = new Orianna.Configuration();

        // Token to use creating IDiscordClient
        var token = args[0];
        // IDiscordClient that uses getDiscordClient helper method in BotUtils to create client
        IDiscordClient client = BotUtils.getDiscordClient(token);

        // Registering all @EventSubscribers at BotEvents class
        client.getDispatcher().registerListeners(new BotEvents());
        // Logging in to app
        client.login();
    }
}