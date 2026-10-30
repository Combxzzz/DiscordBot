package dev.combos.mtgbot.listener;

import dev.combos.mtgbot.command.SlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager extends ListenerAdapter {
    private final Map<String, SlashCommand> commands = new HashMap<>();

    public void addCommand(SlashCommand command) {
        commands.put(command.getName(), command);
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        SlashCommand command = commands.get(event.getName());
        if (command != null) {
            command.execute(event);
        }
    }

    public List<SlashCommandData> getCommandData() {
        List<SlashCommandData> dataList = new ArrayList<>();
        for (SlashCommand cmd : commands.values()) {
            dataList.add(cmd.getCommandData());
        }
        return dataList;
    }
}
