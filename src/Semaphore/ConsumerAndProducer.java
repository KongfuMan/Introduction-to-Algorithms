package Semaphore;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

//使用semaphore来模拟消费者和生产生模式
public class ConsumerAndProducer {
    int numMax = 10;
    Queue<Object> Buffer = new LinkedList();
    Semaphore mutex = new Semaphore(1); //所有个体互斥信号量
    Semaphore fullSem = new Semaphore(0); //当前有多少个产品
    Semaphore emptySem = new Semaphore(numMax); //当前有多少个空位来放置产品

    //生产者放置物品
    public void Deposit(Object c) throws InterruptedException {
        emptySem.acquire(); //如果没有空位就等待
        mutex.acquire();
        Buffer.offer(c);
        System.out.println("生产者添加了1个产品,当前有"+ Buffer.size() +"个商品");
        fullSem.release();  //当前产品数+1
        mutex.release();

    }

    //消费者消费产品
    public void Remove() throws InterruptedException {
        fullSem.acquire();  //没有产品时等待
        mutex.acquire();
        Buffer.poll();
        System.out.println("消费者消费了1个产品,当前有"+ Buffer.size() +"个商品");
        emptySem.release(); //空位+1
        mutex.release();
    }
}
