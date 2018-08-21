package solution02;

/**
 * @author zheng_c
 * @create 2018-08-10 12:24 PM
 */

public class Solution02 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printNumber = new Thread(()-> printer.printNumber());
        Thread printAlpha = new Thread(() -> printer.printAlpha());
        printNumber.start();
        printAlpha.start();
    }
}
