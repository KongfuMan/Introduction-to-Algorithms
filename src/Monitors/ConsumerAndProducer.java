package Monitors;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerAndProducer {
    List<Object> Buffer = new LinkedList();
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    int count = 0;  //当前的商品数量
    int numMax = 10;

    public void Deposit(Object c) throws InterruptedException {
        lock.lock();
        while(count == numMax){
            System.out.println("生产者被阻塞");
            notFull.await();
        }
        Buffer.add(c);
        count++;
        System.out.println("生产者添加了1个产品,当前有"+ count +"个商品");
        notEmpty.signal();
        lock.unlock();
    }

    public void Remove() throws InterruptedException {
        lock.lock();
        while(count == 0){
            System.out.println("消费者被阻塞");
            notEmpty.await();
        }
        Buffer.remove(count - 1);
        count--;
        System.out.println("消费者消费了1个产品,当前有"+ count +"个商品");
        notFull.signal();
        lock.unlock();
    }

}
