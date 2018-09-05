package Semaphore;

import java.util.concurrent.Semaphore;

public class WriterAndReader {
    //读者：正在写 || 有写者在等待队列 就阻塞， 否则执行读操作
    //写者：正在写 || 正在读 就阻塞 否则执行写操作

    Semaphore writerMutex = new Semaphore(1); //写者互斥

    int AW = 0;  //等待队列中写者的个数





    public void Write() throws InterruptedException {
        writerMutex.acquire();
        //write();
        writerMutex.release();
    }

    public void Read(){

    }
}
