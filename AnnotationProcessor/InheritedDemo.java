import java.lang.annotation.*;
import java.lang.reflect.Field;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyInheritedAnnotation {
    String value() default "Default Value";
}

@MyInheritedAnnotation(value = "Father")
class Father{

}

class Son extends Father{

}




public class InheritedDemo {
    public static void main(String[] args) {
        Class<Son> s = Son.class;
        System.out.println(s.getAnnotation(MyInheritedAnnotation.class));
    }
}
