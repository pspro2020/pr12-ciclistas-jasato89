package com.jasato;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Cyclist implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Cyclist(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        System.out.printf("%s -  %s sale de casa\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2) + 1);
        } catch (InterruptedException e) {
            return;
        }
        System.out.printf("%s -  %s llega a la gasolinera\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), Thread.currentThread().getName());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            return;
        } catch (BrokenBarrierException e) {
            return;
        }
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5)+5);
        } catch (InterruptedException e) {
            return;
        }
        System.out.printf("%s -  %s llega a la venta\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), Thread.currentThread().getName());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            return;
        } catch (BrokenBarrierException e) {
            return;
        }
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5)+5);
        } catch (InterruptedException e) {
            return;
        }
        System.out.printf("%s -  %s Llega a la gasolinera\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), Thread.currentThread().getName());

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            return;
        } catch (BrokenBarrierException e) {
            return;
        }





    }
}
