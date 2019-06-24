package decoratorMode;

public class SpeakerGiftDecoratorTest {
    public static void main(String[] args) {
        // 一种礼物：
        ISpeaker speaker = new Flower(new Robot("我是带花来的Wall-E"));
        speaker.say("Hello");
        System.out.println();
//         两种礼物：
        speaker = new Money(new Flower(new Robot("我是带了花和红包的Wall-E")));
        speaker.say("Hello");
        System.out.println();
        // 另外两种礼物：
//        speaker = new Fruit(new Money(new Robot("我是带了水果和钱的Wall-E")));
//        speaker.say("Hello");
//        System.out.println();
//        // 三种礼物：
//        speaker = new Fruit(new Money(new Flower(new Robot("我是三种礼物都带的Wall-E"))));
//        speaker.say("Hello");
    }
}
