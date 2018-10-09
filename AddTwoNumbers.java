package Question;


/*
 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/



public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(0);
        ListNode h = head;
        int addNum = 0;
		while (p != null && q != null) {
			if(p.val + q.val>=10) {
				int number = p.val + q.val + addNum;
				addNum = (p.val + q.val)/10;
				h.next = new ListNode(number - addNum*10);
			}else {
				if(p.val + q.val + addNum>=10) {
					int number = p.val + q.val + addNum;
					addNum = (p.val + q.val + addNum)/10;
					h.next = new ListNode(number - addNum*10);
				}else {
					h.next = new ListNode(p.val + q.val + addNum);
					addNum = 0;
				}
				
			}	
        	p = p.next;
        	q = q.next;
        	h = h.next;
        	if(p == null&&q != null) {
        		while(q != null) {
        			if(addNum != 0) {
        				if(q.val + addNum >= 10) {
        					int number = q.val + addNum;
        					addNum = number/10;
        					h.next = new ListNode(number - addNum*10);
        				}else {
        					h.next = new ListNode(q.val + addNum);
        					addNum = 0;
        				}
        			}else {
        				h.next = q;
        			}
        			q = q.next;
        			h = h.next;
        		}
        	}else if(q == null&& p != null) {
        		while(p != null) {
        			if(addNum != 0) {
        				if(p.val + addNum >= 10) {
        					int number = p.val + addNum;
        					addNum = number/10;
        					h.next = new ListNode(number - addNum*10);
        				}else {
        					h.next = new ListNode(p.val + addNum);
        					addNum = 0;
        				}
        			}else {
        				h.next = p;
        			}
        			p = p.next;
        			h = h.next;
        		}
        	}else{
        		if(addNum != 0) {
        			h.next = new ListNode(addNum);
        		}
        	}	
        }
		if(addNum != 0) {
			h.next = new ListNode(addNum);
			addNum = 0;
		}
		return head.next;
    }
	
}
