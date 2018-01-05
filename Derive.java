package Derive;

public class Derive {


	
	public static boolean[] derive_hor( boolean[] bin, int w ){
		boolean[] der = new boolean[bin.length];
		int h= bin.length/w;
		for( int y=0; y<h;y++ ){
			for( int x=1; x<w;x++ ){
				if( (bin[x+y*w-1] == true && bin[x+y*w]== false) || ( bin[x+y*w-1] == false && bin[x+y*w]== true )){
					der[x+y*w]=true;
				}else{
					der[x+y*w]=false;
				}
			}
		}
		return der;
	}
	public static boolean[] derive_ver( boolean[] bin, int w ){
		boolean[] der = new boolean[bin.length];
		int h= bin.length/w;
		for( int x=0; x<w;x++ ){
			for( int y=1; y<h;y++ ){
				if( (bin[x+(y-1)*w] == true && bin[x+y*w]== false) || ( bin[x+(y-1)*w] == false && bin[x+y*w]== true )){
					der[x+y*w]=true;
				}else{
					der[x+y*w]=false;
				}
			}
		}
		return der;
	}
}
