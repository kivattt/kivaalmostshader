package com.kiva.commands;

import com.fox2code.foxloader.network.ChatColors;
import com.fox2code.foxloader.network.NetworkPlayer;
import com.fox2code.foxloader.registry.CommandCompat;

import static com.kiva.kivaalmostshader.KivaAlmostShader.brighterShadows;

public class BrighterShadows extends CommandCompat {
    public BrighterShadows(){super("brightershadows", false);}

    public String commandSyntax(){
        return ChatColors.YELLOW + "/brightershadows";
    }

    @Override
    public void onExecute(String[] args, NetworkPlayer commandExecutor) {
        brighterShadows ^= true;
        commandExecutor.displayChatMessage((brighterShadows ? ChatColors.GREEN : ChatColors.RED) + "[KivaAlmostShader] Brighter shadows " + (brighterShadows ? "enabled" : "disabled"));
    }
}
