package Question;


/*
 ���������ǿ���������ʾ�����Ǹ�������λ����������ʽ�洢�����ǵ�ÿ���ڵ�ֻ�洢�������֡���������ӷ���һ���µ�����

����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��

ʾ����

���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
�����7 -> 0 -> 8
ԭ��342 + 465 = 807
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
