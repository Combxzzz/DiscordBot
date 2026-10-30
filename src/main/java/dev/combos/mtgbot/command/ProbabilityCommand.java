package dev.combos.mtgbot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.concurrent.ThreadLocalRandom;

public class ProbabilityCommand implements SlashCommand {
    @Override
    public String getName() {
        return "chance";
    }

    @Override
    public String getDescription() {
        return "See the chance of a question.";
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        String question = event.getOption("question").getAsString();
        int chance = ThreadLocalRandom.current().nextInt(101);
        event.reply("🎲 A probabilidade de **\"" + question + "\"** acontecer é de **" + chance + "%**!").queue();
    }

    @Override
    public SlashCommandData getCommandData() {
        return Commands.slash(getName(), getDescription())
                .addOption(OptionType.STRING, "question", "For what do you want to calculate the probability?", true);
    }
}
