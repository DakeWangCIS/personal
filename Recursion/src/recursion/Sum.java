package recursion;

import org.junit.jupiter.api.Test;

/**
 * @author Dake Wang
 * @date 2023-02-16 17:45
 */
public class Sum {

    @Test
    public void test(){
        long sum = getSum(10000, 0);
        System.out.println(sum);
    }

    @Test
    public void test1(){
        long sum = getSum(10000);
        System.out.println(sum);
    }

    public int getSum(int n, int acc){
        if(n == 0) return acc;
        else return getSum(n - 1, acc + n);
    }

    public int getSum(int n){
        if(n == 0) return 0;
        else return n + getSum(n - 1);
    }
}
