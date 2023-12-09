package com.kiva.kivaalmostshader;

import com.fox2code.foxloader.loader.ClientMod;
import com.fox2code.foxloader.registry.CommandCompat;
import com.kiva.commands.BrighterShadows;
import com.kiva.commands.ColorTint;
import com.kiva.commands.Shader;

public class KivaAlmostShaderClient extends KivaAlmostShader implements ClientMod {
    @Override
    public void onInit() {
        CommandCompat.registerClientCommand(new Shader());
        CommandCompat.registerClientCommand(new ColorTint());
        CommandCompat.registerClientCommand(new BrighterShadows());
    }
}
