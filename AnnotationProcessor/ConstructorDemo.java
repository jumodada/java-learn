import java.lang.reflect.Field;

class AC {
    private String name;

    public void sayName() {
        System.out.println(this.name);
    }
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
public class ConstructorDemo {
    public static void main(String[] args) throws NoSuchFieldException {
       try {
           AC instance = new AC();
           Class<AC> ac = AC.class;
           Field field = ac.getDeclaredField("name");
           field.setAccessible(true);
           field.set(instance, "peter");
           instance.sayName();
       }catch (NoSuchFieldException | IllegalAccessException e){
           throw new RuntimeException(e);
       }
    }
}
