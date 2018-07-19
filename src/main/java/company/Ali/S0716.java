package company.Ali;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;





public class S0716 {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }




        System.out.println(calculate(locations));
    }

    static int calculate(String[] locations) {

        ArrayList<Point> points = new ArrayList<>();
        int res = 0;
        //添加点到list中
        for (int i = 0; i < locations.length; i++) {
            int x = Integer.valueOf(locations[i].split(",")[0]);
            int y = Integer.valueOf(locations[i].split(",")[1]);
            Point p = new Point(x, y);
            points.add(p);
        }

        //从开始的地方以此找到离自己最近的点

        while (!points.isEmpty()){

            //待完成。。。。
        }

        return res;

    }


    /**
     * 求得两个点的距离
     * @param p1
     * @param p2
     * @return
     */
    static int distance(Point p1,Point p2){

        return (int) Math.pow(((p1.x-p2.x)*(p1.x-p2.x) + ((p1.y-p2.y)*(p1.y- p2.y))),2);

    }

}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
