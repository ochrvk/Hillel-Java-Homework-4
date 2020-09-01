package chrvk.hw4;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    public IntLinkedList(Entry first, Entry last, int size) {
        this.first = first;
        this.last = last;
        this.size = size;
    }

    public IntLinkedList() {
    }

    private static class Entry {
        int value;
        Entry previous;
        Entry next;

        public Entry(int value) {
            this.value = value;
        }
    }

    private int size;
    private Entry first;
    private Entry last;

    @Override
    public boolean add(int value) {
        Entry newElement = new Entry(value);
        if (size == 0) {
            first = newElement;
        } else {
            last.next = newElement;
            newElement.previous = last;
        }
        last = newElement;
        size++;
        return false;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            result[i] = tmp.value;
            tmp = tmp.next;
        }
        return result;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public int get(int index) {
        return getEntry(index).value;
    }

    private Entry getEntry(int index) {
        Entry tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public int remove() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        int result = first.value;
        first = first.next;
        size--;
        return result;
    }

    @Override
    public int element() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return first.value;
    }

    @Override
    public boolean add(int index, int element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        Entry tmp = first;
        Entry newElement = new Entry(element);
        if (index == size || index == 0) {
            if (size == 0) {
                first = newElement;
            } else {
                last.next = newElement;
                newElement.previous = last;
            }
            last = newElement;
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (i == index - 1) {
                    newElement.previous = tmp;
                    newElement.next = tmp.next;
                    tmp.next = newElement;
                } else if (i == index) {
                    tmp.previous = newElement;
                    size++;
                    last = last.next;
                }
                tmp = tmp.next;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        Entry tmp = first;

        for (int i = 0; i < size; i++) {
            if (i == index - 1) {
                tmp.next = tmp.next.next;
                size--;
                last = last.previous;
            }
            tmp = tmp.next;
        }
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        Entry tmp = first;

        for (int i = 0; i < size - 1; i++) {
            if (tmp.next.value == value) {
                tmp.next = tmp.next.next;
                size--;
                last = last.previous;
            }
            tmp = tmp.next;
        }
        return true;
    }

    @Override
    public boolean set(int index, int element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        Entry tmp = first;
        Entry newElement = new Entry(element);
        if (index == 0) {
            newElement.previous = tmp.previous;
            newElement.next = tmp.next;
            tmp = newElement;
            first = tmp;
        } else {
            for (int i = 0; i < size; i++) {
                if (i == index - 1) {
                    newElement.previous = tmp;
                    newElement.next = tmp.next.next;
                    tmp.next = newElement;
                }
                tmp = tmp.next;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        Entry tmpFirst = null;
        Entry tmpLast = null;
        Entry tmp = first;
        int tmpSize = toIndex - fromIndex;
        for (int i = 0; i < size; i++) {
            if (i == fromIndex) {
                tmpFirst = tmp;
            } else if (i == toIndex) {
                tmpLast = tmp;
            }
            tmp = tmp.next;
        }
        return new IntLinkedList(tmpFirst, tmpLast, tmpSize);
    }

    @Override
    public boolean push(int value) {
        Entry newElement = new Entry(value);
        if (size == 0) {
            first = newElement;
            last = newElement;
        } else {
            last = newElement;
            last.next = first;
            first = last;
        }
        size++;
        return true;
    }

    @Override
    public int peek() {
        int result = 0;
        if (size != 0) {
            result = first.value;
        }
        return result;
    }

    @Override
    public int pop() {
        int result = 0;
        if (size != 0) {
            result = first.value;
            first = first.next;
            size--;
        }
        return result;
    }
}