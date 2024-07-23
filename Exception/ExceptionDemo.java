import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target({ElementType.METHOD, ElementType.FIELD})
@interface MyAnnotation {
    String value() default "default value";
}



class MyClass {
    @MyAnnotation(value = "Field Annotation")
    private String myField;
    @MyAnnotation(value = "Method Annotation")
    public void myMethod() {
        System.out.println(myField);
    }
    public static void main(String[] args) {
        MyClass instance = new MyClass();
        instance.myMethod();
    }
}


 class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        Class<MyClass> clazz = MyClass.class;
        // 处理字段上的注解
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
                System.out.println("Field: " + field.getName() + ", Annotation Value: " + annotation.value());
            }
        }
        // 处理方法上的注解
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("Method: " + method.getName() + ", Annotation Value: " + annotation.value());
            }
        }
    }
}

public class ExceptionDemo {
    public static void method1(){
        try {
                int[]  nums = new int[5];
                int num = nums[10];
        }catch (ArrayIndexOutOfBoundsException ex){
            throw new RuntimeException("ArrayIndexOutOfBoundsException:x    ");
        }
    }

    public static void main(String[] args) {
        method1();
    }
}
