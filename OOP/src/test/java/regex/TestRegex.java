package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shucheng on 2019-10-21 下午 22:39
 *
 * https://www.runoob.com/java/java-regular-expressions.html
 * https://www.cnblogs.com/echolife/p/10509783.html
 * https://blog.csdn.net/silentwolfyh/article/details/50975749
 */
public class TestRegex {

    /**
     * 需求说明：
     * 1.首个字符是字母
     * 2.必须有数字，大小写字母
     * 3.可以允许有特殊字符
     *
     * 这个正则表达式该怎么写？目前写出来的还有问题，后续有空再想下
     */
    private static Pattern STR_PATTERN = Pattern.compile("[a-zA-Z]([\\da-zA-Z])+.*");
    private static String str = "[a-zA-Z]([\\da-zA-Z])+.*";

    public static boolean checkRegexp(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean isMatch(String str, String regex) {
        return Pattern.matches(regex, str);
    }

    public static void main(String[] args) {
        System.out.println(checkRegexp("I123a", STR_PATTERN)); // true
        System.out.println(isMatch("I123a", str)); // true

        System.out.println(checkRegexp("I123a中文", STR_PATTERN)); // true
        System.out.println(checkRegexp("Ia中文", STR_PATTERN)); // false
    }
}
