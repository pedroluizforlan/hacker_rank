package com.hackerrank.datastructures.linkedlists;

import java.io.*;
import java.util.stream.*;

class SinglyLinkedListNodeInsertANodeAtASpecificPositionInALinkedList {
    public int data;
    public SinglyLinkedListNodeSolutionJavaDeleteANode next;

    public SinglyLinkedListNodeInsertANodeAtASpecificPositionInALinkedList(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedListInsertANodeAtASpecificPositionInALinkedList {
    public SinglyLinkedListNodeSolutionJavaDeleteANode head;
    public SinglyLinkedListNodeSolutionJavaDeleteANode tail;

    public SinglyLinkedListInsertANodeAtASpecificPositionInALinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNodeSolutionJavaDeleteANode node = new SinglyLinkedListNodeSolutionJavaDeleteANode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelperInsertANodeAtASpecificPositionInALinkedList {
    public static void printList(SinglyLinkedListNodeSolutionJavaDeleteANode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}
class ResultInsertANodeAtASpecificPositionInALinkedList {
    public static SinglyLinkedListNodeSolutionJavaDeleteANode insertNodeAtPosition(SinglyLinkedListNodeSolutionJavaDeleteANode llist, int data, int position) {
        if (position > 1) insertNodeAtPosition(llist.next, data, position-1);

        if (position == 1) {
            SinglyLinkedListNodeSolutionJavaDeleteANode node = new SinglyLinkedListNodeSolutionJavaDeleteANode(data);
            SinglyLinkedListNodeSolutionJavaDeleteANode tmp = llist.next;
            llist.next = node;
            node.next = tmp;
        }
        return llist;

    }
}

public class SolutionJavaInsertANodeAtASpecificPositionInALinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        SinglyLinkedListSolutionJavaDeleteANode llist = new SinglyLinkedListSolutionJavaDeleteANode();

        int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, llistCount).forEach(i -> {
            try {
                int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                llist.insertNode(llistItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int data = Integer.parseInt(bufferedReader.readLine().trim());

        int position = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNodeSolutionJavaDeleteANode llist_head = ResultInsertANodeAtASpecificPositionInALinkedList.insertNodeAtPosition(llist.head, data, position);

        SinglyLinkedListPrintHelperSolutionJavaDeleteANode.printList(llist_head, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
