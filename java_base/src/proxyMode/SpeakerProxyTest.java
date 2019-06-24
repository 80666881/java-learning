package proxyMode;

public class SpeakerProxyTest {
    public static void main(String[] args) {
        //没有带礼物的机器人
        ISpeaker noGiftSpeaker = new Robot("空手来的Ada");
        noGiftSpeaker.say("你好~~~");

        System.out.println("==================");

        //带了礼物来的机器人
        ISpeaker withGiftSpeaker = new SpeakerProxy(new Robot("带礼而来的Ada"));
        withGiftSpeaker.say("helo~~~");
    }
}
