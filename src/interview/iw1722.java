package interview;

import java.util.*;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/16 16:25
 */
public class iw1722 {
    List<String> res = new ArrayList<>();
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        int end = -1;
        for(int i = 0;i < wordList.size();i++){
            if(wordList.get(i).equals(endWord)){
                end = i;
                break;
            }
        }

        if(end == -1){
            return new ArrayList<>();
        }
        wordList.add(beginWord);
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < wordList.size();i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0;j < wordList.size();j++){
                if(i != j && check(wordList.get(i),wordList.get(j))){
                    temp.add(j);
                }
            }
            map.put(i,temp);
        }
        boolean[] visited = new boolean[wordList.size()];
        visited[wordList.size() - 1] = true;
        res.add(beginWord);
        return dfs(wordList.size() - 1,end,wordList, map,visited) ? res : new ArrayList<>();
    }
    boolean flag = false;
    boolean dfs(int start, int end, List<String> wordList, Map<Integer, List<Integer>> map,boolean[] visited){
        if(start == end){
            flag = true;
            System.out.println("ÓÐ±»°®µ½");
            return true;
        }

        List<Integer> temp = map.get(start);
        for(int i = 0;i < temp.size() && !flag;i++){
            int index = temp.get(i);
            if(!visited[index]){
                visited[index] = true;
                res.add(wordList.get(index));
                if(dfs(index,end,wordList,map,visited)){
                    return true;
                }
                res.remove(res.size() - 1);
//                visited[index] = false;
            }

        }
        return flag;
    }
    boolean check(String s,String t){
        if(s.length() != t.length()){
            return false;
        }
        int count = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != t.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String[] strs = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
//        String[] strs = {"hot","dot","dog","lot","log","cog"};
        String start = "qa";
        String end = "sq";
        List<String> lists = new ArrayList<>();
        Collections.addAll(lists, strs);
        List<String> res = new iw1722().findLadders(start,end,lists);
        for(String ss : res){
            System.out.println(ss);
        }
    }
}