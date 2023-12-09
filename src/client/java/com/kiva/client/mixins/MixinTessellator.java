package com.kiva.client.mixins;

import net.minecraft.src.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.ByteOrder;

import static com.kiva.kivaalmostshader.ColorScaling.*;
import static com.kiva.kivaalmostshader.KivaAlmostShader.colorTintEnabled;
import static com.kiva.kivaalmostshader.KivaAlmostShader.shaderEnabled;

@Mixin(Tessellator.class)
public class MixinTessellator {
    @Shadow private boolean isColorDisabled;
    @Shadow private boolean renderingChunk;
    @Shadow private int color;

    // A glorified @Overwrite, we just replace everything and ci.cancel() lol
    //@Inject(method = "setColorRGBA", at = @At("HEAD"), cancellable = true)
    @Overwrite
    public void setColorRGBA(int r, int g, int b, int a){
        if (!shaderEnabled)
            return;

        if (isColorDisabled)
            return;

        // r, g, b are usually the exact same so lets avoid re-calculating
        int newBrightness = (int) (exaggerateContrast((double) r / 255) * 255);
        //int newBrightness = (int) (darkerMoment((double) r / 255) * 255);

        r = newBrightness;
        //g = newBrightness;
        if (!colorTintEnabled) {
            //r = newBrightness;
            g = newBrightness;
        } else {
            //r = (int) (scaleRed((double) newBrightness / 255) * 255);
            g = (int) (scaleGreen((double) newBrightness / 255) * 255);
        }
        b = newBrightness;

        if (r > 255) {
            r = 255;
        }

        if (g > 255) {
            g = 255;
        }

        if (b > 255) {
            b = 255;
        }

        if (a > 255) {
            a = 255;
        }

        if (r < 0) {
            r = 0;
        }

        if (g < 0) {
            g = 0;
        }

        if (b < 0) {
            b = 0;
        }

        if (a < 0) {
            a = 0;
        }

        if (!renderingChunk) {
            GL11.glColor4ub((byte)r, (byte)g, (byte)b, (byte)a);
        } else if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            color = a << 24 | b << 16 | g << 8 | r;
        } else {
            color = r << 24 | g << 16 | b << 8 | a;
        }
    }
}
