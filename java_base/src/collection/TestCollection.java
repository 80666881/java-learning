package collection;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestCollection {
    public static void main(String[] args) {
        HashSet<Integer> numberSet1 = new HashSet<Integer>();
        //HashSet中的数据不是按照插入顺序存放
        numberSet1.add(88);
        numberSet1.add(8);
        numberSet1.add(888);

        System.out.println(numberSet1);

        LinkedHashSet<Integer> numberSet2 = new LinkedHashSet<Integer>();
        //LinkedHashSet中的数据是按照插入顺序存放
        numberSet2.add(88);
        numberSet2.add(8);
        numberSet2.add(888);

        System.out.println(numberSet2);
        TreeSet<Integer> numberSet3 = new TreeSet<Integer>();
        //TreeSet 中的数据是进行了排序的
        numberSet3.add(88);
        numberSet3.add(8);
        numberSet3.add(888);

        System.out.println(numberSet3);

        LinkedHashSet<Character>  numberSet4 = new LinkedHashSet<>();
        double pi = Math.PI;
        String piStr = Double.toString(pi);
        for (int i = 0; i < piStr.length(); i++) {
            if(piStr.charAt(i) == '.'){
                continue;
            }
            numberSet4.add(piStr.charAt(i));
        }
        System.out.println("不重复的数字是"+numberSet4);

    }
}
