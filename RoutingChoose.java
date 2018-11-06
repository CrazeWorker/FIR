package ·��ѡ��;

import java.util.ArrayList;

import org.junit.Test;

public class RoutingChoose {
	public String choiceNext(String ipHead) {
		// ����·�ɱ�
		ArrayList<RoutingInformation> list = createRoutingTable();
		// ��ipHead��·�ɱ��д��ڵ�Ŀ���ַ��Ƚϣ�����û�У�������ڣ������һ��
		for (int i = 0; i < list.size()-1; i++) {
			if(ipHead.equals(list.get(i).getDirection())) {
				return list.get(i).getNext();
			}
		}
		// ���·�ɱ���û��Ŀ���ַ����ipHead�������������룬�õ���ip����·�ɱ��е�ip�Ƚ�
		for (int i = 0; i < list.size()-1; i++) {
			String newIp = andIp(ipHead,list.get(i).getSubnetMask());
			String newTenIp = tenShow(newIp);
				if(newTenIp.equals(list.get(i).getDirection())) {
					return list.get(i).getNext();
				}
		}
		// ��������������������Ȼû���ҵ�ƥ��Ŀ�������ַ����ת��Ĭ�������ַ�Ľӿ�
		return list.get(list.size()-1).getNext();
	}
	@Test
	public void test() {
		System.out.println(choiceNext("128.96.39.10"));
		System.out.println(choiceNext("128.96.40.12"));
		System.out.println(choiceNext("128.96.40.151"));
		System.out.println(choiceNext("192.4.153.17"));
		System.out.println(choiceNext("192.4.153.90"));
	}
	
	// ����һ��·����������һ��·�ɱ�
	public ArrayList<RoutingInformation> createRoutingTable() {
		ArrayList<RoutingInformation> list = new ArrayList<>();
		list.add(new RoutingInformation("128.96.39.0","255.255.255.128","�ӿ�m0"));
		list.add(new RoutingInformation("128.96.39.128","255.255.255.128","�ӿ�m1"));
		list.add(new RoutingInformation("128.96.40.0","255.255.255.128","R2"));
		list.add(new RoutingInformation("192.4.153.0","255.255.255.192","R3"));
		list.add(new RoutingInformation("R4"));
		return list;
	}
	
	// ip��ַת��Ϊ������
	public String toTwo(String s) {
		String[] arr = s.split("\\.");
		String res="";
		String all="";
		for (int i = 0; i < arr.length; i++) {
			int n = Integer.parseInt(arr[i]);
			res = "";
			while(n>0){
				res=String.valueOf(n%2)+res;
				n=n/2;
			}
			while(res.length()!=8) {
				res = "0"+res;
			}
			all = all + res;
		}		
		return all;
	}
	@Test
	public void testToTwo() {
		System.out.println(toTwo("128.96.39.10"));
	}
	
	// ip��ַÿλ����ó���ip
	public String andIp(String s1,String s2) {
		String ip1 = toTwo(s1);
		String ip2 = toTwo(s2);
		String dirIp = "";
		for (int i = 0; i < 32; i++) {
			dirIp += and(ip1.charAt(i),ip2.charAt(i));
		}
		return dirIp;
	}
	@Test
	public void testAndIp() {
		System.out.println(tenShow(andIp("128.96.39.10", "255.255.255.128")));
	}
	
	
	// �뺯��
	public char and(char n1,char n2) {
		if((n1=='1'&&n2=='1')||(n2=='1'&&n1=='1')) {
			return '1';
		}else{
			return '0';
		}
	}
	
	// ���ʮ���Ʊ�ʾip�����ó��Ķ������ַ���
	public String tenShow(String s) {
		String mid = "";
		String res = "";
		int count = 1;
		for (int i = 0; i < 32; i++) {
			mid += s.charAt(i);
			if(count % 8==0) {
				res += Integer.parseInt(mid, 2)+".";
				mid = "";
			}
			count++;
		}
		return res.substring(0,res.length()-1);
	}
	@Test
	public void testTenShow() {
		System.out.println(tenShow("11111111111111111111111110000000"));
	}
}
