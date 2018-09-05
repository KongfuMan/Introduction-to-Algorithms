package Semaphore;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

//读者优先
public class ReaderAndWriter {
    //boolean isWritting = false; //当前是否有写者正在执行写操作,通过write信号量判断
    int count = 0;  //当前读者的数量

    Semaphore writerMutex = new Semaphore(1);
    Semaphore readerMutex = new Semaphore(1);

    List<Object> Buffer = new LinkedList();

    public void Write(Object c) throws InterruptedException {
        writerMutex.acquire();
        System.out.println("Writer is Writing");
        writerMutex.release();
    }

    public void Read() throws InterruptedException {
        //如果没有写者正在执行，并且有读者正在读取，这直接读
        //如果没有写者正在执行，并且也没没有读者正在读取，则占用一个写者名额
        readerMutex.acquire();
        if (count == 0){
            writerMutex.acquire();
        }
        count++;
        readerMutex.release();

        System.out.println("Reader" + count + "is reading!");

        readerMutex.acquire();
        count--;
        if (count == 0){
            writerMutex.release();
        }
        readerMutex.release();
    }
}
