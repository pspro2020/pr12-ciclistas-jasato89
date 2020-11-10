package com.jasato;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclistCounter implements Runnable{

    private int count = 0;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    @Override
    public void run() {

        switch (count) {

            case 0:
                System.out.printf("¡¡¡%s - %s :Comienza la etapa!!!\n", LocalDateTime.now().format(formatter), Thread.currentThread().getName());
                break;
            case 1:
                System.out.printf("¡¡¡%s - %s :De vuelta a casa!!!\n", LocalDateTime.now().format(formatter), Thread.currentThread().getName());
                break;
            case 2:
                System.out.printf("¡¡¡%s - %s : Etapa finalizada!!!\n", LocalDateTime.now().format(formatter), Thread.currentThread().getName());
                break;
            default:
                System.out.println("Error");
        }
        count++;
    }
}
