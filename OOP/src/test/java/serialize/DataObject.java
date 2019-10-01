package serialize;

import java.io.Serializable;

/**
 * Created by shucheng on 2019-10-1 下午 20:13
 */
public class DataObject implements Serializable {

    private static int i = 3;
    private String word = " ";
    private transient String str = "hehehe";

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        DataObject.i = i;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "i=" + i +
                ",word='" + word + '\'' +
                ",str='" + str + '\'' +
                '}';
    }
}
