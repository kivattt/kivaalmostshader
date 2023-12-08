package com.kiva.kivaalmostshader;

public class ColorScaling {
    public static double exaggerateContrast(double n){
        return n <= 0.4587 ? Math.pow(n + 0.25, 4) : 6*n - 2.5;
        //return n <= 0.4337 ? Math.pow(n + 0.25, 6) : 6*n - 2.5;
        //return n <= 0.452 ? Math.pow(n + 0.35, 7) : 6*n - 2.5;
        //return n <= 0.4592 ? Math.pow(n + 0.4, 9) : 6*n - 2.5;
    }

    public static double scaleGreen(double g){
        //return g < 0.15 ? g : (g + g*g*g) / 2;
        if (g < 0.6)
            return (g + g*g*g) / 2 + (1 - Math.pow(g + 0.05, 0.1)) / 3;
        return (g + g*g*g) / 2;
    }
}
