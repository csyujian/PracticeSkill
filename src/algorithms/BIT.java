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

// ��ɢ����ʹ�����ָ����գ���Լ��״����Ŀռ�
// 1��ʹ�ö�����������Ϊ��ȥ���ظ�Ԫ��
Set<Integer> treeSet = new TreeSet<>();
for (int j : nums) {
    treeSet.add(j);
}

// 2�����������ڹ�ϣ���﷽���ѯ
Map<Integer, Integer> rankMap = new HashMap<>();
int rankIndex = 1;
for (Integer num : treeSet) {
    rankMap.put(num, rankIndex);
    rankIndex++;
}

int count = 0;
// ����״�����ڲ����ǰ׺�͵ļ���
// �����ǣ��Ӻ���ǰ���ȸ���Ӧ������ + 1���ٲ�ѯǰ׺��
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
 * ������£��� index ���λ�� + delta
 *
 * @param i
 * @param delta
 */
public void update(int i, int delta) {
    // ���µ��ϣ���ൽ size�����Ե��� size
    while (i <= this.len) {
        tree[i] += delta;
        i += lowbit(i);
    }
}


// �����ѯ����ѯС�ڵ��� tree[index] ��Ԫ�ظ���
// ��ѯ�������ǡ�ǰ׺�͡�
public int query(int i) {
    // ���ҵ����ѯ
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
* �� x == 0�򷵻�0
* �� xΪ����������1
* ��xΪż�������ر������һ��1����
*/
private int lowbit(int x){
return x & (-x);
}
public static void main(String[] args) {
System.out.println();
}

}

