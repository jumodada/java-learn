import java.util.Iterator;

public class NewIterator implements Iterator{

    private final int[] nums;
    private int cursor;

    public NewIterator(int[] nums) {
        this.nums = nums;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return nums.length > cursor;
    }

    @Override
    public Object next() {
        int number = nums[cursor];
        cursor++;
        return number;
    }
}
