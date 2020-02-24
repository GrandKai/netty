import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Administrator
 * @Description:
 * @Date: Created in 2020-01-07 16:16
 * @Modified By:
 */
public class TestArray {
    static List<Integer> array = new ArrayList<Integer>();
    static List<Integer> linked = new LinkedList<Integer>();

    public static void main(String[] args) {


        for (int i = 0; i < 10000; i++) {
            array.add(i);
            linked.add(i);
        }
        System.out.println("array time:" + getTime(array));
        System.out.println("linked time:" + getTime(linked));
        System.out.println("array insert time:" + insertTime(array));
        System.out.println("linked insert time:" + insertTime(linked));

    }

    public static long getTime(List list) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int index = Collections.binarySearch(list, list.get(i));
            if (index != i) {
                System.out.println("ERROR!");
            }
        }
        return System.currentTimeMillis() - time;
    }

    public static long insertTime(List list) {
        long time = System.currentTimeMillis();
        for (int i = 100; i < 10000; i++) {
            list.add(i, i);
        }
        return System.currentTimeMillis() - time;

    }
}
