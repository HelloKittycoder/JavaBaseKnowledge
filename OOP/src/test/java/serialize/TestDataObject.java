package serialize;

import org.junit.Test;

import java.io.*;

/**
 * Created by shucheng on 2019-10-1 下午 20:14
 * 打印结果：
 * DataObject{i=2,word='123',str='xixixi'}
 * DataObject{i=2,word='123',str='null'}
 *
 * 代码说明：
 * test1创建一个对象，并将其序列化至文件MyTest.txt（对象序列化：将对象状态转换为字节流的过程）
 * test2从文件中读取出对象（对象反序列化：从字节流创建对象的相反的过程）
 * 主要说下i和str两个属性：
 * java序列化时不保存静态变量（因为它是属于类层面上的状态，序列化保存的应该是对象状态的变化），所以test2打印结果仍为2
 * transient修饰过的变量不参与序列化，String默认值为null，数值为0，所以test2打印结果为null
 *
 */
public class TestDataObject {

    // 得到当前classpath的绝对uri路径--ClassLoader.getSystemResource
    private String filePath = ClassLoader.getSystemResource("").getPath() + "MyTest.txt";

    @Test
    public void test1() throws Exception {
        DataObject object = new DataObject();
        object.setWord("123");
        object.setI(2);
        object.setStr("xixixi");
        System.out.println(object);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(object);
        oos.close();
    }

    @Test
    public void test2() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        DataObject object1 = (DataObject) ois.readObject();
        System.out.println(object1);
        ois.close();
    }
}
