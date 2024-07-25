import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
class MyClass {
    private int num;
    public MyClass(int num) {
        this.num = num;
    }
    public void printMessage() {
        System.out.println("num: " + num);
    }
}
public class newInstancesDemo {
    public static void main(String[] args) {
        try {
            // 获取 MyClass 的 Class 对象
            Class<MyClass> myClassClass = MyClass.class;

            // 获取带有 String 参数的构造函数
            Constructor<MyClass> constructor = myClassClass.getConstructor(int.class);
            // 使用构造函数创建实例
            MyClass myClassInstance = constructor.newInstance(1);
            // 调用实例方法
            myClassInstance.printMessage();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
