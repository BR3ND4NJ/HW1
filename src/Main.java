import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void generateRandomGrades() throws IOException {
        Random r = new Random();
        PrintWriter pw = new PrintWriter("grades.txt");

        for (int i = 0; i < 20; i++) {
            if (i == 19) {
                pw.print(r.nextInt(100));
            } else {
                pw.println(r.nextInt(100));
            }
        }

        pw.close();
    }


    public static void SLLGrades() throws IOException {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();

        File file = new File("grades.txt");
        Scanner read = new Scanner(file);

        int[] grades = new int[20];
        int counter = 0;

        int currGrade;

        while (read.hasNext()) {
            currGrade = read.nextInt();
            grades[counter] = currGrade;

            if (sll.isEmpty()) {
                sll.addFirst(currGrade);
            }
            else {
                int len = sll.getSize();
                for (int i = 0; i < len; i++) {
                    int value = sll.get(i).getElement();
                    if (currGrade > value) {
                        sll.addAtIndex(i, currGrade);
                        break;
                    }
                }

                if (sll.getSize() == len) {
                    sll.addLast(currGrade);
                }

                if (sll.getSize() > 15) {
                    sll.removeLast();
                }
            }
            counter++;
        }

        System.out.println("Here are all the grades in the class");

        for (int i = 0; i < grades.length; i++) {
            if (i == grades.length - 1) {
                System.out.print(grades[i]);
            }
            else {
                System.out.print(grades[i] + ", ");
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("The top 15 Grades in the class (Highest to Lowest)");

        for (int i = 0; i < sll.getSize(); i++) {
            if (i == sll.getSize() - 1) {
                System.out.print(sll.get(i).getElement());
            }

            else {
                System.out.print(sll.get(i).getElement() + ", ");
            }
        }
    }


    public static void DLLGrades() throws IOException {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        File file = new File("grades.txt");
        Scanner read = new Scanner(file);

        int[] grades = new int[20];
        int counter = 0;

        int currGrade;

        while (read.hasNext()) {
            currGrade = read.nextInt();
            grades[counter] = currGrade;

            if (dll.isEmpty()) {
                dll.addFirst(currGrade);
            }
            else {
                int len = dll.getSize();
                for (int i = 0; i < len; i++) {
                    int value = dll.get(i).getElement();
                    if (currGrade > value) {
                        dll.addBetween(i, currGrade);
                        break;
                    }
                }

                if (dll.getSize() == len) {
                    dll.addLast(currGrade);
                }

                if (dll.getSize() > 15) {
                    dll.removeLast();
                }
            }
            counter++;
        }

        System.out.println("Here are all the grades in the class");

        for (int i = 0; i < grades.length; i++) {
            if (i == grades.length - 1) {
                System.out.print(grades[i]);
            }
            else {
                System.out.print(grades[i] + ", ");
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("The top 15 Grades in the class (Highest to Lowest)");

        for (int i = 0; i < dll.getSize(); i++) {
            if (i == dll.getSize() - 1) {
                System.out.print(dll.get(i).getElement());
            }

            else {
                System.out.print(dll.get(i).getElement() + ", ");
            }
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.println("----------SINGLY LINKED LIST---------");
        System.out.println();
        SLLGrades();
        System.out.println();

        System.out.println("----------DOUBLY LINKED LIST---------");
        System.out.println();
        DLLGrades();
        System.out.println();
    }
}
