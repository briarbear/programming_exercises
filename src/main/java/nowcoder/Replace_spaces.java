package nowcoder;

/**
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423
 * 替换空格
 */
public class Replace_spaces {

    public String replaceSpace(StringBuffer str) {

        int temp = str.indexOf(" ");
        while (temp != -1){
            str.replace(temp,temp+1,"");
            str.insert(temp,"%20");
            temp = str.indexOf(" ");
        }

        return str.toString();
    }




}
