package nowcoder;

/**
 * 输出斐波那契数列数列的第n项
 */
public class FibonacciArray {


    //迭代
    public int Fibonacci(int n) {

        if (n == 1 || n == 2 )
            return 1;
        return Fibonacci(n-2) + Fibonacci(n-1);
    }


    public int Fibonacci2(int n){
        int[] arr = new int[39];
        if ( n == 0)
            return 0;
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n  ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n-1];
    }
}
