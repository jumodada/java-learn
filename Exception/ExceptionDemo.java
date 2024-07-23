public class ExceptionDemo {
    public static void method1(){
        try {
                int[]  nums = new int[5];
                int num = nums[10];
        }catch (ArrayIndexOutOfBoundsException ex){
            throw new RuntimeException("ArrayIndexOutOfBoundsException:x");
        }
    }

    public static void main(String[] args) {
        method1();
    }
}
