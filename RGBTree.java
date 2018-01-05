package RGBTree;

import AVL.*;

import RGBData.RGBData;

public class RGBTree extends AVL{
	public void between(final RGBData min,final  RGBData max){
		Condition condition= new Condition(){
			public boolean check(Comparable cur){
				return (cur.compareTo(min)>=0 && cur.compareTo(max)<=0); 
			}
		};
		depth_first_search(condition,root);
	}
}
