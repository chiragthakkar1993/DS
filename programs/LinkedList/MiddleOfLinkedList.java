package LinkedList;

/*
    Given the head of a singly linked list, return the middle node of the linked list.

    If there are two middle nodes, return the second middle node.



    Example 1:


    Input: head = [1,2,3,4,5]
    Output: [3,4,5]
    Explanation: The middle node of the list is node 3.
    Example 2:


    Input: head = [1,2,3,4,5,6]
    Output: [4,5,6]
    Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.



 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MiddleOfLinkedList {


    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;

        int size = findSize(head);
        int mid = (size / 2) ;
        System.out.println();
        int count = 0;
        while (head != null) {
            if (count == mid)
                break;

            count++;
            head = head.next;
        }
        return head;
    }

    public int findSize(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }


}
