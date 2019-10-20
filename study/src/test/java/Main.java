import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/10/17
 **/
public class Main {

    @Test
    public void test01(){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(1);
        queue.add(3);
        queue.add(4);
        queue.add(7);
        queue.add(8);
        queue.add(6);
        queue.add(5);

        System.out.println();
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}
