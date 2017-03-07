package examples.thread;

/**
 * Created by apomazkin on 07.03.2017.
 */
public class ThreadExample_06_Buffer {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Producer(1, 10000, buffer)).start();
        new Thread(new Comsumer(buffer)).start();
    }
}

class Producer implements Runnable {

    private int startValue;
    private final int period;
    private final SingleElementBuffer buffer;

    public Producer(int startValue, int period, SingleElementBuffer buffer) {
        this.startValue = startValue;
        this.period = period;
        this.buffer = buffer;
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(startValue + " produced");
                buffer.put(startValue++);
                Thread.sleep(period);
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}

class Comsumer implements Runnable {

    private final SingleElementBuffer buffer;

    public Comsumer(SingleElementBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int elem = buffer.get();
                System.out.println(elem + " consumed");
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

/**
 * Есть два множества: wait-set и blocked-set
 * Поток A обращается к методу/переменной, которая помечается как blocked.
 * Поток B обращается к методу/переменной, но так как метод помечен как blocked,
 * то поток попадает в blocked-set.
 * Когда поток А уходит из метода, метод освобождается
 * и система выбирает любой из потоков в blocked-set для выполнения,
 * метод снова помечается как blocked.
 */
class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(Integer newElem) throws InterruptedException {
        while (elem != null) {
            this.wait();
        }
        this.elem = newElem;
        this.notifyAll();
    }

    public synchronized Integer get() throws InterruptedException {
        while (elem == null) {
            this.wait();
        }
        int result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
