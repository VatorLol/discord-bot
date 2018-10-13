import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.internal.json.objects.EmbedObject;
import sx.blah.discord.handle.impl.obj.Embed;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IEmbed;
import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RequestBuffer;

import java.util.HashMap;

public class BotUtils {

    // EmbedObject map for adding to EmbedBuilder
    private static HashMap<String, Embed.EmbedField> ROLES = new HashMap<>();

    // Constant for the bot prefix
    public static String BOT_PREFIX = "/";

    /**
     * Creates an IDiscordClient with the given token
     *
     * @param token token of the discord app you want to connect to
     * @return IDiscordClient with the given token
     */
    public static IDiscordClient getDiscordClient(String token) {
        // Initializes map
        initializeMap();
        // ClientBuilder to create IDiscordClient with the given token
        return new ClientBuilder().withToken(token).build();
    }

    /**
     * A helper method to send the given message to given Channel
     *
     * @param channel        the channel to send the message
     * @param messageContent the message user wants to send
     */
    public static void sendMessage(IChannel channel, String messageContent) {
        // Creates a request
        RequestBuffer.request(() -> {
            // Sends a message to the channel
            channel.sendMessage(messageContent);
        });
    }

    /**
     * A helper method to send embed message
     *
     * @param channel channel which embed message sent
     */
    public static void sendEmbedMessage(IChannel channel, String message) {
        // Creates an EmbedBuilder
        EmbedBuilder builder = new EmbedBuilder();

        // Sets the builder's title
        builder.withTitle("Meta Champions");
        // Sets the builder's description
        builder.withDescription("Meta champions of 8.20 Patch");

        // Sets the fields of builder
        if (message.contains("TOP"))
            builder.appendField(ROLES.get("TOP"));
        else if (message.contains("JUNGLE"))
            builder.appendField(ROLES.get("JUNGLE"));
        else if (message.contains("MID"))
            builder.appendField(ROLES.get("MID"));
        else if (message.contains("ADC"))
            builder.appendField(ROLES.get("ADC"));
        else if (message.contains("SUPPORT"))
            builder.appendField(ROLES.get("SUPPORT"));
        // If message doesn't contain any specification then below method would add all the fields
        else if (message.isEmpty())
            builder = appendAllFields(builder);
        else
            builder = appendAllFields(builder);
        // Sends the EmbedMessage
        channel.sendMessage(builder.build());
    }

    /**
     * Helper method to initialize map
     */
    private static void initializeMap(){
        ROLES.put("TOP", new Embed.EmbedField("TOP", "Urgot\nCamille\nSion\nOrnn", true));
        ROLES.put("JUNGLE", new Embed.EmbedField("JUNGLE", "Gragas\nSkarner\nTaliyah\nCamille", true));
        ROLES.put("MID", new Embed.EmbedField("MID", "Kassadin\nRyze\nSyndra\nIrelia", true));
        ROLES.put("ADC", new Embed.EmbedField("ADC", "Varus\nKai'sa\nXayah\nJhin", true));
        ROLES.put("SUPPORT", new Embed.EmbedField("SUPPORT", "Alistar\nThresh\nRakan\nTahm Kench", true));
    }

    /**
     * A helper method to put all fields
     *
     * @return returns an EmbedBuilder wth given fields
     */
    private static EmbedBuilder appendAllFields(EmbedBuilder builder){
        builder.appendField(ROLES.get("TOP"));
        builder.appendField(ROLES.get("JUNGLE"));
        builder.appendField(ROLES.get("MID"));
        builder.appendField(ROLES.get("ADC"));
        builder.appendField(ROLES.get("SUPPORT"));

        return builder;
    }
}
