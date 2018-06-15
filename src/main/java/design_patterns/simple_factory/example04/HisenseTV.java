package design_patterns.simple_factory.example04;

public class HisenseTV implements TV {
    @Override
    public void play() {
        System.out.println("海信电视播放中......");
    }
}
