public class ArrayMax{
	public static void main(String[] args){
		//������������ҽ��и�ֵ
		int [] arr = {2,1,2,5,6,7,8};
		//�������max���ڼ�ס���ֵ�����Ҽ���arr[0]Ϊ���ֵ
		int max = arr[0];
		//forѭ����������
		for(int i = 1;i<arr.length;i++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		System.out.println("���ֵΪ��"+max);//��ӡ���ֵ
	}
}