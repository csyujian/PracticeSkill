package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
/**
* @author yvzhu
* @version 1.0
* @date 2020/10/14 15:41
*/
public class BIT {

public int reversePairs(int[] nums) {
int len = nums.length;

if (len < 2) {
    return 0;
}

// 离散化：使得数字更紧凑，节约树状数组的空间
// 1、使用二分搜索树是为了去掉重复元素
Set<Integer> treeSet = new TreeSet<>();
for (int j : nums) {
    treeSet.add(j);
}

// 2、把排名存在哈希表里方便查询
Map<Integer, Integer> rankMap = new HashMap<>();
int rankIndex = 1;
for (Integer num : treeSet) {
    rankMap.put(num, rankIndex);
    rankIndex++;
}

int count = 0;
// 在树状数组内部完成前缀和的计算
// 规则是：从后向前，先给对应的排名 + 1，再查询前缀和
FenwickTree fenwickTree = new FenwickTree(rankMap.size());

for (int i = len - 1; i >= 0; i--) {
    int rank = rankMap.get(nums[i]);
    fenwickTree.update(rank, 1);
    count += fenwickTree.query(rank - 1);
}
return count;
}

private class FenwickTree {
private int[] tree;
private int len;

public FenwickTree(int n) {
    this.len = n;
    tree = new int[n + 1];
}

/**
 * 单点更新：将 index 这个位置 + delta
 *
 * @param i
 * @param delta
 */
public void update(int i, int delta) {
    // 从下到上，最多到 size，可以等于 size
    while (i <= this.len) {
        tree[i] += delta;
        i += lowbit(i);
    }
}


// 区间查询：查询小于等于 tree[index] 的元素个数
// 查询的语义是「前缀和」
public int query(int i) {
    // 从右到左查询
    int sum = 0;
    while (i > 0) {
        sum += tree[i];
        i -= lowbit(i);
    }
    return sum;
}

public int lowbit(int x) {
    return x & (-x);
}
}





/**
* @param x
* @return
* 若 x == 0则返回0
* 若 x为奇数，返回1
* 若x为偶数，返回保存最后一个1的数
*/
private int lowbit(int x){
return x & (-x);
}
public static void main(String[] args) {
System.out.println();
}

}

