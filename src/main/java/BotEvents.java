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
        if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX)){
            messageContent = event.getMessage().getContent().split(" ");
            command = messageContent[0].substring(1);
            command = command.toUpperCase();

            switch (command){
                case "PING": BotUtils.sendMessage(event.getChannel(), "Pong!");

                default: break;
            }
        }
    }
}
