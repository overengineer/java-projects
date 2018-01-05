package RGBData;


public class RGBData implements Comparable {
	public int red;
	public int green;
	public int blue;
	public RGBData(int red,int green,int blue){
		this.red=red;
		this.green=green;
		this.blue=blue;
	}
	public int compareTo( Object obj ){
		if(obj==null){
			return 1;
		}else if(obj.getClass().equals(this.getClass())){
			RGBData rgb = (RGBData) obj;
			int value=comparision_value(this.manhattan_distance(rgb));
			if(value!=0){
				return value;
			}else{
				//manhattan mesafesi sıfırsa izdüşüm mesafelerine bakılır
				return comparision_value(max(red-rgb.red,green-rgb.green,blue-rgb.blue));
			}
		}else{
			System.err.println("invalid parameter");
			return 1;
		}
	}
	public int max( int... args){
		int foo = args[0];
		for(int i=1;i<args.length;i++){
			if(args[i]>foo){
				foo=args[i];
			}
		}
		return foo;
	}
	//eğer return değeri 1,-1,0 olması şart değilse kullanılmayabilir
	private int comparision_value(int raw){
		if(raw<0){
			return -1;
		}else if(raw>0){
			return 1;
		}else{
			return 0;
		}
	}
	//performans için tercih edilen yöntem
	public Integer manhattan_distance(RGBData other){
		return new Integer((red+green+blue)-(other.red+other.green+other.blue));
	}
	public String toString(){
		return String.format("[%d, %d, %d]",red,green,blue);
	}
}