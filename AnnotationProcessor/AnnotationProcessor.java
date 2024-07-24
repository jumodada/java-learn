import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@interface MyAnnotation{
    String value();
    int id();
}

class Test{
    @MyAnnotation(value = "Parker", id =1)
    String name;
    @MyAnnotation(value = "byd", id =2)
    String realName;

    @MyAnnotation(value = "Bier", id =3)
    void sayMyName(String name){
        System.out.println(name);
    }
}

public class AnnotationProcessor{
    public static void main(String[] args) {
            Class<Test> test = Test.class;
            for (Field field : test.getDeclaredFields()){
                if(field.isAnnotationPresent(MyAnnotation.class)){
                    System.out.println(field.getName() + "&& id: " +  field.getAnnotation(MyAnnotation.class).id() + " && name: " + field.getAnnotation(MyAnnotation.class).value());
                }
            }
    }
}