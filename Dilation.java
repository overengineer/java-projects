package Dilation;

public class Dilation {
	public static boolean[] dilate( boolean[] bin, int w ){
		return dilate_ver(dilate_hor(bin,w),w);
	}
	
	public static boolean[] dilate_hor( boolean[] bin, int w ){
		boolean prev=bin[0];
		int h= bin.length/w;
		for( int y=0; y<h;y++ ){
			for( int x=1; x<w;x++ ){
				if( prev == true && bin[x+y*w]== false ){
					bin[x+y*w-1]=false;
					prev=false;
				}else if( prev == false && bin[x+y*w]== true ){
					bin[x+y*w]=false;
					prev=true;
				}
			}
		}
		return bin;
	}
	public static boolean[] dilate_ver( boolean[] bin, int w ){
		boolean prev=bin[0];
		int h= bin.length/w;
		for( int x=0; x<w;x++ ){
			for( int y=1; y<h;y++ ){
				if( prev == true && bin[x+y*w]== false ){
					bin[x+(y-1)*w]=false;
					prev=false;
				}else if( prev == false && bin[x+y*w]== true ){
					bin[x+y*w]=false;
					prev=true;
				}
			}
		}
		return bin;
	}
}
