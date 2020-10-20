package jianzhi.offer;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/13 13:02
 */
public class jz33 {

    public boolean verifyPostorder(int[] postorder) {
        //ÅÐ¶ÏÊÇ·ñÎª
        int n = postorder.length;
        return verifyPostorderSub(postorder,0,n - 1);
    }
    boolean verifyPostorderSub(int[] postorder,int left ,int right ){
        if(left <= right){
            return true;
        }
        int root = postorder[right];
        int mid = left - 1;
        boolean flag = true;
        for(int i = left;i < right;i++){
            if(postorder[i] < root){
                mid++;
                if(!flag){
                    return false;
                }
            }else{
                flag = false;
            }
        }
        return verifyPostorderSub(postorder,left,mid) && verifyPostorderSub(postorder,mid + 1,right - 1);
    }

    public static void main(String[] args) {
//        int[] postorder = {1,3,2,6,5};
//        int[] postorder = {1,6,3,2,5};
        int[] postorder = {1,2,5,10,6,9,4,3};
        boolean res = new jz33().verifyPostorder(postorder);
        System.out.println(res);
    }
}