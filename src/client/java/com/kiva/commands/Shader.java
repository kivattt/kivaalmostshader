package com.kiva.commands;

import com.fox2code.foxloader.network.ChatColors;
import com.fox2code.foxloader.network.NetworkPlayer;
import com.fox2code.foxloader.registry.CommandCompat;
import static com.kiva.kivaalmostshader.KivaAlmostShader.shaderEnabled;

public class Shader extends CommandCompat {
    public Shader(){super("shader", false);}

    public String commandSyntax(){
        return ChatColors.YELLOW + "/shader";
    }

    @Override
    public void onExecute(String[] args, NetworkPlayer commandExecutor){
        shaderEnabled ^= true;
        commandExecutor.displayChatMessage((shaderEnabled ? ChatColors.GREEN : ChatColors.RED) + "KivaAlmostShader " + (shaderEnabled ? "enabled" : "disabled") + ChatColors.RESET);
    }
}
