package leetcode.ch3;

import java.util.*;

/**
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 * Insert Delete GetRandom O(1)
 */
public class S381 {

    private Map<Integer,List<Item>> map;
    private List<Item> list;
    private Random random = new Random();

    /** Initialize your data structure here. */
    public S381() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    //插入操作
    public boolean insert(int val) {
        boolean existed = map.containsKey(val);
        List<Item> indices = map.get(val);
        //如果不存在
        if (!existed){
            indices = new ArrayList<>();
            map.put(val,indices);
        }
        Item newItem = new Item(list.size(),val);
        indices.add(newItem);
        list.add(newItem);

        return !existed;

    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    //删除操作
    public boolean remove(int val) {
        //如果不存在
        if (!map.containsKey(val)){
            return false;
        }

        List<Item> indices = map.get(val);
        //从map中删除
        if (indices.size() == 1)
            map.remove(val);

        Item item = indices.get(indices.size()-1);
        indices.remove(indices.size()-1);
        //与list中最有一个元素交换
        if (item.index < list.size() - 1){
            Item last = list.get(list.size()-1);
            last.index = item.index;
            list.set(item.index,last);
        }
        //然后再删除list中最后一个元素
        list.remove(list.size()-1);

        return true;

    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size())).val;
    }

}

class Item{
    int index;
    int val;

    public Item(int index, int val) {
        this.index = index;
        this.val = val;
    }
}
