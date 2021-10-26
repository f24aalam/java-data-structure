package linkedlist;

import java.util.Scanner;

public class LinkedListDemo {
    LinkedListNode head;

    /**
     * insert at the start of linked list
     * 
     * @param key
     * @param head
     * @return
     */
    LinkedListNode insertAtStart(int key, LinkedListNode head) {
        LinkedListNode temp = new LinkedListNode(key);

        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }

        return head;
    }

    /**
     * Insert data at the end of linked list
     * 
     * @param key
     * @param head
     * @return
     */
    LinkedListNode insertAtEnd(int key, LinkedListNode head) {
        LinkedListNode temp = new LinkedListNode(key);
        LinkedListNode tempHead =  head;

        if (tempHead == null) {
            head = temp;
        } else {
            while (tempHead.next != null) {
                tempHead = tempHead.next;
            }

            tempHead.next = temp;
        }

        return head;
    }

    /**
     * insert at the user specified position
     * 
     * @param key
     * @param position
     * @param head
     * @return
     */
    LinkedListNode insertAtPosition(int key, int position, LinkedListNode head) {
        LinkedListNode temp = new LinkedListNode(key);

        if (position == 1) {
            temp.next = head;
            head = temp;
        } else  {
            LinkedListNode tempHead = head;
            for (int i = 1; tempHead != null && i < position ; i++) {
                tempHead = tempHead.next;
            }

            temp.next = tempHead.next;
            tempHead.next = temp;
        }

        return head;
    }

    /**
     * delete a node at a position from the linked list.
     * 
     * @param position
     * @param head
     * @return
     */
    LinkedListNode delete(int position, LinkedListNode head) {
        LinkedListNode temp = head;

        if (position == 1) {
            head = temp.next;
        } else {
            for (int i = 1; temp != null && i < position -1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
        }

        return head;
    }

    /**
     * Returns the length of linked list.
     * 
     * @param head
     * @return
     */
    int length(LinkedListNode head) {
        LinkedListNode temp = head;

        int i = 0;

        if (temp == null) {
            return 0;
        }

        while (temp != null) {
            temp = temp.next;
            i++;
        }

        return i;
    }

    /**
     * reverse the linked list
     * 
     * @param head
     * @return
     */
    LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode previusNode = null, currentNode = head, nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previusNode;

            previusNode = currentNode;
            currentNode = nextNode;
        }

        head = previusNode;

        return head;
    }

    /**
     * Display the linked list
     * 
     * @param head
     */
    void display(LinkedListNode head) {
        LinkedListNode temp = head;

        System.out.println("*******");

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print("->");
            }
            temp = temp.next;
        }

        System.out.println("\n*******");
    }

    public static void main(String[] args) {
        LinkedListDemo list = new LinkedListDemo();
        list.head = null;

        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1. Insert At The Start");
            System.out.println("2. Insert At The End");
            System.out.println("3. Insert At The Position");
            System.out.println("4. Delete At a Position");
            System.out.println("5. Length");
            System.out.println("6. Reverse");
            System.out.println("7. Display");
            System.out.println("8. EXIT");
            System.out.println("Please Enter Your Choice");

            int choice = in.nextInt();

            switch (choice) {
                case 1: 
                    System.out.println("Enter the value:");
                    list.head = list.insertAtStart(in.nextInt(), list.head);
                    list.display(list.head);
                    break;
                case 2: 
                    System.out.println("Enter the value:");
                    list.head = list.insertAtEnd(in.nextInt(), list.head);
                    list.display(list.head);
                    break;
                case 3: 
                    System.out.println("Enter the value:");
                    int value = in.nextInt();
                    System.out.println("Enter Position");
                    int position = in.nextInt();
                    list.head = list.insertAtPosition(value, position, list.head);
                    list.display(list.head);
                    break;
                case 4: 
                    System.out.println("Enter the position");
                    list.head = list.delete(in.nextInt(), list.head);
                    list.display(list.head);
                    break;
                case 5: 
                    System.out.println("Length of list is: " + list.length(list.head));
                    list.display(list.head);
                    break;
                case 6:
                    list.head = list.reverse(list.head);
                    System.out.println("List Reversed!");
                    list.display(list.head);
                    break;
                case 7:
                    list.display(list.head);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice!");
                    break;
            }

            System.out.println("Do you want to continue... press 1 and enter");
        } while (in.nextInt() == 1);

        in.close();
    }
}
