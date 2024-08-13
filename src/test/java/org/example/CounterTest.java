package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CounterTest {

    private Counter instance;
    private Counter instance2;
    private static Long REP = 1000000L;

    @BeforeEach
    public void setUp() {
        // 인스턴스 초기화 및 counter 리셋
        instance = new Counter();
        instance2 = new Counter();
        Counter.resetCounter();
    }

    @Test
    @DisplayName("단일 스레드 인스턴스 1개 sync 메서드")
    public void a() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance.increment();
            }
        });

        thread.start();
        thread.join();

        assertEquals(REP, Counter.getCounter());
    }

    @Test
    @DisplayName("여러 스레드 인스턴스 1개 sync 메서드")
    public void b() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(REP*2, Counter.getCounter());
    }

    @Test
    @DisplayName("여러 스레드 인스턴스 2개 sync 메서드")
    public void c() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance2.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(REP*2, Counter.getCounter());
    }

    @Test
    @DisplayName("여러 스레드 인스턴스 1개 sync 블럭 class")
    public void d() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance.incrementBlockClass();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance.incrementBlockClass();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(REP*2, Counter.getCounter());
    }

    @Test
    @DisplayName("여러 스레드 인스턴스 2개 sync 블럭 class")
    public void e() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance.incrementBlockClass();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance2.incrementBlockClass();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(REP*2, Counter.getCounter());
    }

    @Test
    @DisplayName("여러 스레드 인스턴스 1개 sync 블럭 this")
    public void f() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance.incrementBlockThis();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance.incrementBlockThis();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(REP*2, Counter.getCounter());
    }

    @Test
    @DisplayName("여러 스레드 인스턴스 2개 sync 블럭 this")
    public void g() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance.incrementBlockThis();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < REP; i++) {
                instance2.incrementBlockThis();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(REP*2, Counter.getCounter());
    }
}
