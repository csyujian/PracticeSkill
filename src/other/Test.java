package other;

import java.util.*;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/4 13:49
 */
public class Test {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        List<Integer> list = new ArrayList<>(){{add(1);add(2);}};
        List<Integer> list2 = Arrays.asList(1,2,3);
        List<String> list3 = Arrays.asList("2","1");
        String[] hello = {"1","2"};
        List<String> list4 = Arrays.asList(hello);
        System.out.println("a".repeat(3));
        List<Integer> list5 = new ArrayList<>(Collections.nCopies(10, 5));
        Iterator<String> it = list4.iterator();
        while(it.hasNext()){
            String i = it.next();
            System.out.println(i);
        }
        String a = " 222";

    }
}