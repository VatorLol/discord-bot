import sx.blah.discord.api.IDiscordClient;

public class Main {
    public static void main(String[] args) {
        var token = "NDk5OTc3MjA5NTI4NzEzMjM3.DqPmcg.KBy7DvilolN3UMmQWIehwts5PQA";
        IDiscordClient client = BotUtils.getDiscordClient(token);

        client.getDispatcher().registerListeners(new BotEvents());
        client.login();
    }
}