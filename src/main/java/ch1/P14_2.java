package ch1;

public class P14_2 {


    public static void main(String[] args) {

        String[] strings = new String[]{"a","d"};
        System.out.println(longestCommonPrefix2(strings));
    }

    /**
     * Horizontal scanning 水平扫描 依次地比较相邻的两个元素
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs){
        if (strs.length == 0)
            return "";
        String prefix = strs[0];  //从整个字符串开始比较
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    /**
     * Vertical scanning 垂直扫描：从第一个字符串开始扫描，逐个字符匹配
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs){
        
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0,i);
            }
        }
        
        return strs[0];
    }


    /**
     * Divide and conquer 分治法
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs){

        if (strs == null || strs.length == 0)
            return "";
        return longestCommonPrefix3(strs,0,strs.length-1);
    }


    private static String longestCommonPrefix3(String[] strs, int left, int right){
        if (left == right)
            return strs[left];
        else {
            int mid = (left + right)/2;
            String lcpLeft = longestCommonPrefix3(strs,left,mid);
            String lcpRight = longestCommonPrefix3(strs,mid+1,right);

            return commomPrefix(lcpLeft,lcpRight);
        }
    }

    static String commomPrefix(String left,String right){
        int min = Math.min(left.length(),right.length());

        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0,i);
        }

        return left.substring(0,min);
    }


    /**
     * 算法4 二分查找法 先找到最小长度的字符串长度，然后对第一个字符串二分查找，判断后面的是否满足共同后缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix4(String[] strs){
        if (strs == null || strs.length == 0)
            return "";

        int minLen = Integer.MIN_VALUE;
        for (String str:strs) {
            minLen = Math.min(minLen,str.length()); //找到最小的长度
        }

        int low = 1,high = minLen,middle = (low + high) / 2;
        while (low <= high){
            middle = (low + high) / 2;
            if (isCommonPrefix(strs,middle))
                low = middle +1;
            else
                high = middle -1;
        }

        return strs[0].substring(0,middle);
    }

    private static  boolean isCommonPrefix(String[] strs,int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1))
                return false;
        }

        return true;
    }


}
