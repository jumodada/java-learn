import java.util.AbstractList;
import java.util.Arrays;

public class newArrayList extends AbstractList {
    private static final int DEFAULT_CAPACITY = 10;
    transient Object[] elementData;
    private int size;
    public newArrayList(int initialCapacity) {
        if(initialCapacity < 0){
            throw new RuntimeException("Error");
        }
        int capaccity = DEFAULT_CAPACITY;
        if(initialCapacity > DEFAULT_CAPACITY) {
            capaccity = initialCapacity;
        }
        this.elementData = new Object[capaccity];
        this.size = this.elementData.length;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    public Object set(int index, Object ele) {
        rangeCheck(index);
         elementData[index] = ele;
        return ele;
    }

    @Override
    public int size() {
        return size;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, elementData.length);
    }

    public void add(int index, Object element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == elementData.length) {
            int newCapacity = elementData.length + (elementData.length >> 1);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        if (index < size) {
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
        }
        elementData[index] = element;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // [1,2,3,4]
    // [1 ,3, 4 ,4]
    // [1 ,3, 4 ,null]

    public void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    private void  rangeCheck(int index){
        if(index<0 || index > size){
            throw new RuntimeException("Error");
        }
    }

    public boolean remove(Object o) {
        int i = indexOf(o);
        if(i> -1){
            fastRemove(i);
            return true;
        }else {
            return false;
        }
    }


    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++){
                if (elementData[i]==null){
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++){
                if (o.equals(elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }

}
