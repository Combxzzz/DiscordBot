package dev.combos.mtgbot.command;

public class MtgImageCommand extends RandomImageCommandAbstract {
    public MtgImageCommand() {
        super("mtgimage", "Sends a random MTG image from the local collection", "imgs/rdimages");
    }
}
