package leetcode.ch3;

import java.util.*;

/**
 * 380. 常数时间插入、删除和获取随机元素 ,不允许重复元素
 */
public class S380 {

    /**
     * map + list 实现
     */
    private Map<Integer,Integer> map;  //key = 元素值, value = 元素在list中的下标
    private List<Integer> list;
    private Random random = new Random();

    public S380() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /**
     * 插入val
     */
    public boolean insert(int val) {
       //1 先判断是否存在
       if (map.containsKey(val))
           return false;       //已存在,直接返回false

        list.add(val);
        map.put(val,list.size()-1);

        return true;

    }

    /**
     * 删除元素
     * @param val
     * @return
     */
    public boolean remove(int val) {
        //判断是否存在
        if (!map.containsKey(val))
            return false;

        int index = map.get(val); //获取下标
        map.remove(val);

        //如果删除的元素不是最后一个
        if (index < list.size()-1){
            int last = list.get(list.size()-1);
            map.put(last,index);
            list.set(index,last);
        }
        list.remove(list.size()-1);

        return true;

    }

    public int getRandom() {
        if (!list.isEmpty())
            return list.get(random.nextInt(list.size()));
        return 0;
    }
}



