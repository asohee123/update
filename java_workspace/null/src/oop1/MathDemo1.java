package oop1;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.rint;
import static java.lang.Math.round;

public class MathDemo1 {

	public static void main(String[] args) {
		
		//						-1				-2					-2
		System.out.println(round(-1.2)+", " + round(-1.8) + ", " + round(-1.9));
		//						-1.0			-2.0				-2.0
		System.out.println(rint(-1.2)+", " + rint(-1.8) + ", " + rint(-1.9));
		//						-2.0			-2.0				-2.0
		System.out.println(floor(-1.2)+", " + floor(-1.8) + ", " + floor(-1.9));
		//						-1.0			-1.0				-1.0
		System.out.println(ceil(-1.2)+", " + ceil(-1.8) + ", " + ceil(-1.9));
		
	}
}
