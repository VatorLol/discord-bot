import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.RequestBuffer;

public class BotUtils {

    // Constant for the bot prefix
    public static String BOT_PREFIX = "/";

    /**
     * Creates an IDiscordClient with the given token
     *
     * @param token token of the discord app you want to connect to
     *
     * @return IDiscordClient with the given token
     */
    public static IDiscordClient getDiscordClient(String token) {
        // ClientBuilder to create IDiscordClient with the given token
        return new ClientBuilder().withToken(token).build();
    }

    /**
     * A helper method to send the given message to given Channel
     * @param channel the channel to send the message
     * @param messageContent the message user wants to send
     * */
    public static void sendMessage(IChannel channel, String messageContent){
        // Creates a request
        RequestBuffer.request(() -> {

            // Sends a message to the channel
            channel.sendMessage(messageContent);
        });
    }

}
