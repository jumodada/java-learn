import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
class A {
    public void sayIt(String name) {
        System.out.println(name);
    }
}
public class InvokeDemo {
    public static void main(String[] args) {
        try {
            A a = new A();
            Class<? extends A> ac = a.getClass();
            Method m = ac.getMethod("sayIt", String.class); // 指定参数类型
            m.invoke(a, "Aren"); // 调用方法
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}