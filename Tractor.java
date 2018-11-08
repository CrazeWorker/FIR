package www.Oricle_Test;

public class Tractor extends Car{
     public Tractor(String type,String color,double PaiLiang,int tyrenumber){
    	 this.color = color;
    	 this.PaiLiang =PaiLiang;
    	 this.type = type;
    	 this.tyrenumber = tyrenumber;
     }

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
     
}
