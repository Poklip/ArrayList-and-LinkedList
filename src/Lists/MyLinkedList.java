package Lists;

import java.util.NoSuchElementException;

//не забывай про equals для объектов, мудятел
public class MyLinkedList<E>  {
    private static class Atom<E> {
            E item;
            transient Atom prev;
            transient Atom next;

        private Atom(E element, Atom<E> prev, Atom<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }

    }
    transient Object[] infoList;
    int size = 0;
    Atom first;
    Atom last;
    public MyLinkedList() {
        this.infoList = new Object[3];
        this.infoList[0] = size;
        this.infoList[1] = first;
        this.infoList[2] = last;
    }

    public void addElement(E element) {
        Atom<E> newAtom = new Atom<>(element, null, null);
        if (size == 0) {
            first = last = newAtom;
        } else if (size == 1) {
            last = newAtom;
            first.next = last;
            last.prev = first;
        } else {
            last.next = newAtom;
            newAtom.prev = last;
            last = newAtom;
        }
        size ++;

    }                 //Добавление элемента.

    public void addElementWhere(int index, E element) {
        final Atom<E> newAtom = new Atom<>(element, null, null);
        if (index == 0) {
            atomIndex(index).prev = newAtom;
            newAtom.next = first;
            first = newAtom;
            size ++;
        } else if (index == size) {
            addElement(element);
        } else {
            newAtom.prev = atomIndex(index).prev;
            newAtom.next = atomIndex(index);
            atomIndex(index - 1).next = newAtom;
            atomIndex(index).prev = newAtom;
            size ++;
        }


    } //Добавление элемента в конкретное место.

    Atom<E> atomIndex(int index) {
        Atom<E> susAtom;
        if (index <= size / 2) {
            susAtom = first;
            for (int i = 0; i < index; i++)
                susAtom = susAtom.next;
        } else if (index >= size/2 && index < size) {
            susAtom = last;
            for (int i = size; i > index + 1; i--)
                susAtom = susAtom.prev;
        } else {
            throw new IndexOutOfBoundsException("I have no such index: " + index);
        }
        return susAtom;

    }
    public void deleteElementIndex(int index) {
        if (index == 0) {
            first.item = null;
            first = first.next;
        } else if (index == size - 1) {
            last.item = null;
            last = last.prev;
        } else {
            Atom<E> susAtom = atomIndex(index);
            Atom<E> atomPrev = atomIndex(index - 1);
            Atom<E> atomNext = atomIndex(index + 1);
            atomPrev.next = atomNext;
            atomNext.prev = atomPrev;
            susAtom.item = null;
        }
        size--;
    }         //Удаление элемента по индексу.

    public void deleteElement(E element) {
        if (isThere(element) == -1) {
            throw new IllegalArgumentException("I have no such element: " + element);
        } else if (element == first.item) {
            first.item = null;
            first = first.next;
            size --;
        } else if (element == last.item) {
            last.item = null;
            last = last.prev;
            size --;
        } else {
            deleteElementIndex(isThere(element));
        }
    }              //Удаление первого вхождения элемента.

    public void addCollection(MyLinkedList<E> collection){
        if (size == 0) {
            throw new NoSuchElementException("Acceptor is empty.");
        }
        last.next = collection.first;
        collection.first.prev = last;
        last = collection.last;
        size += collection.size;
    }

    public void addCollectionWhere(int index, MyLinkedList<E> collection) {
        if (index == 0) {
            first.prev = collection.last;
            collection.last.next = first;
            first = collection.first;
            size += collection.size;
        } else if (index == size) {
            addCollection(collection);
        } else if (index > 0 || index < size) {
            final Atom<E> next4new = atomIndex(index);
            final Atom<E> prev4new = atomIndex(index - 1);
            collection.first.prev = prev4new;
            collection.last.next = next4new;
            prev4new.next = collection.first;
            next4new.prev = collection.last;
            size += collection.size;
        } else {
            throw new IndexOutOfBoundsException("I have no such index: " + index);
        }
    }
    public int isThere(E element) {
        Atom<E> susAtom = first;
        for (int i = 0; i < size; i++) {
            if (element.equals(susAtom.item)) {
                return i;
            }
            susAtom = susAtom.next;
        }
        return -1;
    }

    public void print(int index) {
        System.out.println(atomIndex(index).item);
    } //Напечатать конкретный элемент листа.

    public int length() {
        return size;
    }      //Возвращает длину листа.

    public void printAll() {
        Atom<E> toPrint = first;
        for (int i = 0; i < size; i++) {
            System.out.println(toPrint.item);
            toPrint = toPrint.next;
        }

    }

}
