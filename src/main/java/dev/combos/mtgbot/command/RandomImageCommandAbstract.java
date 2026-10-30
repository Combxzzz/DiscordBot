package dev.combos.mtgbot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public abstract class RandomImageCommandAbstract implements SlashCommand {
    private final String name;
    private final String description;
    private final String folderPath;

    public RandomImageCommandAbstract(String name, String description, String folderPath) {
        this.name = name;
        this.description = description;
        this.folderPath = folderPath;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        File folder = new File(this.folderPath);
        File[] files = folder.listFiles((dir, fileName) -> {
            String lower = fileName.toLowerCase();
            return lower.endsWith(".png") || lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".gif");
        });

        if (files == null || files.length == 0) {
            event.reply("No images found in folder: " + this.folderPath).setEphemeral(true).queue();
            return;
        }

        int randomIndex = ThreadLocalRandom.current().nextInt(files.length);
        File selectedFile = files[randomIndex];

        event.replyFiles(FileUpload.fromData(selectedFile)).queue();
    }
}
