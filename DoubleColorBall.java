package www.oricle_Day07_ChouJiang;
import java.util.Random;
import java.util.ArrayList;
public class DoubleColorBall {
/*
需求分析：1、创建Integer集合，用来存双色球数字
  		2、产生七个随机数，判断不能重复
  		3、不放回
 */
	public static void main(String[] args) {
		// 创建DoubleColorBall集合存放双色球数字
        ArrayList<DoubleBall> array = new ArrayList<DoubleBall>();
        addRandomNum(array);
        getRandom(array);
	}
	//向集合里面添加随机数
    public static void addRandomNum(ArrayList<DoubleBall> array){
    	DoubleBall d1 = new DoubleBall();
    	DoubleBall d2 = new DoubleBall();
    	DoubleBall d3 = new DoubleBall();
    	DoubleBall d4 = new DoubleBall();
    	DoubleBall d5 = new DoubleBall();
    	DoubleBall d6 = new DoubleBall();
    	DoubleBall d7 = new DoubleBall();
    	DoubleBall d8 = new DoubleBall();
    	DoubleBall d9 = new DoubleBall();
    	DoubleBall d10 = new DoubleBall();
    	DoubleBall d11= new DoubleBall();
    	DoubleBall d12 = new DoubleBall();
    	DoubleBall d13 = new DoubleBall();
    	DoubleBall d14 = new DoubleBall();
    	DoubleBall d15 = new DoubleBall();
    	DoubleBall d16 = new DoubleBall();
    	DoubleBall d17 = new DoubleBall();
    	DoubleBall d18 = new DoubleBall();
    	DoubleBall d19 = new DoubleBall();
    	DoubleBall d20 = new DoubleBall();
    	DoubleBall d21 = new DoubleBall();
    	DoubleBall d22 = new DoubleBall();
    	DoubleBall d23 = new DoubleBall();
    	DoubleBall d24 = new DoubleBall();
    	DoubleBall d25 = new DoubleBall();
    	DoubleBall d26 = new DoubleBall();
    	DoubleBall d27 = new DoubleBall();
    	DoubleBall d28 = new DoubleBall();
    	DoubleBall d29 = new DoubleBall();
    	DoubleBall d30 = new DoubleBall();
    	DoubleBall d31 = new DoubleBall();
    	DoubleBall d32 = new DoubleBall();
    	DoubleBall d33 = new DoubleBall();
    	d1.number = 1;
    	d2.number = 2;
    	d3.number = 3;
    	d4.number = 4;
    	d5.number = 5;
    	d6.number = 6;
    	d7.number = 7;
    	d8.number = 8;
    	d9.number = 9;
    	d10.number = 10;
    	d11.number = 11;
    	d12.number = 12;
    	d13.number = 13;
    	d14.number = 14;
    	d15.number = 15;
    	d16.number = 16;
    	d17.number = 17;
    	d18.number = 18;
    	d19.number = 19;
    	d20.number = 20;
    	d21.number = 21;
    	d22.number = 22;
    	d23.number = 23;
    	d24.number = 24;
    	d25.number = 25;
    	d26.number = 26;
    	d27.number = 27;
    	d28.number = 28;
    	d29.number = 29;
    	d30.number = 30;
    	d31.number = 31;
    	d32.number = 32;
    	d33.number = 33;
    }
    //随机数作为索引取出七个数
    public static void getRandom(ArrayList<DoubleBall> array){
    	int i = 34;
    	for(int m = 0;m<7;m++){
    		 Random r = new Random();
             int index = r.nextInt(i);
             System.out.println(array.get(index));
             array.remove(index);
             //集合内所有的数向前挪移
             for(int a=index;a<33;a++){
            	 array.get(index).number= array.get(index+1).number;
             }
        	 i--;
             }
    	}
    }

