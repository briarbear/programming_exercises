package design_patterns.simple_factory.example01;

/**
 * 客户端代码通过调用Chart类的构造函数来创建图表对象，
 * 根据参数type的不同可以得到不同类型的图表，然后再调用display()方法来显示相应的图表。
 * https://quanke.gitbooks.io/design-pattern-java/content/%E5%B7%A5%E5%8E%82%E4%B8%89%E5%85%84%E5%BC%9F%E4%B9%8B%E7%AE%80%E5%8D%95%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%B8%80%EF%BC%89.html
 */
public class Chart {

    private String type; //图表类型

    public Chart(Object[][] data, String type) {
        this.type = type;
        if (type.equalsIgnoreCase("histogram")) {
            //初始化柱状图
        } else if (type.equalsIgnoreCase("pie")) {
            //初始化饼状图
        } else if (type.equalsIgnoreCase("line")) {
            //初始化折线图
        }
    }

    public void display() {
        if (this.type.equalsIgnoreCase("histogram")) {
            //显示柱状图
        } else if (this.type.equalsIgnoreCase("pie")) {
            //显示饼状图
        } else if (this.type.equalsIgnoreCase("line")) {
            //显示折线图
        }
    }
}
