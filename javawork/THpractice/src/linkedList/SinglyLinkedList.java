package linkedList;

/**
 * 단일 연결 리스트 클래스
 */
public class SinglyLinkedList {
    private Node head;

    SinglyLinkedList() {
        this.head = null;
    }

    SinglyLinkedList(int value) {
        this.head = new Node(value, null);
    }

    class Node {
        private int value; // 값
        private Node next; // 포인터 //인접한 노드의 주소는 next에 저장됨.

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return this.value;
        }
    }

    public Node getHead() {
        return this.head;
    }

    /**
     * 단일 연결 리스트 끝에 노드를 추가
     * @param value
     */
    public void append(int value) {
        if (this.head == null) {
            this.head = new Node(value, null);
            return;
        }

        Node pointer = this.head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }

        pointer.next = new Node(value, null);
    }

    /**
     * 인자 값으로 같은 노드 삭제
     * @param value
     */
    public void delete(int value) {
        Node pointer = this.head;

        // 첫 노드의 값이 인자 값과 같으면
        if (pointer.getValue() == value) {
            Node removeNode = this.head;
            this.head = this.head.next;

            removeNode = null;
            return;
        }

        Node temp = pointer;
        // 포인터가 null이 아니고 값이 다를 때까지 반복
        while (pointer != null && pointer.getValue() != value) {
            temp = pointer;
            pointer = pointer.next;
        }

        // 마지막 노드를 삭제하는 경우
        if (pointer.next == null) {
            temp.next = null;
        } else {
            temp.next = pointer.next;
        }
        pointer = null;
    }

    /**
     * 모든 노드 출력
     */
    public void printAll() {
        Node pointer = this.head;

        StringBuilder builder = new StringBuilder();
        while (pointer.next != null) {
            builder.append(pointer.getValue());
            builder.append(" -> ");
            pointer = pointer.next;
        }

        builder.append(pointer.getValue());
        System.out.println(builder.toString());
    }
}
