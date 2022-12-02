# Homework-4

Реализовать класс IntLinkedList который имплементит интерфейс IntList

```
boolean add(int element);

boolean add(int index, int element);

void clear();

int get(int index);

boolean isEmpty();

boolean remove(int index);

boolean removeByValue(int value);

boolean set(int index, int element);

int size();

IntList subList(int fromIndex, int toIndex);

int[] toArray();
```
И имплементит еще 2 интерфейса
IntQueue:


```
    boolean add(int value);
    int remove(); // return first in Queue but and remove it
    int element(); // return first in Queue but not remove it
```

IntStack:

    boolean push(int value);
    int pop(); // remove and get value on top of Stack
    int peek(); // get value on top of Stack
