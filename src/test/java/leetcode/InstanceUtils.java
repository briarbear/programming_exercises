package leetcode;




public class InstanceUtils {

    public static <T> T get(Class<T> string) throws Exception {

        T t = (T) string.newInstance();

        return t;
    }
}
