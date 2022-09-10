import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class DoublyLinkedListPrintHelper {
    public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result {

    /*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
     * The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        // Write your code here
        DoublyLinkedListNode lastNode = null;
        DoublyLinkedListNode now = llist;
        DoublyLinkedListNode tempNext = llist.next;

        if (llist == null)
            return null;

        if (tempNext == null)
            return llist;

        // found the last element
        while (now != null) {
            tempNext = now.next;
            now.next = now.prev;
            now.prev = tempNext;
            lastNode = now;
            now = now.prev;

        }
        return lastNode;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner bufferedReader = new Scanner(doc);


        int t = Integer.parseInt(bufferedReader.nextLine().trim());

        IntStream.range(0, t).forEach(tItr -> {

            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = Integer.parseInt(bufferedReader.nextLine().trim());

            IntStream.range(0, llistCount).forEach(i -> {

                int llistItem = Integer.parseInt(bufferedReader.nextLine().trim());

                llist.insertNode(llistItem);

            });

            DoublyLinkedListNode llist1 = Result.reverse(llist.head);


        });


    }
}
