package linkedList;

public class DLLInsertionMain {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.append(1);
        doubleLinkedList.append(3);
        doubleLinkedList.append(2);
        doubleLinkedList.append(20);
        doubleLinkedList.append(19);

        System.out.print("이중 연결 리스트: ");
        doubleLinkedList.printAll();

        doubleLinkedList.printPrevNode(2);
        doubleLinkedList.printPrevNode(1);
        doubleLinkedList.printPrevNode(19);
    }
}
