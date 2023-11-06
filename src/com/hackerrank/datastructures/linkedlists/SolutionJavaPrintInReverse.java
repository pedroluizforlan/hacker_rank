package com.hackerrank.datastructures.linkedlists;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class SinglyLinkedListNodeSolutionJavaPrintInReverse {
    public int data;
    public SinglyLinkedListNodeSolutionJavaPrintInReverse next;

    public SinglyLinkedListNodeSolutionJavaPrintInReverse(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedListSolutionJavaPrintInReverse {
    public SinglyLinkedListNodeSolutionJavaPrintInReverse head;
    public SinglyLinkedListNodeSolutionJavaPrintInReverse tail;

    public SinglyLinkedListSolutionJavaPrintInReverse() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNodeSolutionJavaPrintInReverse node = new SinglyLinkedListNodeSolutionJavaPrintInReverse(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNodeSolutionJavaPrintInReverse node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }
}

class ResultJavaPrintInReverse {

    public static void reversePrint(SinglyLinkedListNodeSolutionJavaPrintInReverse llist) {
        SinglyLinkedListNodeSolutionJavaPrintInReverse temp1 = llist;
        SinglyLinkedListNodeSolutionJavaPrintInReverse temp2 = temp1.next;
        SinglyLinkedListNodeSolutionJavaPrintInReverse temp3 = temp2.next;

        while(temp2.next != null){
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp3.next;
        }

        temp2.next = temp1;
        llist.next = null;
        while(temp2 != null){

            System.out.println(temp2.data);
            temp2 = temp2.next;
        }
    }

}

public class SolutionJavaPrintInReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, tests).forEach(testsItr -> {
            try {
                SinglyLinkedListSolutionJavaPrintInReverse llist = new SinglyLinkedListSolutionJavaPrintInReverse();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                ResultJavaPrintInReverse.reversePrint(llist.head);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
