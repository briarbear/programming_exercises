package Algorithm.Sorts;

import java.util.ArrayList;

/**
 * 基数排序
 *
 */
public class RadixSort {



  public void sort(int[] array){

      if (array.length == 1){
          return;
      }

      //1. 先求出最大数的位数
      int max = array[0];
      for (int a : array) {
          if (a >max)
              max = a;
      }
      int maxDigt = 0; //记录最大数的位数
      while (max != 0){
          max /= 10;
          maxDigt++;
      }

      int mod = 10,div = 1;

      ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
          bucketList.add(new ArrayList<>());
      }

      for (int i = 0; i < maxDigt; i++,mod *=10,div *= 10) {
          for (int anArray : array) {
              int num = (anArray % mod) / div;  //先取得个位数
              bucketList.get(num).add(anArray);
          }
          //按某个位数排列完后，再回归到原数组
          int index = 0;
          for (ArrayList<Integer> aBucketList : bucketList) {
              for (Integer anABucketList : aBucketList) {
                  array[index++] = anABucketList;
              }
              aBucketList.clear();  //清空队列
          }
      }
  }
}
