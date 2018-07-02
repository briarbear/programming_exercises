package nowcoder;

/**
 *
 */
public class Power {


    public double pow(double base,int exponent){
        double res = 1;
        if (exponent == 0)
            return 1;

        //判断exponent正负
        boolean sign = true;
        if (exponent < 0){
            sign = false;
            exponent = -exponent;
        }

        //
        res = helper(base,exponent);
        if (!sign)
            res = 1.0 / res;

        return res;
    }

    public double helper(double x,int y){
        if (y == 0)
            return 1;
        if (y % 2 == 0)
            return Math.pow(helper(x,y/2),2);
        else
            return Math.pow(helper(x,y/2),2) * x;
    }
}
