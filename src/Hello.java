import java.util.Arrays;

//推荐把private方法放到后面，因为public方法定义了类对外提供的功能，阅读代码的时候，应该先关注public方法
//一个.java文件只能有一个public类，public的类名跟文件名一样
public class Hello {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        //int x = 100;
        //System.out.println(x);
        //x = 200;
        //System.out.println(x);
        //String[] aa = {"1", "6", "3", "4"};
        //Arrays.sort(aa);
        //System.out.println(Arrays.toString(aa));

        TestClass tc = new TestClass();
        tc.stringStudy();

        //Student s = new Student("zhansan", 100);
        //System.out.println(s.getName());
    }

}

class TestClass {

    public void integrityStudy() {
        //应该选择合适方位的整型(int或long)，没必要为了节省内存而使用byte和short
        //byte占用1个字节
        byte b = 127;
        //short占用2个字段 char也是2个字节
        short s = 32767;
        //int占用4个字节 float也是占用4个字节
        int i = 1;
        //long占用8个字节 double也是8个字节
        long l = 1000000000000000L;
    }

    public void floatStudy() {
        float f = 4.1f;
        double d = 10.2;
    }

    public void charStudy() {
        //char是基本类型
        //一个char保存一个Unicode字符，所以一个英文字符和一个中文字符都用一个char来表示，占用2个字节
        char c = '中';
        char c1 = '2';
    }

    public void stringStudy() {
        //String是引用类型，但是字符串有个特点就是，内容不可改变，重新赋值后，会新增一个内存地址
        String s = "string ";
        String hello = " hello " + s;
        System.out.println(hello);
        //去掉首尾空格
        String newHello = hello.trim();
        System.out.println(newHello);

        //判断两个字符串是否相等，必须总是使用equals()方法。要忽略大小写比较，使用equalsIgnoreCase()方法。
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        String s3 = "HELLO";
        System.out.println(s1 == s2);//flase
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equalsIgnoreCase(s3));//true

        //字符串截取
        "Hello".substring(2, 4); //"ll"
        //字符串替换 s.replace("H", "h");
        //字符串分割
        String s10 = "张三,李四,王五";
        String[] s10arr = s10.split(",");
        System.out.println(s10arr[1]);
        //数组转字符串 String.join(',', arr);
    }

    public void finalStudy() {
        //常量名全部大写
        final int PP = 100;
    }

    public void arrayStudy() {
        //数组一旦创建后，大小就不可改变了
        int[] intarr = new int[3];
        int[] intarr1 = new int[]{100, 10, 200, 30};
        int[] intarr2 = {100, 200, 300};
        //.length获取数组大小
        System.out.println(intarr.length);

        String[] stringarr = {"zhang", "wang"};
        System.out.println(Arrays.toString(stringarr));
        //数组排序
        Arrays.sort(intarr1);
        System.out.println(Arrays.toString(intarr1));

        //多维数组
        int[][] intarrarr = {{1, 3, 2}, {100, 300, 200}};
        //多维数组打印
        System.out.println(Arrays.deepToString(intarrarr));
    }

    public void forStudy() {
        int[] int1 = {1, 2, 3};
        for (int i : int1) {
            System.out.println(i);
        }
    }

    public void mathStudy() {
        //0 <= x < 1
        System.out.println(Math.random());
    }
}

class Person {
    protected String name;
    private int age;

    //和普通方法相比，构造方法没有返回值，也没有void
    //如果不写构造方法，编译器默认生成一个无任何参数的，没有任何执行语句的方法，类似public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //java可以多个构造方法
    public Person(String name) {
        this.name = name;
        this.age = 10;
    }

    public Person() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //这种方法名相同，但各自的参数不同，称为方法重载（Overload），php本身没有重载功能，可以自己手动写代码实现
    //重载，把这一组方法名做成同名方法。方法重载的目的是，功能类似的方法使用同一名字，更容易记住，因此，调用起来更简单。
}
//在Java中，没有明确写extends的类，编译器会自动加上extends Object。所以，任何类，除了Object，都会继承自某个类。
class Student extends Person {

    private int score;

    public Student(String name, int score) {
        //在Java中，任何class的构造方法，第一行语句必须是调用父类的构造方法。如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句super();
        //如果下面这行代码没声明，则默认调用super();
        super(name);
        //得出结论：如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法。
        //这里还顺带引出了另一个问题：即子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。
        this.score = score;
    }

    public void sayHello() {
        System.out.println("Hello " + super.name);
    }
}

//抽象类【多态：继承、重写】抽象类无法实例化
//final修饰的类无法被继承，final修饰的方法无法被重写
//如果一个class定义了方法，但没有具体执行代码，这个方法就是抽象方法，抽象方法用abstract修饰。
//因为无法执行抽象方法，因此这个类也必须申明为抽象类（abstract class）。
//使用abstract修饰的类就是抽象类。我们无法实例化一个抽象类：
//抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。
abstract class Animal {
    //把一个方法声明为abstract，表示它是一个抽象方法，本身没有实现任何方法语句
    public abstract void run();
}

class Doge extends Animal {

    @Override
    public void run() {
        System.out.println("doge run");
    }
}
//所谓interface，就是比抽象类还要抽象的纯抽象接口，因为它连字段都不能有。因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）。
//如果一个抽象类没有实例字段，所有方法全部都是抽象方法：就可以把该抽象类改写为接口：interface。
//接口可以有静态字段，字段必须是public static final类型，所以可以省略public static final
//在接口中，可以定义default方法。default方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
//default方法和抽象类的普通方法是有所不同的。因为interface没有字段，default方法无法访问字段，而抽象类的普通方法可以访问实例字段。
interface Tree {
    //字段省略public static final
    int MALE = 1;

    //接口中的方法都是默认省略 public abstract的
    void setName(String name);

    String getName();
}

//实现接口要用implements，实现可以多个接口，继承则只能继承一个类
class AppleTree implements Tree {

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

//静态字段和静态方法
//推荐用类名来访问静态字段。可以把静态字段理解为描述class本身的字段（非实例字段）。
//因为静态方法属于class而不属于实例，因此，静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段
//静态方法常用于工具类和辅助方法。


//Java定义了一种名字空间，称之为包：package，包名推荐，使用域名的倒置写法，跟php的namespace类似
//要特别注意：包没有父子关系。java.util和java.util.zip是不同的包，两者没有任何继承关系。
//import引用别的class，跟php的use类似
//最后，包作用域是指一个类允许访问同一个package的没有public、private修饰的class，以及没有public、protected、private修饰的字段和方法。

//如果不确定是否需要public，就不声明为public，即尽可能少地暴露对外的字段和方法。
//把方法定义为package权限有助于测试，因为测试类和被测试类只要位于同一个package，测试代码就可以访问被测试类的package权限方法。


//注解是放在Java源码的类、方法、字段、参数前的一种特殊“注释”：注释会被编译器直接忽略，注解则可以被编译器打包进入class文件，因此，注解是一种用作标注的“元数据”。
//从JVM的角度看，注解本身对代码逻辑没有任何影响，如何使用注解完全由工具决定。
