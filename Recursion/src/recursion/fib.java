package recursion;

import org.junit.jupiter.api.Test;

/**
 * @author Dake Wang
 * @date 2023-02-16 18:00
 */
public class fib {

    @Test
    public void test(){
        long fib = fib(50);
        System.out.println(fib);
    }
    @Test
    public void test1(){
        long fib = fib(50, 1, 1);
        System.out.println(fib);
    }

    public long fib(int n){
        if (n < 3) return 1;
        else return fib(n - 1) + fib(n - 2);
    }

    public long fib(int n, long acc1, long acc2){
        if(n < 3) return acc2;
        else return fib(n - 1, acc2, acc1 + acc2);
    }
}
