package dev.combos.mtgbot;

import dev.combos.mtgbot.command.*;
import dev.combos.mtgbot.listener.CommandManager;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("DISCORD_TOKEN");

        if (token == null || token.isBlank()) {
            System.err.println("Error: DISCORD_TOKEN is not defined in .env file!");
            return;
        }

        CommandManager commandManager = new CommandManager();

        commandManager.addCommand(new PingCommand());
        commandManager.addCommand(new MtgImageCommand());
        commandManager.addCommand(new CaptainCpCommand());
        commandManager.addCommand(new TonhaoCommand());
        commandManager.addCommand(new TilaNegoCommand());
        commandManager.addCommand(new ProbabilityCommand());

        JDA jda = JDABuilder.createDefault(token)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.playing("MTG Gang"))
                .addEventListeners(commandManager)
                .build()
                .awaitReady();

        jda.updateCommands().addCommands(
                commandManager.getCommandData()
        ).queue();
    }
}
