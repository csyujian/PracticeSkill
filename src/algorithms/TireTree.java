package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/14 12:02
 */
public class TireTree {


    static class Node {
        public char element;//单词的当前字
        boolean wordEnd;//单词结束标志
        HashMap<Character, Node> children;

        public Node() {
            this.wordEnd = false;
            children = new HashMap<>();
        }

        public Node(char item) {
            this.element = item;
            this.wordEnd = false;
            children = new HashMap<>();
        }
    }

    public Node root;

    //构造函数
    public TireTree() {
        root = new Node();
    }

    public void add(String word) {
        //查找重复的字符
        int i = word.length() - 1;
        Node currentNodeOld = root;
        //while里的条件不能顺序不能反着来
        while (i >= 0 && currentNodeOld.children.containsKey(word.charAt(i))) {
            currentNodeOld = currentNodeOld.children.get(word.charAt(i));
            i--;
        }

        if (i == 0) {
            //有更短的词进入
            currentNodeOld.wordEnd = true;
        } else {
            Node parNode = currentNodeOld;
            for (int j = i; j >= 0; j--) {
                char cha = word.charAt(j);
                Node currentNodeNew = new Node(cha);
                parNode.children.put(cha, currentNodeNew);
                parNode = currentNodeNew;
                if (j == 0) {
                    currentNodeNew.wordEnd = true;
                }
            }
        }
    }
    static int res = 0;
    static void dfs(Node node, int path){
        if(node.children.isEmpty()) {
            res += path + 1;
            return;
        }
        for(Map.Entry<Character,Node> entry : node.children.entrySet()){
            dfs(entry.getValue(),path + 1);
        }
    }
    public static int minimumLengthEncoding(String[] words) {
        TireTree tireTree = new TireTree();

        for(String s : words){
            tireTree.add(s);
        }
        res = 0;
        dfs(tireTree.root,0);
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"t"};
        minimumLengthEncoding(words);
        System.out.println(res);
    }
}