package Homework3;

public class Main {
    public static void main(String[] args) {
        DLList dl = new DLList();
        dl.genList(5);
        dl.print();
        dl.revert();
        dl.print();
    }
}
