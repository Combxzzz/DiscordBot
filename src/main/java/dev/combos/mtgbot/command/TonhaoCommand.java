package dev.combos.mtgbot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;

public class TonhaoCommand implements SlashCommand {
    @Override
    public String getName() {
        return "tonhao";
    }

    @Override
    public String getDescription() {
        return "tonhao \uD83D\uDC4D";
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        File file = new File("imgs/images/tonhao.jpg");
        if (!file.exists()) {
            System.err.println("Cannot find tonhao image.");
            event.reply("Cannot find tonhao image.").setEphemeral(true).queue();
            return;
        }
        event.replyFiles(FileUpload.fromData(file)).queue();
    }
}
