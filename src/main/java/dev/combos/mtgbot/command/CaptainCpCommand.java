package dev.combos.mtgbot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;

public class CaptainCpCommand implements SlashCommand {
    @Override
    public String getName() {
        return "captaincp";
    }

    @Override
    public String getDescription() {
        return "Captain Cp...";
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        File file = new File("imgs/images/capitaocp.png");
        if (!file.exists()) {
            event.reply("Cannot find image of Captain CP").setEphemeral(true).queue();
            return;
        }
        event.replyFiles(FileUpload.fromData(file)).queue();
    }
}
