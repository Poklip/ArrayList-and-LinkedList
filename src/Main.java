import Lists.MyArrayList;
import Lists.MyLinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static LinkedList<String> giveMeLinkedList() {

        LinkedList<String> linkedStrings = new LinkedList<>();
        linkedStrings.add("Hi.");
        linkedStrings.add("How are you?");
        linkedStrings.add("I'm great.");
        linkedStrings.add("My name is Vasya.");
        linkedStrings.add("Goodbye.");
        linkedStrings.add(4, "Bobobo."); //быстрее, чем у эррэйлиста
        return linkedStrings;
    }

    public static ArrayList<String> giveMeArrayList() {

        ArrayList<String> arrayStrings = new ArrayList<>();
        arrayStrings.add("Hi.");
        arrayStrings.add("How are you?");
        arrayStrings.add("I'm great.");
        arrayStrings.add("My name is Vasya.");
        arrayStrings.add("Goodbye.");
        arrayStrings.add(0, "Bobobo.");
        arrayStrings.remove(3);
        return arrayStrings;
    }

    Iterator<String> iterator = new Iterator<String>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public String next() {
            return null;
        }

    };

    public static void main(String[] args) {

        for (String str : giveMeArrayList()) {
            System.out.println(str);
        }

/*        for (String str : giveMeLinkedList()) {
            System.out.println(str);
        }

        ArrayList<Giraffe> giraffes = new ArrayList<>();

        for (int i = 40; i < 140; i++) {
            Giraffe giraffe = new Giraffe();
            giraffe.height = i;
            giraffes.add(giraffe);
        }*/

        //тестирование май эррэй лист
        MyArrayList<Integer> mal = new MyArrayList<>(0);
        MyArrayList<Integer> testArrList = new MyArrayList<>(0);
        MyArrayList<Integer> emptyList = new MyArrayList<>(0);

        for (int i = 0; i < 14; i++) {
            mal.addElement(i);
        }
        for (int i = 0; i < 3; i++) {
            testArrList.addElement(60065);
        }
        emptyList.addCollection(testArrList);
        //emptyList.printAll();
        mal.addElement(4);
        mal.addElementWhere(3, -5);
        mal.cutTo(10);
        mal.deleteElementIndex(4);
        mal.deleteElement(4);
        //mal.printAll();
        mal.addCollectionWhere(6, testArrList);
        //mal.printAll();


        //тестирование май линкед лист
        MyLinkedList<Integer> mll = new MyLinkedList<>();
        MyLinkedList<Integer> mllTest = new MyLinkedList<>();
        for (int i = 1; i < 6; i ++) {
            mll.addElement(i);
            mllTest.addElement(i * 10);
        }

        //не забывай про equals для объектов, мудятел

        System.out.println("Length: " + mll.length() + "\n");
        mll.addElementWhere(3, 320);
        mll.addCollectionWhere(5, mllTest);
        mll.deleteElement(40);
        mll.printAll();
        System.out.println("Length: " + mll.length() + "\n");





    }




}