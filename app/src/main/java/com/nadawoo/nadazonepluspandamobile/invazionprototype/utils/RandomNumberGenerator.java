package com.nadawoo.nadazonepluspandamobile.invazionprototype.utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static int randomGenerator(){
        int min = 0;
        int max = 122;
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
