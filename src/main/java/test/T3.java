package test;

import java.io.*;
import java.util.StringTokenizer;

public class T3 {


    public static void main(String[] args) throws IOException {
        File file = new File("E:\\Gitee\\programming_exercises\\src\\main\\java\\test\\Fg_feature");
        BufferedReader input;
        FileReader fileReader = new FileReader(file);
        input = new BufferedReader(fileReader);

        String line = input.readLine();

        StringTokenizer st = new StringTokenizer(line," \t\n\r\f:");

//        double target = atof(st.nextToken());
        String target = st.nextToken();
            int m = st.countTokens()/2;
//        int m = 4;
//        svm_node[] x = new svm_node[m];
//        for(int j=0;j<m;j++)
//        {
//            x[j] = new svm_node();
//            x[j].index = atoi(st.nextToken());
//            x[j].value = atof(st.nextToken());
//        }
//        fileName = st.nextToken();
//        thispcapid = st.nextToken();


    }
}
