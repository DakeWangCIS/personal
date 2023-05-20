package recursion;

import org.junit.jupiter.api.Test;

/**
 * @author Dake Wang
 * @date 2023-02-22 23:37
 */
public class Factorial {

    public long fac(int n) {
        if(n == 1) return 1;
        else return n * fac(n - 1);
    }

    public long fac1(int n) {
        long product = 1;
        for (int i = 1; i <= n ; i++) {
            product *= i;
        }
        return product;
    }

    //tail recursion
    public long facTail(int n, int acc) {
        if(n == 1) return acc;
        else return facTail(n - 1, acc * n);
    }

    @Test
    public void test(){
        System.out.println(fac1(10));
        System.out.println(fac(10));
    }


}
