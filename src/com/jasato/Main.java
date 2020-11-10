package com.jasato;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static final int CYCLISTS = 10;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CYCLISTS, new CyclistCounter());

        for (int i = 0; i < CYCLISTS; i++) {
            new Thread(new Cyclist(cyclicBarrier)).start();

        }



    }
}
