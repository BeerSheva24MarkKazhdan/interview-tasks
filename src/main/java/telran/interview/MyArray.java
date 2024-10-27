package telran.interview;

import java.util.Arrays;

public class MyArray<T> {
    private final Object[] array;
    private T allValue = null;
    private boolean isAllSet = false;

    public void setAll(T value) {
        allValue = value;
        isAllSet = true;
        Arrays.fill(array, null); 
    }

    public void set(int index, T value) {
        checkIndex(index);
        if (isAllSet) {
            array[index] = value;
        } else {
            array[index] = value;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return isAllSet 
        ? (T) (array[index] != null ? array[index] : allValue) 
        : (T) array[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public MyArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        array = new Object[size];
    }
}
