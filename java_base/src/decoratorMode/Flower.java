package decoratorMode;

public class Flower extends SpeakerGiftDecoration {
    public Flower(ISpeaker speaker) {
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
        System.out.println("获取了一束花🌹");
    }

    @Override
    public void giveGfit() {
        System.out.println("赠予两束花🌹🌹");
    }
}

