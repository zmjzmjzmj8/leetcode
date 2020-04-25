import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列递归算法
 *
 * @author ：当麻(zhaomj)
 * @version: $
 * @since ：2020/4/25 3:52 下午
 */
public class Solution {

    /*输入: [1,2,3]
    输出:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]*/
    //全排列递归算法
    void perm(int list[], int k, int m, List<List<Integer>> resultList) {
        //list 数组存放排列的数，K表示层 代表第几个数，m表示数组的长度
        if (k == m) {
            //K==m 表示到达最后一个数，不能再交换，最终的排列的数需要输出；
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i <= m; i++) {
                arrayList.add(list[i]);
            }
            resultList.add(arrayList);
        } else {
            for (int i = k; i <= m; i++) {
                swap(list, i, k);
                perm(list, k + 1, m, resultList);
                swap(list, i, k);
            }
        }

    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        perm(nums, 0, nums.length - 1, resultList);
        System.out.println(resultList);
    }


}
