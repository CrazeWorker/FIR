package www.Oricle_Test1;

public class ChooseSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 0;
        int [] array =new int [10];
        //���������ȡ����� 
        for(int i = 0;i<array.length;i++){
        	array[i] = (int) (Math.random()*100+1);
        }
        //�������ǰ������
        System.out.println("����ǰ������Ϊ��");
        for (int k = 0; k < array.length; k++) {
			System.out.print(array[k]+" ");
		}
        //ѡ������
        for (int l = 0; l < array.length - 1; l++){
        for (m = l+1; m < array.length ; m++) {	
			int temp = 0;
			if(array[l] > array[m]){
				temp = array[l];
				array[l] = array[m];
				array[m] = temp;
			}
		}
        }
        System.out.println();
        //�������������
        System.out.println("����������Ϊ��");
        for (int b = 0; b < array.length; b++) {
			System.out.print(array[b]+" ");
		}
	}

}
