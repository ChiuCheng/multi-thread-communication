package solution01;

/**
 * use volatile
 *
 * @author zheng_c
 * @create 2018-08-09 6:33 PM
 */

public class Printer {

    private volatile boolean toggle = false;

    public void printNumber() {
        for (int i = 1; i <= 52; i++) {
            while (toggle) ;
            System.out.print(i);
            if (i % 2 == 0) toggle = true;
        }
    }

    public void printAlpha() {
        for (char c = 'A'; c <= 'Z'; c++) {
            while (!toggle) ;
            System.out.print(c);
            toggle = false;
        }
    }
}
