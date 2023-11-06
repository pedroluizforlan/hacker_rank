package com.hackerrank.datastructures.linkedlists;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


public class SolutionJavaCompareTwoLinkedLists {

    static class SinglyLinkedListNodeCompareTwoLinkedLists {
        public int data;
        public SinglyLinkedListNodeCompareTwoLinkedLists next;

        public SinglyLinkedListNodeCompareTwoLinkedLists(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedListCompareTwoLinkedLists {
        public SinglyLinkedListNodeCompareTwoLinkedLists head;
        public SinglyLinkedListNodeCompareTwoLinkedLists tail;

        public SinglyLinkedListCompareTwoLinkedLists() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNodeCompareTwoLinkedLists node = new SinglyLinkedListNodeCompareTwoLinkedLists(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNodeCompareTwoLinkedLists node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static boolean compareLists(SinglyLinkedListNodeCompareTwoLinkedLists head1, SinglyLinkedListNodeCompareTwoLinkedLists head2) {
        SinglyLinkedListNodeCompareTwoLinkedLists first = head1;
        SinglyLinkedListNodeCompareTwoLinkedLists second = head2;

        while(first.next != null && second.next != null){
            if (first.data != second.data){
                return false;
            }

            first = first.next;
            second = second.next;
        }
        return first.next == null && second.next == null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedListCompareTwoLinkedLists llist1 = new SinglyLinkedListCompareTwoLinkedLists();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            SinglyLinkedListCompareTwoLinkedLists llist2 = new SinglyLinkedListCompareTwoLinkedLists();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            boolean result = compareLists(llist1.head, llist2.head);

            bufferedWriter.write(String.valueOf(result ? 1 : 0));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

