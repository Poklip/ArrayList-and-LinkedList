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

        MyArrayList<Integer> fgh = new MyArrayList<>(0);
        MyArrayList<Integer> testArrList = new MyArrayList<>(0);
        MyArrayList<Integer> emptyList = new MyArrayList<>(0);

        for (int i = 0; i < 14; i++) {
            fgh.addElement(i);
        }
        for (int i = 0; i < 3; i++) {
            testArrList.addElement(60065);
        }
        emptyList.addCollection(testArrList);
        //emptyList.printAll();
        fgh.addElement(4);
        fgh.addElementWhere(3, -5);
        fgh.cutTo(10);
        fgh.deleteElementIndex(4);
        fgh.deleteElement(4);
        //fgh.printAll();
        fgh.addCollectionWhere(6, testArrList);
        //fgh.printAll();

        MyLinkedList<Integer> mll = new MyLinkedList<>();
        for (int i = 0; i < 5; i ++) {
            mll.addElement(i);
        }


        System.out.println("Length: " + mll.length() + "\n");

        mll.addElementWhere(3, 22);
        System.out.println("Length: " + mll.length() + "\n");
        mll.deleteElementIndex(5);
        mll.printAll();





    }




}