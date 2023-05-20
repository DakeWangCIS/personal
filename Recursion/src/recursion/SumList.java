package recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Dake Wang
 * @date 2023-02-22 00:46
 */
public class SumList {

    public int getSum(ArrayList<Integer> list) {
        int sum = 0;
        if(list.size() == 0) {
            return 0;
        }
        else {
            int first = list. remove(0);
            return first + getSum(list);
        }
    }

    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int sum = getSum(list);
        System.out.println(sum);
    }
}
