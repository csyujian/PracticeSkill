package algorithms;


import java.security.spec.RSAOtherPrimeInfo;

public class KMP {
    private int[] getNext(char[] p) {
        int len = p.length;
        int[] next = new int[len];
        next[0] = -1;
        int i = 0,k = -1;
        while (i < len - 1){
            if(k == -1){
                next[++i] = 0;
                k = 0;
            }else if(p[i] == p[k]){
                k++;
                next[++i] = k;
            }else
                k = next[k];
        }
        return next;
    }
    int match(char[] t,char[] p){
        int[] next = getNext(p);
        System.out.println("��ӡnext����");
        for(int n : next){
            System.out.print( (n+1) + " ");
        }

        System.out.println();
        int m = t.length,n = p.length;
        int i = 0,j = 0;
        int round = 1;
        System.out.println("round"+ round + " ��ʼ...");
        System.out.println("���ֿ�ʼƥ���λ�ã�"+ (i + 1) + " " + (j + 1));
        int[] times = new int[m];
        while (i < m){
            times[i]++;
            System.out.println("�ȽϵĶ��ַ���"+ t[i] + "<->" + p[j]);
            if(t[i] == p[j]){
                i++;
                j++;

            }else {
                System.out.println("ʧ�ܵ�λ�ã�"+ (i + 1) + " " + (j + 1));
                System.out.println("round"+ round + " ����...");
                System.out.println();
                round++;
                System.out.println("round"+ round + " ��ʼ...");
                j = next[j];
                if(j == - 1){
                    i++;
                    j = 0;
                }
                System.out.println("���ֿ�ʼƥ���λ�ã�"+ (i + 1) + " " + (j + 1));
            }
            if(j == n){
                System.out.println("ƥ��ɹ�");
                System.out.println("----------");
                for(int a : times){
                    System.out.print(a + " ");
                };
                System.out.println();
                return i - n;
            }
        }
        System.out.println("ƥ��ʧ��----------");
        for(int a : times){
            System.out.print(a + " ");
        };
        System.out.println();
        return -1;
    }
    public static void main(String[] args) {
        String[] ts = {"aebbcbcdef","bbccbcbbcbcbca","aabaaadaaaab"};
        String[] ps = {"bcdef","bcbca","aaaab"};
        KMP s = new KMP();
        for(int i = 0;i < ts.length;i++){
            int index = s.match(ts[i].toCharArray(),ps[i].toCharArray());
            System.out.println("--------------------");
            System.out.println("ƥ�䴮��" + ps[i]);
            System.out.println("Ŀ���ַ�����"+ts[i].substring(index));
            System.out.println();
        }
    }
}