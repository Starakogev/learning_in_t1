package collections.array;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class CustomArrayList<T> implements List<T> {
    List<T> list = new ArrayList<>();
    T[] array = (T[]) new Object[10];
    private int size = 0;

    private void ensureCapacity(int size) {
        if (size >= array.length) {
            T[] newArray = (T[]) new Object[size * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], equals(o))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return null;
    }

    @NotNull
    @Override
    public T[] toArray() {
        T[] newArray = (T[]) new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public boolean add(Object o) {
        ensureCapacity(size);
        array[size] = (T) o;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], equals(o))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection c) {
        return false;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return (T) new ArrayIndexOutOfBoundsException("нету такого индекса");
        } else {
            return array[index];
        }
    }

    @Override
    public Object set(int index, Object element) {
        Object old = array[index];
        array[index] = (T) element;
        return old;
    }

    @Override
    public void add(int index, Object element) {
        ensureCapacity(size);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = (T) element;
        size++;
    }

    @Override
    public T remove(int index) {
        int numMoved = size - index - 1;
        System.arraycopy(array, index + 1, array, index, numMoved);
        size--;
        return array[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], equals(o))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], equals(o))) {
                index = i;
            }
        }
        return index;
    }

    @NotNull
    @Override
    public ListIterator listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection c) {
        return false;
    }

    @NotNull
    @Override
    public Object[] toArray(@NotNull Object[] a) {
        return new Object[0];
    }
}
