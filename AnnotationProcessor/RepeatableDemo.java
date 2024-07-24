import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;
// 定义容器注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyRepeatableAnnotations{
    MyRepeatableAnnotation[] value();
}

@Repeatable(MyRepeatableAnnotations.class)
// 定义可重复的注解，并指定其容器注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyRepeatableAnnotation {
    String value();
}

@MyRepeatableAnnotation("First use of repeatable annotation.")
@MyRepeatableAnnotation("Second use of repeatable annotation.")
class AnnotatedClass {
    // Class code
}

public class RepeatableDemo {
    public static void main(String[] args) {
        // 获取 AnnotatedClass 的 Class 对象
        Class<AnnotatedClass> obj = AnnotatedClass.class;
        // 获取所有 MyRepeatableAnnotation 注解
        if (obj.isAnnotationPresent(MyRepeatableAnnotations.class)) {
            MyRepeatableAnnotations annotations = obj.getAnnotation(MyRepeatableAnnotations.class);
            for (MyRepeatableAnnotation annotation : annotations.value()) {
                System.out.println("Value: " + annotation.value());
            }
        } else if (obj.isAnnotationPresent(MyRepeatableAnnotation.class)) {
            // 如果只有一个 MyRepeatableAnnotation 注解，直接读取
            MyRepeatableAnnotation annotation = obj.getAnnotation(MyRepeatableAnnotation.class);
            System.out.println("Value: " + annotation.value());
        }
    }
}