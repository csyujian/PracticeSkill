package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/17 11:56
 */
public class lq1 {
    public static void main(String[] args) {
        int res = 0;
//        Map<Integer,bole> map = new HashMap<>();

        for(int i = 1 ;i <= 2020;i++){
            for(int j =  1 ;j <= 2020;j++){
                if(check(i,j)){
                    res++;
                }
            }
        }
        System.out.println(res);
        System.out.println(check(1,1));
    }
    static boolean check(int i,int j){
        for(int k = 2 ; k <= Math.min(i , j);k++){
            if(i % k == 0 && j % k == 0){

                return false;
            }
        }
        return true;
    }
}
