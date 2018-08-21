package nowcoder.offer;

/**
 * 二叉搜索树的后序遍历序列
 *
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-05-23:18
 */
public class VerifySquenceOfBST {

    public boolean sequence(int [] sequence) {

        //待完成...
        if (sequence.length == 0)
            return false;
        return helper(sequence,0,sequence.length-1);
    }


    public boolean helper(int[] seq,int start,int end){
      //从start开始，找到第一个比end大的数字
        if (start>=end)
            return true;
        int index = end;
        for (int i = start; i < end; i++) {
            if (seq[i] > seq[end]){
                index = i;
                break;
            }
        }

        //判断右子树是否满足条件
        for (int i = index+1; i < end; i++) {
            if (seq[i] < seq[end])
                return false;
        }

        //找到index

        return helper(seq,start,index-1)&&helper(seq,index,end-1);



    }
}
