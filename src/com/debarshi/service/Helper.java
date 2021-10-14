package com.debarshi.service;

import java.util.List;
import java.util.Random;

public class Helper {
    public static int[] generateTwoRandom(int range) {
        int rand1 = (int)(Math.random() * (range -1));
        int rand2 = rand1;
        while (rand2 == rand1) {
            rand2 = (int)(Math.random() * (range -1));
        }
        return new int[] {rand1, rand2};
    }

    public static int generateSingleRandom(List<Integer> list) {
        Random random = new Random();
        int rand = random.nextInt(list.size());
        return list.get(rand);
    }

}
