package collections.list.linked;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class CustomLinkedList<T> implements List<T> {
    List list = new LinkedList();
    int size = 0;

    CustomEntry<T> first;
    CustomEntry<T> last;

    private static class CustomEntry<T> {
        T element;
        CustomEntry<T> next;
        CustomEntry<T> prev;

        public CustomEntry(T element, CustomEntry<T> next, CustomEntry<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private void validationIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("нет такого индекса");
        }
    }

    private CustomEntry<T> findByIndex(int index) {
        CustomEntry<T> entry = first;
        for (int i = 0; i < index; i++) {
            entry = entry.next;
        }
        return entry;
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
    public Object[] toArray() {
        Object[] objects = new Object[size];
        for (int i = 0; i < size; i++) {
            objects[i] = findByIndex(i).element;
        }
        return objects;
    }

    @Override
    public boolean add(T o) {
        CustomEntry<T> entry = last;
        last = new CustomEntry<>(o, null, last);
        if (entry == null) {
            first = last;
        } else {
            entry.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }

    @Override
    public boolean addAll(@NotNull Collection c) {
        for (Object o : c) {
            add((T) o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection c) {
        for (Object o : c) {
            add(index, (T) o);
            index++;
        }
        return true;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        validationIndex(index);
        CustomEntry<T> entry = findByIndex(index);
        return entry.element;
    }

    @Override
    public T set(int index, T element) {
        validationIndex(index);
        T old;
        if (index == size - 1) {
            old = last.element;
            last.element = element;
        } else {
            CustomEntry<T> entry = findByIndex(index);
            old = entry.element;
            entry.element = element;
        }
        return old;
    }

    @Override
    public void add(int index, T element) {
        validationIndex(index);
        if (index == size) {
            add(element);
        } else {
            CustomEntry<T> movedEntry = findByIndex(index);
            CustomEntry<T> newEntry = new CustomEntry<>(element, movedEntry, movedEntry.prev);
            if (movedEntry.prev == null) {
                first = newEntry;
            } else {
                movedEntry.prev.next = newEntry;
            }
            movedEntry.prev = newEntry;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        validationIndex(index);
        CustomEntry<T> deletedEntry = findByIndex(index);
        if (deletedEntry.prev == null) {
            first = deletedEntry.next;
        } else if (deletedEntry.next == null) {
            last = deletedEntry.prev;
        } else {
            deletedEntry.prev.next = deletedEntry.next;
            deletedEntry.next.prev = deletedEntry.prev;
        }

        size--;

        return deletedEntry.element;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (CustomLinkedList.CustomEntry<T> i = first; i != null; i = i.next) {
                if (i.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (CustomLinkedList.CustomEntry<T> i = first; i != null; i = i.next) {
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
        int index = size - 1;
        if (o == null) {
            for (CustomLinkedList.CustomEntry<T> i = last; i != null; i = i.prev) {
                if (i.element == null) {
                    return index;
                }
                index--;
            }
        } else {
            for (CustomLinkedList.CustomEntry<T> i = last; i != null; i = i.prev) {
                if (o.equals(i.element)) {
                    return index;
                }
                index--;
            }
        }
        return -1;
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
        for (int i = 0; i < size; i++) {
            if (!c.contains(findByIndex(i).element)) {
                remove(findByIndex(i).element);
                i--;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(@NotNull Collection c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public boolean containsAll(@NotNull Collection c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    @Override
    public Object[] toArray(@NotNull Object[] a) {
        return new Object[0];
    }
}
