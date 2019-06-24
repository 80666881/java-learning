package proxyMode;

public class Robot implements ISpeaker {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void say(String msg) {
        System.out.println("到达邻居家，对邻居说：" + msg + ",我是" + this.name);
    }
}
