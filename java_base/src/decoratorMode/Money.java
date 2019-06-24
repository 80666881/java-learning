package decoratorMode;

public class Money extends SpeakerGiftDecoration {
    public Money(ISpeaker speaker) {
        super(speaker);
    }

    @Override
    public void say(String msg) {
        this.getGift();
        this.speaker.say(msg);
        this.giveGfit();
    }

    @Override
    public void getGift() {
        System.out.println("获取了一袋水果");
    }

    @Override
    public void giveGfit() {
        System.out.println("赠予一个红包");
    }
}

