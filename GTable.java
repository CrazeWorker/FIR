package Day_5;

import org.junit.Test;

public class GTable {
	
	
	// 构造广义表[1,[2,3,4]] 
	public static void main(String[] args) {
		P p1 = new P();
		p1.data = 1;
		
		P p2 = new P();
		p2.data = 2;
		p2.tag = 1;
		
		p1.next = p2;
		
		P p3 = new P();
		p3.data = 3;
		
		p2.slink = p3;
		
		P p4 = new P();
		p4.data = 4;
		
		p3.next = p4;
		
		System.out.println(search(p1,5));
	}
	
	public static boolean search(P p , int x) {
		while(p != null) {
			if((p.tag == 0 && p.data == x)||(p.tag == 1 && search(p.slink,x))||(p.tag == 1 && p.data == x)) {
				return true;
			}
			p = p.next;
		}
		return false;
	}
	
//	public void tes
}
