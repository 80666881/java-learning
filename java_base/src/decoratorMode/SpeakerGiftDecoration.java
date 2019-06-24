package decoratorMode;

public abstract class SpeakerGiftDecoration implements ISpeaker {
    ISpeaker speaker;

    public SpeakerGiftDecoration(ISpeaker speaker) {
        super();
        this.speaker = speaker;
    }

    public abstract void say(String name);

    public abstract void getGift();

    public abstract void giveGfit();


}
