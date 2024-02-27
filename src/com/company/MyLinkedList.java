package com.company;

import java.util.Objects;

class MyLinkedList {
    private Node first;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int idx = 0;
        Node curNode = this.first;
        while (curNode != null) {
            if (idx == index) {
                return curNode.val;
            }
            curNode = curNode.next;
            idx++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion,
     * the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (first!=null) {
            first.prev = node;
            node.next = this.first;
        }
        this.first = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node curNode = this.first;

        if (curNode != null) {
            while (curNode != null) {
                if (curNode.next == null) {

                    node.prev = curNode;
                    curNode.next = node;
                    return;
                }
                curNode = curNode.next;
            }
        } else {
            addAtHead(val);
        }
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else {
            int idx = 0;
            Node curNode = this.first;

            while (curNode != null) {
                if (idx == index) {
                    Node obj = new Node(val);
                    Node curPrev = curNode.prev;
                    obj.next = curNode;
                    obj.prev = curPrev;
                    curNode.prev = obj;
                    curPrev.next = obj;
                    return;
                }
                curNode = curNode.next;
                idx++;
            }
            // if index equals end
            if (idx == index) {
                addAtTail(val);
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int idx = 0;
        Node curNode = this.first;

        while (curNode != null) {
            if (idx == index) {
                Node curNext = curNode.next;
                Node curPrev = curNode.prev;
                if (curNext != null) {
                    if (curPrev != null) {
                        curPrev.next = curNext;
                    }
                    curNext.prev = curPrev;
                } else {
                    if (curPrev!= null) {
                        curPrev.next = null;
                    }
                }

                if (index == 0) {
                    this.first = curNext;
                }

                return;
            }
            curNode = curNode.next;
            idx++;
        }
    }

    private class Node {
        private int val;

        private Node prev;

        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val &&
                    Objects.equals(prev, node.prev) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, prev, next);
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */