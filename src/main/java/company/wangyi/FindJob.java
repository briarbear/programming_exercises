package company.wangyi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 牛牛找工作
 *
 * @author briarbear
 * @blog http://briarbear.github.io
 * @create 2018-08-11-12:57
 */
public class FindJob {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){

            int N = scanner.nextInt(); //工作数量
            int M = scanner.nextInt();  //小伙伴数量
            ArrayList<Job> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                Job job = new Job(scanner.nextInt(), scanner.nextInt());
                list.add(job);
            }
            //按工作难度排序
            list.sort((Comparator.comparingInt(o -> o.di)));

            //遍历list，更新薪酬为当前难度下的最高薪酬
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).pi > max)
                    max = list.get(i).pi;
                list.get(i).pi = max;
            }

            //计算m个小伙伴的最高薪酬
            for (int i = 0; i < M; i++) {
                System.out.println(helper(scanner.nextInt(),list));
            }

        }
    }

    /**
     * 从list中找到最高薪资
     * 二分查找法
     */
    public static int helper(int n, ArrayList<Job> list) {
        if (n<list.get(0).di) return 0;  //如果第一个任务也无法完成
        int start = 0,end = list.size()-1,mid = 0;

        while (start<=end){
            mid = (start + end)/2;
            if (list.get(mid).di <n)
                start = mid+1;
            else if (list.get(mid).di > n){
                end = mid-1;
            }else
                return list.get(mid).pi;
        }


        return list.get(mid).di>n?list.get(mid-1).pi:list.get(mid).pi;
    }
}

class Job{
    int di;  //工作难度
    int pi;  //报酬

    public Job(int di, int pi) {
        this.di = di;
        this.pi = pi;
    }
}