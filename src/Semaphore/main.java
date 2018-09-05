package Semaphore;

import static java.lang.Thread.sleep;

public class main {
    private static ConsumerAndProducer t = new ConsumerAndProducer();

    public static void main(String[] args){
        for (int i = 0; i < 15; i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(100);
                        t.Deposit(new Integer(1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread thread = new Thread(task);
            thread.start();
        }

        for (int i = 0; i < 15; i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(10);
                        t.Remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thread = new Thread(task);
            thread.start();
        }

    }
}
