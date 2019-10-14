package iterator.enhancedforloop;

/**
 * Created by shucheng on 2019-10-14 下午 18:05
 */
public class TestMyList {

    public static void main(String[] args) {
        MyList<String> strList = new MyList<>();
        strList.add("张三");
        strList.add("李四");
        strList.add("王五");
        strList.add("赵六");
        System.out.print("strList为：");
        for (String item : strList) {
            System.out.print(item + ",");
        }
        System.out.println();

        MyList<Integer> iList = new MyList<>();
        iList.add(1);
        iList.add(2);
        iList.add(3);
        iList.add(4);
        System.out.print("iList为：");
        for (Integer item : iList) {
            System.out.print(item + ",");
        }
        System.out.println();
    }
}
