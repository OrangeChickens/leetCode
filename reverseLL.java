// iterative solution
  /*
  public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre = null,cur = null;
        while(head!=null){
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }
  */ 
    // recursive.
    public class Solution {
    public ListNode reverseList(ListNode head) {
       
        // first break every node, then link them back wards. last is the last node. 
        if(head == null || head.next ==null) {
            return head;
        } 
            ListNode temp = head.next;
            head.next = null;
            ListNode last = reverseList(temp);
            temp.next = head; // at last, temp = last, then we link temp with previous node one by one.
            return last;

     }
}