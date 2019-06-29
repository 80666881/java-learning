package thread;

public class TestThread {
    public static void main(String[] args) {

        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        //单线程
        //盖伦攻击提莫
//        while(!teemo.isDead()){
//            gareen.attackHero(teemo);
//        }
        //赏金猎人攻击盲僧
//        while(!leesin.isDead()){
//            bh.attackHero(leesin);
//        }

        //多线程方式1,继承线程类Thread
//        KillThread killThread1 = new KillThread(gareen,teemo);
//        killThread1.start();
//        KillThread killThread2 = new KillThread(bh,leesin);
//        killThread2.start();


        //多线程方式2，实现runnable接口
//        Battle battle1 = new Battle(gareen,teemo);
//        new Thread(battle1).start();
//        Battle battle2 = new Battle(bh,leesin);
//        new Thread(battle2).start();


        //多线程方式3，匿名类
        /*
        使用匿名类，继承Thread,重写run方法，直接在run方法中写业务代码
        匿名类的一个好处是可以很方便的访问外部的局部变量。
        前提是外部的局部变量需要被声明为final。(JDK7以后就不需要了)
        * */
        //匿名类
        Thread t1= new Thread(){
            public void run(){
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                //但是在JDK7以后，就不是必须加final的了
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };

        t1.start();

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        t2.start();



        /*
        * 总结
        *   1. 继承Thread类
            2. 实现Runnable接口
            3. 匿名类的方式
            注： 启动线程是start()方法，run()并不能启动一个新的线程
            *   run方法名是固定的
        *
        * */

    }
}
