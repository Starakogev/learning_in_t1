package collections.list.linked;

import org.jetbrains.annotations.NotNull;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList extends AbstractSequentialList implements List, Deque {
    List listTest = new LinkedList();

    int size = 0;

    CustomEntry first;
    CustomEntry last;

    private static class CustomEntry {
        Object element;
        CustomEntry next;
        CustomEntry prev;

        public CustomEntry(Object element, CustomEntry next, CustomEntry prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
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
        return indexOf(o) != -1;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return null;
    }

    @NotNull
    @Override
    public Iterator descendingIterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void addFirst(Object o) {
        CustomEntry entry = first;
        first = new CustomEntry(o, first, null);
        if (entry == null) {
            last = first;
        } else {
            entry.prev = first;
        }
        size++;
    }

    @Override
    public void addLast(Object o) {
        CustomEntry entry = last;
        last = new CustomEntry(o, null, last);
        if (entry == null) {
            first = last;
        } else {
            entry.next = last;
        }
        size++;
    }

    private void validationIndex(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("нет такого индекса");
        }
    }

    @Override
    public boolean offerFirst(Object o) {
        return false;
    }

    @Override
    public boolean offerLast(Object o) {
        return false;
    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public Object removeLast() {
        return null;
    }

    @Override
    public Object pollFirst() {
        return null;
    }

    @Override
    public Object pollLast() {
        return null;
    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public Object peekFirst() {
        return null;
    }

    @Override
    public Object peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(Object o) {
        addLast(o);
        return true;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public void push(Object o) {

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {
        validationIndex(index);

        if (index == size) {
            addLast(element);
        } else {
            CustomEntry entry = first;
            for (int i = 0; i < index; i++) {
                entry = entry.next;
            }
            CustomEntry beforeAdded = entry.prev;
            entry.prev = new CustomEntry(element, entry, beforeAdded);
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (CustomLinkedList.CustomEntry i = first; i != null; i = i.next) {
                if (i.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (CustomLinkedList.CustomEntry i = first; i != null; i = i.next) {
                if (o.equals(i.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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
