package nowcoder;

public class ReOrderArray {

    /**
     * 双指针解决方案
     * @param array
     */
    public void reOrder(int[] array){

        int p1 = 0,p2 = 0;
        int i = 0;
        int temp = 0;
        for (; i < array.length; i++) {
            if (array[i] % 2 ==0){ //找到第一个偶数
                p1 = i;
                p2 = i;
                break;
            }
        }
        p2++;
        while (p2 < array.length){
            if (array[p2] % 2 != 0){  //找到下一个奇数，数组整体右移
                temp = array[p2];

                for (int j = p2; j > p1 ; j--) {
                    array[j] = array[j-1];
                }
                array[p1] = temp;
                p1++;
                p2++;
            }else {
                p2++;
            }
        }

        System.out.println("");
    }

    /**
     * 也可以考虑借助 借助额外的数组
     */
    public void reOrder2(int[] array){
        return;
    }
}
