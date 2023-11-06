package com.hackerrank.datastructures.linkedlists;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class SinglyLinkedListNodeSolutionJavaDeleteANode {
    public int data;
    public SinglyLinkedListNodeSolutionJavaDeleteANode next;

    public SinglyLinkedListNodeSolutionJavaDeleteANode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedListSolutionJavaDeleteANode {
    public SinglyLinkedListNodeSolutionJavaDeleteANode head;
    public SinglyLinkedListNodeSolutionJavaDeleteANode tail;
    public int numberOfElement;

    public SinglyLinkedListSolutionJavaDeleteANode() {
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

        numberOfElement++;

    }
}


class SinglyLinkedListPrintHelperSolutionJavaDeleteANode {
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

class ResultSolutionJavaDeleteANode {

    public static SinglyLinkedListNodeSolutionJavaDeleteANode deleteNode(SinglyLinkedListNodeSolutionJavaDeleteANode llist, int position) {
        SinglyLinkedListNodeSolutionJavaDeleteANode temp = llist;

        if(llist == null||llist.next == null){
           return llist;
        } else if (position == 0){
            llist = llist.next;
            return llist;
        }

        for(int i = 0; i < position - 1; i++){
            temp = temp.next;
        }

        temp.next=(temp.next).next;
        return llist;
    }
}

public class SolutionJavaDeleteANode {
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

        int position = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNodeSolutionJavaDeleteANode llist1 = ResultSolutionJavaDeleteANode.deleteNode(llist.head, position);

        SinglyLinkedListPrintHelperSolutionJavaDeleteANode.printList(llist1, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
