package www.Oricle_Day08_Test;

public class ArrayTest {

	public static void main(String[] args) {
		//����һ�����鲢��ʼ��
		int [] array = {26,26,67,89,44};
		//���ñ�������
		//printArray(array);
		//�������򷽷�
		//reverse(array);
		//System.out.println();
		//�ٴε��ñ�������
		//printArray(array);
		//System.out.println();
		//����ѡ������
		//selectSort(array);
		//���ñ�������
		//printArray(array);
		//����ð������
		bubbleSort(array);
		//���ñ�������
		printArray(array);

	}
/*
	 *ѡ������ķ���
	 *�����б�����
	 *����ֵ���ͣ�void 
	 */
	private static void selectSort(int[] array) {
			// TODO Auto-generated method stub
		int m = 0;
		for (int l = 0; l < array.length - 1; l++){
			//���ѭ���������������һ����Ҫarray-1��ѭ��
	        for (m = l+1; m < array.length ; m++) {	
	        	//�ڲ�ѭ����������Ƚ�Ԫ�صĸ�����ÿ�δӵ�Ȧ����Ԫ�ؿ�ʼ����Ƚ�
				int temp = 0;
				//����һ������������
				if(array[l] > array[m]){
					//�Ƚ������Ԫ�أ�����Ⱥ����Ԫ�ر�ǰ���Ԫ��С�ͻ���
					temp = array[l];
					array[l] = array[m];
					array[m] = temp;
				}
			}
	        }
			
		}
/*
 *ð������ķ��� 
 * �����б�����
 * ����ֵ���ͣ�void
 * */	
private static void bubbleSort(int[] array) {
		// TODO Auto-generated method stub
	 	for (int i = 0; i < array.length - 1; i++) {
	 		//���ѭ�����ƱȽϵĴ���
			for (int j = 0; j < array.length - 1 - i; j++) {
				//�ڲ�ѭ������ÿ�αȽϵ�Ԫ�ظ���
				if(array[j] > array[j+1]){
					//if���������Ԫ�ؽ��бȽ�
				int temp = 0;
				//�������������������Ԫ�ص�ֵ
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				}
			}
		}
		
	}
/*
 * ��������ķ�����
 * �������ͣ�����
 * ����ֵ���ͣ�void	
 */
	private static void reverse(int[] array) {
		// TODO Auto-generated method stub
	    for (int min = 0,max = array.length - 1; min < max; min++,max--) {
			int temp = array[min];
			array[min] = array[max];
			array[max] = temp;
		}		
		}

/* ��������ķ�����
 * �������ͣ�����
 * ����ֵ���ͣ�void
 */
	private static void printArray(int[] array) {
		// TODO Auto-generated method stub
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if(i == array.length - 1){
				System.out.print(array[i]+"]");
			}
			else{
			System.out.print(array[i]+",");
			}
		}
		
	}

}
