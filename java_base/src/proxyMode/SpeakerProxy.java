package proxyMode;

public class SpeakerProxy implements ISpeaker {
    private ISpeaker speaker;

    public SpeakerProxy(ISpeaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void say(String msg) {
        this.getGift();
        this.speaker.say(msg);
        this.giveGift();
    }

    public void getGift(){
        System.out.println("获取了一个礼物");
    }

    public void giveGift(){
        System.out.println("赠予一个礼物");
    }
}
