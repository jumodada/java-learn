import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
class A {
    public void sayIt(String name) {
        System.out.println(name);
    }
    private void sayItPrivate(String name) {
        System.out.println(name);
    }
    static void sayItStatic(String name) {
        System.out.println(name);
    }
}
public class InvokeDemo {
    public static void main(String[] args) {
        try {
            A a = new A();
            Class<? extends A> ac = a.getClass();
            Method m = ac.getMethod("sayIt", String.class); // 指定参数类型
            Method m2 = ac.getDeclaredMethod("sayItPrivate", String.class);
            Method m3 = ac.getDeclaredMethod("sayItStatic", String.class);
            m.invoke(a, "Aren"); // 调用方法
            m2.setAccessible(true);
            m2.invoke(a, "private");
            m3.invoke(null, "static");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}