package other;

import java.util.Scanner;

public class RCN {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        RCN s = new RCN();
        s.slove();
    }

    private void slove() {
        int t = in.nextInt();
        while (t-- > 0){
            System.out.println(helper(in.nextInt()) ? 1 : 0);
        }
    }

    private boolean helper(int n) {

        return true;
    }
}
