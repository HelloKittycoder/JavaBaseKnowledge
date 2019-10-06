package inheritance;

/**
 * Created by shucheng on 2019-10-6 下午 19:03
 * 测试java中的继承
 *
 * 打印结果：Car
 * 代码说明：Car继承了Vehicle，但是Vehicle中的run方法被private修饰，也就是说Vehicle中的run方法对Car来说是不可见的；
 * 所以Car中的run方法和重写没有任何关系，Car中的run方法和Vehicle中的run方法没有关系
 *
 * 附加说明：
 * final关键字：
 * 修饰类时表示该类不能被继承（如：String，StringBuilder，StringBuffer，Integer，Double等）
 * 修饰方法时表示该方法不能被重写（如果被private修饰除外）
 * 修饰属性时表示该属性不能被修改（1.基本数据类型：值不能被改变，如：int等；2.引用数据类型：不能被重新赋值，如：String等）
 *
 * public关键字：
 * 1.一个类文件中最多只能有一个class（这里指的是外部类，而非内部类）被声明为public
 * 2.被声明为public的class的名称必须作为.java文件的名称
 */
class Car extends Vehicle {
    public static void main(String[] args) {;
        new Car().run();
    }
    private final void run() {
        System.out.println("Car");
    }
}
class Vehicle {
    private final void run() {
        System.out.println("Vehicle");
    }
}
