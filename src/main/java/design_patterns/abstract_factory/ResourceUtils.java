package design_patterns.abstract_factory;

import java.util.ResourceBundle;

/**
 * 从配置文件中读取属性，从而返回对应的对象
 */
public class ResourceUtils {

    public static Object getBean(){
        ResourceBundle resource = ResourceBundle.getBundle("design_patterns.abstract_factory/factory");
        String key = resource.getString("factory");
        key = "design_patterns.abstract_factory." + key;

        try {
            Class c = Class.forName(key);
            Object obj = c.newInstance();
            return obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
