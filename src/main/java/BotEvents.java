import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;


public class BotEvents {

    /**
     * A helper method to handle all kinds of command
     *
     * @param event message event that happened
     */
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event){
        String[] messageContent;
        String command;
        String message = "";
        // Checking if message is a command through BOT_PREFIX
        if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX)){
            // If is a command, the first piece of the message is taken
            messageContent = event.getMessage().getContent().split(" ", 2);
            // Taking the first piece and deleting the prefix
            command = messageContent[0].substring(1);
            // Taking the message part(if exists) and assigning to a variable
            if (messageContent.length > 1)
                message = messageContent[1];
            // Making it to upperCase to prevent any spelling mistakes(e.g. pIng, pinG)
            command = command.toUpperCase();

            // Using switch-case statement to determine what to do with the command
            switch (command){
                case "PING": BotUtils.sendMessage(event.getChannel(), "Pong!"); break;
                case "META": BotUtils.sendEmbedMessage(event.getChannel(), message.toUpperCase()); break;
                default: break;
            }
        }
    }
}
