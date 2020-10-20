package jianzhi.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/11 16:31
 */
public class jz57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int loop = target;
        int low = 1,fast = 1,sum = 1;
        while( loop -- > 0){
            if(sum > target){
                while(sum > target){
                    sum -= low;
                    low++;
                }
            }
            if(sum == target){
                if(fast > low){
                    int[] temp = new int[fast - low + 1];
                    for(int i = low,j = 0;i <= fast;i++,j++){
                        temp[j] = i;
                    }
                    list.add(temp);
                }
            }
            fast++;
            sum += fast;
        }
        int[][] res = new int[list.size()][];
        for(int i = 0;i < res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        jz57 s = new jz57();
        int[][] res = s.findContinuousSequence(9);
        for(int[] r : res){
            for(int e : r){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
