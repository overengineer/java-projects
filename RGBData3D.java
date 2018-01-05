package RGBData3D;

import RGBData.*;

public class RGBData3D extends RGBData{
	private int x,y,z;
	public RGBData3D(int red, int green, int blue,int x,int y, int z) {
		super(red, green, blue);
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public RGBData3D(RGBData rgb,int x,int y, int z) {
		this(rgb.red, rgb.green, rgb.blue,x,y,z);
	}
	public int compareTo( Object obj ){
		if(obj==null){
			return 1;
		}else if(obj.getClass().equals(this.getClass())){
			RGBData3D rgb = (RGBData3D) obj;
			int value=manhattan_distance(rgb);
			if(value!=0){
				return value;
			}else{
				//manhattan mesafesi sıfırsa izdüşüm mesafelerine bakılır
				return max(red-rgb.red,green-rgb.green,blue-rgb.blue,
											 x-rgb.x,y-rgb.y,z-rgb.z);
			}
		}else{
			System.err.println("invalid parameter");
			return 1;
		}
	}
	public Integer manhattan_distance(RGBData3D other){
		return new Integer((red+green+blue+x+y+z)-
				(other.red+other.green+other.blue+other.x+other.y+other.z));
	}

}
