### JVM与程序的生命周期
主动使用（七种）  
1. 创建类的实例  
2. 访问某个类或接口的静态变量，或者对该静态变量赋值  
3. 调用类的静态方法  
4. 反射（如Class.forName("com.test.Test")）  
5. 初始化一个类的子类  
6. Java虚拟机启动时被标明启动类的类  
7. JDK1.7开始提供的动态语言支持；  
java.lang.invoke.MethodHandle实例的解析结果  
REF getStatic，REF putStatic，REF invokeStatic句柄对应的类没有初始化，则初始化  

除了以上七种情况，其他使用Java类的方式都被看做是对类的被动使用，都不会导致类的初始化  

参考链接：  
https://blog.csdn.net/zkp_java/article/details/80030260  
https://blog.csdn.net/tr321456/article/details/79344836