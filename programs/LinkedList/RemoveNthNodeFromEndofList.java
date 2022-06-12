package LinkedList;

/*
            Given the head of a linked list, remove the nth node from the end of the list and return its head.

            Example 1:


            Input: head = [1,2,3,4,5], n = 2
            Output: [1,2,3,5]
            Example 2:

            Input: head = [1], n = 1
            Output: []
            Example 3:

            Input: head = [1,2], n = 1
            Output: [1]

            Time Complexity - O(L)
            Space Complecity - O(1)

 */
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 0; first.next != null; i++){
            if(i >= n){
                second = second.next;
            }
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


}
