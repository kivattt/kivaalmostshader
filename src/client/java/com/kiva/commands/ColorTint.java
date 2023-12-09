package com.kiva.commands;

import com.fox2code.foxloader.network.ChatColors;
import com.fox2code.foxloader.network.NetworkPlayer;
import com.fox2code.foxloader.registry.CommandCompat;

import static com.kiva.kivaalmostshader.KivaAlmostShader.colorTintEnabled;

public class ColorTint extends CommandCompat {
    public ColorTint(){super("colortint", false);}

    public String commandSyntax(){
        return ChatColors.YELLOW + "/colortint";
    }

    @Override
    public void onExecute(String[] args, NetworkPlayer commandExecutor) {
        colorTintEnabled ^= true;
        commandExecutor.displayChatMessage((colorTintEnabled ? ChatColors.GREEN : ChatColors.RED) + "[KivaAlmostShader] Color tint " + (colorTintEnabled ? "enabled" : "disabled"));
    }
}
