package org.example;

public class Counter {

    // 전역 변수
    private static int counter = 0;

    // 전역 변수를 증가시키는 메서드
    public synchronized void increment() {
        counter++;
    }

    public void incrementBlockClass() {
        synchronized (Counter.class){
            counter++;
        }
    }

    public void incrementBlockThis() {
        synchronized (this){
            counter++;
        }
    }

    // 전역 변수 값을 반환하는 메서드
    public static int getCounter() {
        return counter;
    }

    // counter 초기화
    public static void resetCounter() {
        counter = 0;
    }
}
