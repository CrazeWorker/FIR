/*
����0.01��ȵ�ֽ���Ŷ��ٴ��ܴﵽ���������ĸ߶�
���������
    1������һ��ͳ�Ʊ���
	2������һ����ԭ����ȵ���������ʼ���Ϊ0.01
	3��ÿ��һ�Σ�ͳ�Ʊ���++
	4�����ͳ�Ʊ���

*/
public class WhileTest{
	public static void main(String [] args){
		//����һ��ͳ�Ʊ���
		int number = 0;
		int start = 1;
		int end = 884800;
		//��ʼ�߶�Ϊ1�����ո߶�Ϊ8848����ѭ�����ƣ�������ÿ�μ�һ����ʼ�߶�ÿ�γ�2
		while(start<end){
			number++;
			start *=2;
			System.out.println("���ڵ�ͳ�ƴ���Ϊ��"+number+"���ڵĸ߶�Ϊ��"+start);
			
		}
		//���ͳ�Ʊ���
		System.out.println("��Ҫ�۵�����Ϊ��"+number);
	}
}