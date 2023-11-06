package com.hackerrank.datastructures.linkedlists;
import java.io.*;
import java.util.stream.*;


class SinglyLinkedListNodeJavaReverseALinkedList {
    public int data;
    public SinglyLinkedListNodeJavaReverseALinkedList next;

    public SinglyLinkedListNodeJavaReverseALinkedList(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedListJavaReverseALinkedList {
    public SinglyLinkedListNodeJavaReverseALinkedList head;
    public SinglyLinkedListNodeJavaReverseALinkedList tail;

    public SinglyLinkedListJavaReverseALinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNodeJavaReverseALinkedList node = new SinglyLinkedListNodeJavaReverseALinkedList(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelperJavaReverseALinkedList {
    public static void printList(SinglyLinkedListNodeJavaReverseALinkedList node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class ResultReverseALinkedList {
    public static SinglyLinkedListNodeJavaReverseALinkedList reverse(SinglyLinkedListNodeJavaReverseALinkedList llist) {
        SinglyLinkedListNodeJavaReverseALinkedList temp1 = llist;
        SinglyLinkedListNodeJavaReverseALinkedList temp2 = temp1.next;
        SinglyLinkedListNodeJavaReverseALinkedList temp3 = temp2.next;

        while(temp2.next != null){
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp3.next;
        }


        temp2.next = temp1;
        llist.next = null;

        return temp2;
    }
}

public class SolutionJavaReverseALinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int tests = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, tests).forEach(testsItr -> {
            try {
                SinglyLinkedListJavaReverseALinkedList llist = new SinglyLinkedListJavaReverseALinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                SinglyLinkedListNodeJavaReverseALinkedList llist1 = ResultReverseALinkedList.reverse(llist.head);

                SinglyLinkedListPrintHelperJavaReverseALinkedList.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
