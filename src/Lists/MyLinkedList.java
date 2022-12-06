package Lists;

import java.util.LinkedList;

public class MyLinkedList<E>  {
    private static class Atom<E> {
            E item;
            transient Atom<E> prev;
            transient Atom<E> next;

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
        if (index > size || index < 0 ) {
            throw new IndexOutOfBoundsException("I have no such index: " + index);
        }
        Atom<E> newAtom = new Atom<>(element, null, null);
        if (index == 0) {
            atomIndex(index).prev = newAtom;
            newAtom.next = first;
            first = newAtom;
            size ++;
        } else if (index == size) {
            addElement(element);
        } else {
            atomIndex(index).prev = newAtom;
            newAtom.prev = atomIndex(index).prev;
            newAtom.next = atomIndex(index);
            atomIndex(index - 1).next = newAtom;
            size ++;
        }

    } //Добавление элемента в конкретное место.

    Atom<E> atomIndex(int index) {
        if (index == size) {
            throw new IndexOutOfBoundsException("I have no such index: " + index);
        }
        Atom<E> susAtom = first;
        for (int i = 0; i < index; i++)
            susAtom = susAtom.next;
        return susAtom;
    }
    public void deleteElementIndex(int index) {

    }         //Удаление элемента по индексу.

    public void deleteElement(E element) {

    }              //Удаление первого вхождения элемента.



    public Object print(int index) {
        return 2;
    } //Напечатать конкретный элемент листа.

    public int length() {
        return size;
    }      //Возвращает длину листа.

    public void printAll() {
        Atom toPrint = first;
        for (int i = 0; i < size; i++) {
            System.out.println(toPrint.item);
            toPrint = toPrint.next;
        }

    }

}
