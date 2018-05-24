package design_patterns.simple_factory.example02;

/**
 * 抽象产品角色
 */
public abstract class Product {
    //所有产品类的公共业务方法
    public void methodSame() {
        //公共方法的实现
    }

    //声明抽象业务方法
    public abstract void methodDiff();

}
