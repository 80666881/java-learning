package charactor;

public class ADAPHero extends Hero implements AD,AP,Mortal {
    void ADAPHero(){

    }
    @Override
    public void magicAttack() {
        System.out.println("魔法攻击");
    }

    @Override
    public void physicAttack() {
        System.out.println("物理攻击");
    }

    @Override
    public void die() {
        System.out.println("ADAPHero die...");
    }
}
