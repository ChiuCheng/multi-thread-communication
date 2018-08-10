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
                    wait(); //释放监视器锁
                } catch (InterruptedException e) {
                    System.out.println("printNumber is interrupted");
                }
            }
        }
    }

    public synchronized void printAlpha() {
        // 这个if语句只是为了确保数字线程先被运行
        if(!started) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("printAlpha is interrupted");
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c);
            notifyAll();
            try {
                if (c != 'Z') wait(); //最后一个`Z`不需要再wait
            } catch (InterruptedException e) {
                System.out.println("printAlpha is interrupted");
            }
        }
    }
}
