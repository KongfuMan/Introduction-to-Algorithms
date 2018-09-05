package Monitors;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WriterAndReader {
    int AW = 0; //正在执行的写者数量
    int AR = 0; //正在执行的读者数量
    int WR = 0; //正在等待的读者数量
    int WW = 0; //    等待的写者数量

    Lock lock = new ReentrantLock();
    Condition write = lock.newCondition();
    Condition read = lock.newCondition();

    public void Write() throws InterruptedException {
        lock.lock();
        while (AW > 0 || AR > 0){   //有正在执行的写者与读者时 等待
            WW++;
            write.await();  //等待时，会释放锁，等该线程被唤醒时候重新获得锁
            WW--;
        }
        AW++;

        //write();  //写的时候是互斥的

        AW--;
        if (WW > 0){
            write.signal();
        }
        if (WW == 0 && AW == 0){
            read.signalAll();
        }
        lock.unlock();
    }

    public void read() throws InterruptedException {
        lock.lock();
        while(AW > 0 || WW > 0){    //有正在执行的写者和等待的写者时 等待
            WR++;
            read.await();
            WR--;
        }
        AR++;
        lock.unlock();

        //read()    //读的时候不是互斥的

        lock.lock();
        AR--;
        if (AR == 0){    //没有正在执行的读者，就可以写了
            write.signal();
        }
        lock.unlock();
    }
}
