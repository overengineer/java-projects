package Erosion;

public class Erosion {
	static boolean[] erode( boolean[] bin, int w ){
		return erode_ver(erode_hor(bin,w),w);
	}
	
	static boolean[] erode_hor( boolean[] bin, int w ){
		boolean prev=bin[0];
		int h= bin.length/w;
		//just horizontal for now
		for( int y=0; y<h;y++ ){
			for( int x=1; x<w;x++ ){
				if( prev == true && bin[x+y*w]== false ){
					bin[x+y*w]=true;
					prev=false;
				}else if( prev == false && bin[x+y*w]== true ){
					bin[x+y*w-1]=true;
					prev=true;
				}
			}
		}
		return bin;
	}
	static boolean[] erode_ver( boolean[] bin, int w ){
		boolean prev=bin[0];
		int h= bin.length/w;
		//just horizontal for now
		for( int x=0; x<w;x++ ){
			for( int y=1; y<h;y++ ){
				if( prev == true && bin[x+y*w]== false ){
					bin[x+y*w]=true;
					prev=false;
				}else if( prev == false && bin[x+y*w]== true ){
					bin[x+(y-1)*w]=true;
					prev=true;
				}
			}
		}
		return bin;
	}
}
