package company.Ali;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertArrayTest {

    @Test
    public void min() {
        int[] a = new int[]{1,2,1,1};
        int[] b = new int[]{4,3,2,2};
        System.out.println(InsertArray.min(a, b));
    }
}