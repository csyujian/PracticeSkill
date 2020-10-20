package algorithms;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/14 15:32
 * 这个不常用，等待完成
 */
public class ST {
    private int[][] f;
    private int[] Logn;
    private int len;
    public ST(int len){
        f = new int[len][(int)Math.log(len)];
        Logn = new int[len];
        this.len = len;
    }

    void init(int[] nums){
        for(int i = 0;i < nums.length;i++){
            f[i][0] = nums[i];
        }
        pre();
    }
    void pre(){
        Logn[1] = 0;
        Logn[2] = 1;
        for(int i = 3;i < len;i++){
            Logn[i] = Logn[i / 2] + 1;
        }
    }



}
