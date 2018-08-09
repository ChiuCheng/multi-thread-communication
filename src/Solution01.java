/**
 * @author zheng_c
 * @create 2018-08-09 5:48 PM
 */

public class Solution01 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printNumber = new Thread(()-> printer.printNumber());
        Thread printAlpha = new Thread(() -> printer.printAlpha());
        printNumber.start();
        printAlpha.start();
    }
}
