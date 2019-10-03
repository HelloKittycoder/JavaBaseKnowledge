package proxy.customjdkproxy.reflect;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by shucheng on 2019-10-3 下午 16:32
 * 生成代理对象的代码
 */
public class MyProxy {

    private static final String ln = "\r\n";

    /**
     * 通过此类为一个或多个接口动态生成实现类（这里只弄了一个接口的情况）
     * @param classLoader 类加载器
     * @param interfaces 得到全部的接口
     * @param h 得到InvocationHandler接口的子类实例
     * @return Object
     *
     * 为什么jdk动态代理需要实现接口？
     * https://www.cnblogs.com/WeidLang/p/9857495.html
     * https://bbs.csdn.net/topics/391843893
     */
    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler h) {
        try {
            // 1.生成源代码
            String proxySrc = generateSrc(interfaces[0]);
            // 2.将生成的源代码输出到磁盘，保存为.java文件
            String filePath = MyProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();
            // 3.编译源代码，并且生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            // 4.将class文件中的内容，动态加载到JVM中
            // 5.返回被代理后的代理对象
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
            // 这里先不删除生成的$Proxy0.java文件，实际上要删除的
            // f.delete();
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成代理对象$Proxy0的源代码
     * @param interfaces 抽象对象
     * @return String
     */
    private static String generateSrc(Class<?> interfaces) {
        StringBuilder src = new StringBuilder();
        src.append("package proxy.customjdkproxy.reflect;" + ln);
        // 引入反射相关的包
        src.append("import java.lang.reflect.Method;" + ln);
        // 动态代理类实现被代理接口，在此为Person类
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
        src.append("MyInvocationHandler h;" + ln);
        src.append("public $Proxy0(MyInvocationHandler h) {" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);
        // 通过反射获取代理接口的所有方法并invoke
        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);

            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName()
                    + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            src.append("this.h.invoke(this, m, null);" + ln);
            src.append("} catch (Throwable e) { e.printStackTrace(); }" + ln);
            src.append("}" + ln);
        }
        src.append("}");
        return src.toString();
    }
}
