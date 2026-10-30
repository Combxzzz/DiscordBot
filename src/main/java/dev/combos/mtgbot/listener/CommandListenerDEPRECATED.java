package dev.combos.mtgbot.listener;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class CommandListenerDEPRECATED extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("ping")) {
            long ping = event.getJDA().getGatewayPing();
            event.reply("Pong! \uD83C\uDFD3: " + ping + "ms").queue();
        } else if (event.getName().equals("mtgimage")) {
            File folder = new File("rdimages");
            File[] files = folder.listFiles((dir, name) -> {
                String lower = name.toLowerCase();
                return lower.endsWith(".png") || lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".gif");
            });
            if (files == null || files.length == 0) {
                event.reply("No image found in dir!").setEphemeral(true).queue();
                return;
            }
            int randomIndex = ThreadLocalRandom.current().nextInt(files.length);
            File selectedFile = files[randomIndex];
            event.replyFiles(FileUpload.fromData(selectedFile)).queue();
        } else if (event.getName().equals("captaincp")) {
            File file = new File("images/capitaocp.png");
            if (file.exists()) {
                event.reply("Cannot find image of Captain CP").setEphemeral(true).queue();
                return;
            }
            event.replyFiles(FileUpload.fromData(file)).queue();
        }
    }
}
