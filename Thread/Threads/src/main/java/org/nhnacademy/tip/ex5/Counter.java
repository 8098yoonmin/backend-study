package org.nhnacademy.tip.ex5;

public class Counter {
    int count;
    int anotherCount;
    public Counter() {
        count = 0;
        anotherCount = 0;
    }

    public void increment() {
        synchronized (this) {
            ++count;
        }
        ++anotherCount;
    }
    public void decrement() {
        synchronized (this) {
            --count;
        }
        --anotherCount;
    }

    public synchronized long getCount() {
        return count;
    }

    public synchronized long getAnotherCount() {
        return anotherCount;
    }
}
