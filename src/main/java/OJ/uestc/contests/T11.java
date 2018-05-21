package OJ.uestc.contests;

import java.util.*;


public class T11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()){

            int n = scanner.nextInt();

            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(scanner.next());  //输入顺序保存在queue中
            }
            String input = scanner.next();

            List<String> list  = handle(queue,input);
            //遍历list
            for (String s : list) {
                System.out.println(s);
            }
        }

    }

    public static List<String> handle(Queue<String> queue,String input) {
        //先从input中找出最长子序列，返回起始位置

        //先进入四个队员
        List<String> sinput = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            sinput.add(queue.poll());
        }
        Queue<String> white = new LinkedList<>();
        Queue<String> black = new LinkedList<>();
        white.add(sinput.get(2));
        black.add(sinput.get(3));
        white.add(sinput.get(0));
        black.add(sinput.get(1));

        List<String> res = new ArrayList<>();



        List<Integer> starts = cal(input);
        int len = input.length();
        int index = 0;
        String temp;
        for (int i = 0; i < len  ; i++) {

            if (starts.get(index) == i){
                switch (input.charAt(i)){
                    case 'W':
                        if (i==0){
                            res.add(((LinkedList<String>) white).get(1)+" "+((LinkedList<String>) white).get(0));break;
                        }else {
                            res.add(((LinkedList<String>) white).get(0)+" "+((LinkedList<String>) white).get(1));break;
                        }
                    case 'B':
                        if (i==0){
                            res.add(((LinkedList<String>) black).get(1)+" "+((LinkedList<String>) black).get(0));break;
                        }else {
                            res.add(((LinkedList<String>) black).get(0)+" "+((LinkedList<String>) black).get(1));break;
                        }
                }
                index++;
                if (index == starts.size())
                    break;
            }


            switch (input.charAt(i)){
                case 'W':black.add(queue.poll());queue.add(black.poll());white.add(white.poll());break;
                case 'B':white.add(queue.poll());queue.add(white.poll());black.add(black.poll());break;
            }
        }




        return res;



    }


    public static List<Integer> cal(String input){
        //先找到字符串中相连的相同的最长字串
        char[] chars = input.toCharArray();
        int maxLen = 1;


        for (int i = 0; i < chars.length;i++) {
            for (int j = i+1; j < chars.length; j++) {
                if (chars[j]==chars[i]){
                    int len = j - i +1;
                    if (len > maxLen){
                        maxLen  = len;
                    }
                }else {
                    i = j-1;
                    break;
                }
            }


        }

        List<Integer> starts = new ArrayList<>();

        for (int i = 0; i <= chars.length-maxLen; i++) {
            int j = i+1;
            for (; j < i+maxLen; j++) {
                if (chars[j]!=chars[i])
                    break;
            }
            if (j==i+maxLen)
                starts.add(i);
        }

        return starts;

    }


}
