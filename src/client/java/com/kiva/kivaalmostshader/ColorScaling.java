package com.kiva.kivaalmostshader;

import static com.kiva.kivaalmostshader.KivaAlmostShader.brighterShadows;

public class ColorScaling {
    public static double exaggerateContrast(double n){
        if (brighterShadows && n < 0.487)
            return n;

        n += 0.4;
        return n * n * n * n * n * n;
    }

    public static double scaleGreen(double g){
        return (g + g*g*g) / 2;
    }

    // "dark" one
    public static double darkerMoment(double n){
        return (n*n*n) - 0.01;
    }

    public static double scaleRed(double r){
        return Math.sqrt(r);
    }
}
