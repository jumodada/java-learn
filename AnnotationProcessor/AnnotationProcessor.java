import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@interface MyAnnotation {
    String value();
}

public class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        // 获取类
        Class<MyClass> myClass = MyClass.class;
        // 处理字段上的注解
        for (Field field : myClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
                System.out.println("Field: " + field.getName() + ", Annotation value: " + annotation.value());
            }
        }
        // 处理方法上的注解
        for (Method method : myClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("Method: " + method.getName() + ", Annotation value: " + annotation.value());
            }
        }
    }
}
class MyClass {
    @MyAnnotation(value = "Field Annotation")
    private String myField;
    @MyAnnotation(value = "Method Annotation")
    public void myMethod() {
        // 方法体
    }
}