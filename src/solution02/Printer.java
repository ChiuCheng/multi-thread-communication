package solution02;

/**
 * use synchronized
 *
 * @author zheng_c
 * @create 2018-08-10 12:12 PM
 */

public class Printer {

    private boolean started = false;

    public synchronized void printNumber() {
        for (int i = 1; i <= 52; i++) {
            System.out.print(i);
            // 每打印两个数字之后交出监视器锁
            if (i % 2 == 0) {
                notifyAll(); //仅仅是唤醒其他线程, 目前还没有释放监视器锁
                try {
                    if (i != 52) wait(); // 释放监视器锁, 若打印的是最后一个数字则直接退出
                } catch (InterruptedException e) {
                    System.out.println("printNumber is interrupted");
                }
            }
        }
    }

    public synchronized void printAlpha() {
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c);
            // 只要打印了一个字母，就交出监视器锁
            notifyAll(); // 先唤醒其他线程
            try {
                if (c != 'Z') wait(); // 释放监视器锁，若打印的是最后一个字母则直接退出。
            } catch (InterruptedException e) {
                System.out.println("printAlpha is interrupted");
            }
        }
    }
}
