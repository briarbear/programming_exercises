package leetcode.ch3;

import java.util.*;

/**
 * 347 前K个高频元素
 */
public class S347 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
//        res =  handle(nums,k);
        res =sort(nums,k);
        return res;
    }

    //链表插入排序，超时
    public List<Integer> handle(int[] nums,int k){

        Map<Integer,Integer> map = new HashMap<>();
        //用HashMap存储起来
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(Integer.valueOf(nums[i]))){
                int value = map.get(nums[i]);
                map.put(Integer.valueOf(nums[i]),value+1);
            }else {
                map.put(Integer.valueOf(nums[i]),1);
            }
        }

        //然后维护k长的数组
        List<Integer> list = new LinkedList<Integer>();
        //遍历hashmap 插入排序
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = (Integer) iterator.next();

            boolean flag = false;
            int i = 0;
            for (; i < list.size(); i++) {
                if (map.get(key) > map.get(list.get(i))){
                    list.add(i,key);
                    flag = true;
                    break;
                }
            }
            if (!flag)
                list.add(i,key);

        }

        //输出
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add(list.get(i));
        }

        return res;

    }

    //堆排序

    public List<Integer> sort(int[] nums,int k){
        //扫描一遍数组，存hash表
        Map<Integer,Integer> map = new HashMap<>();
        //用HashMap存储起来
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(Integer.valueOf(nums[i]))){
                int value = map.get(nums[i]);
                map.put(Integer.valueOf(nums[i]),value+1);
            }else {
                map.put(Integer.valueOf(nums[i]),1);
            }
        }

        //建key转为数组
        Iterator<Integer> iterator = map.keySet().iterator();
        int[] temp = new int[nums.length];
        int i = 0;
        int len = 0;
        while (iterator.hasNext()){
            temp[i++] = iterator.next();
            len++;
        }

        //对数组temp中前K个元素 构建k个元素的小顶堆
        buildMinHeap(temp,k,map);

        //然后遍历后续元素
        for (int j = k; j < len; j++) {
            //如果第j+1个元素 大于堆顶的元素，则加入进入，再调整堆
            if (map.get(temp[j]) > map.get(temp[0])){
                i = 0;
                temp[0] = temp[j];
                //重新构建小顶堆
                buildMinHeap(temp,k,map);

            }
        }


        List<Integer> res = new ArrayList<>();
        //输出堆
        for (int j = 0; j < k; j++) {
            res.add(temp[j]);
        }

        return res;
    }


    //构建最小堆
    public void buildMinHeap(int[] n,int k,Map<Integer,Integer> map){
        for (int i = (k-1)/2; i >=0; i--) {
            adjustHeap(n,i,k,map);
        }
    }

    //调整堆
    private int adjustHeap(int[] n, int i,int k, Map<Integer,Integer> map) {

        int minIndex = i;
        int res = 0;
        //如果有左子树，且左子树数值小于父节点，这更新minIndex
        if (i*2 +1 < k && (map.get(n[i*2+1]) < map.get(n[i]))){
            minIndex = i*2+1;
            res = -1;
        }
        //如果有右子树，且右子树小于父节点,小于左子树节点
        if ((i+1)*2 < k){
            if(map.get(n[(i+1)*2])<map.get(n[i]) && map.get(n[i*2 +2]) < map.get(n[i*2 +1])){
                minIndex = i*2 +2;
                res = 1;
            }

        }
        if (minIndex != i)
            swap(n,i,minIndex);
        return res;
    }


    //交换数组内两个元素
    private  void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
