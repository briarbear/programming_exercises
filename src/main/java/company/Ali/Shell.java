package company.Ali;

import java.io.*;
import java.util.*;

/**
 * shell命令
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-06-16:53
 */
public class Shell {


    public static void main(String[] args) throws IOException {
        String input = "/home/admin/logs/data.log";
        String output = "/home/admin/logs/data-result.txt";

        File file = new File(input);
        File out = new File(output);
        Map<String,Integer> map = new HashMap<>();  //hashmap存储
        if (file.isFile() && file.exists()){
            BufferedReader reader = null;

            reader = new BufferedReader(new FileReader(file));
            String s;

            //逐行读取
            while ((s = reader.readLine()) != null){
                if (s.contains("alibaba")){
                    if (map.containsKey(s))
                        map.put(s,map.get(s)+1);
                    else {
                        map.put(s,1);
                    }
                }
            }

            reader.close();


            //优先队列 自定义排序
            Queue<String> priority = new PriorityQueue<>((String a,String b) ->{
                if (map.get(a).intValue() != map.get(b).intValue()){
                    return map.get(b) - map.get(a);
                }else {
                    return a.compareTo(b) * -1;
                }
            });

            for (String temp : map.keySet()) {
                priority.add(temp);
            }

            out.createNewFile(); //创建新文件
            BufferedWriter br = new BufferedWriter(new FileWriter(out));

            for (String temp : priority) {
                String ss = String.format("%7s",String.valueOf(map.get(temp))); //格式化输出
                br.write(ss+" "+temp+"\r\n");
            }

            //关闭输入输出流
            br.flush();
            br.close();


        }

    }
}
