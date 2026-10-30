package dev.combos.mtgbot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class PingCommand implements SlashCommand {
    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Replies with pong";
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        long ping = event.getJDA().getGatewayPing();
        event.reply("Pong! \uD83C\uDFD3: " + ping + "ms").queue();
    }
}
