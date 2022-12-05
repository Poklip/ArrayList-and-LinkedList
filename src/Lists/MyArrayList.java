package Lists;

public class MyArrayList<E>{
    transient Object[] elementData;
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = new Object[]{};
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }
    private void getBigger(int howMuch) {                                //увеличивает массив на N ячеек
        Object[] subArray = new Object[elementData.length + howMuch];
        System.arraycopy(elementData, 0, subArray, 0, elementData.length);
        elementData = subArray;
    }

    private Object[] toArray() {
        return elementData;
    }

    public void deleteElementIndex(int index) {
        Object[] subArray = new Object[elementData.length - 1];
        if (index >= 0) System.arraycopy(elementData, 0, subArray, 0, index);
        if (elementData.length - (index + 1) >= 0)
            System.arraycopy(elementData, index + 1, subArray, index, elementData.length - (index + 1));
        elementData = subArray;
    }

    public void deleteElement(E element) {                     //Удаляет первое вхождение элемента.
        int indexProwler = -1;
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == element) {
                indexProwler = i;
                break;
            }
        }
        if (indexProwler != -1) deleteElementIndex(indexProwler);
    }

    public void addElement(E element) {                    //Вставляет элемент. Если массив пустой, увеличивает на один и вставляет, если заполнен, увеличивает на один и вставляет.
        if (elementData.length == 0) {
            elementData = new Object[]{element};
        } else {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null) {
                    elementData[i] = element;
                    break;
                } else if (i == elementData.length - 1) {
                    getBigger(1);
                    elementData[elementData.length - 1] = element;
                    break;
                }
            }
        }
    }

    public void addElementWhere(int index, E element) { //ставляет элемент куда надо.
        if (elementData.length == 0) {
            elementData = new Object[]{element};
        } else {
            int lengthForShift = 0;
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null) {
                    lengthForShift = i;
                    break;
                } else if (i == elementData.length - 1) {
                    getBigger(1);
                    lengthForShift = elementData.length - 1;
                    break;
                }
            }
            for (int i = lengthForShift; i > index; i--) {
                elementData[i] = elementData[i - 1];
            }
            elementData[index] = element;
        }

    }

    public void addCollection(MyArrayList collection) {
        if (elementData.length == 0) {
            elementData = collection.toArray();
        } else {
            Object[] subArray = new Object[elementData.length + collection.toArray().length];
            System.arraycopy(elementData, 0, subArray, 0, elementData.length);
            System.arraycopy(collection.toArray(), 0, subArray, elementData.length, collection.toArray().length);
            elementData = subArray;
        }
    }

    public void addCollectionWhere(int index, MyArrayList collection) {
        if (elementData.length == 0) {
            elementData = collection.toArray();
        } else {
            int length = collection.toArray().length;
            Object[] subArray = new Object[elementData.length + length];
            System.arraycopy(elementData, 0, subArray, 0, index);
            System.arraycopy(collection.toArray(), 0, subArray, index, length);
            if (elementData.length - index >= 0)
                System.arraycopy(elementData, index, subArray, index + length, elementData.length - index);
            elementData = subArray;
        }
    }


    public Object print(int index) {                    //Написать элемент.
        return elementData[index];
    }

    public void printAll () {
        for (Object str:elementData) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }

    public void cutTo(int length){                      //Обрезать до такой-то длины.
        Object[] subArray = new Object[length];
        for (int i = 0; i < subArray.length; i++) {
            subArray[i] = elementData[i];
        }
        elementData = subArray;
    }

    public int length() {                               //Показать длину.
        return elementData.length;
    }
}