package HW7;

import java.util.Arrays;
import java.util.Collections;

public class Rectangle implements Comparable<Rectangle> {
	protected int length;
	protected int width;
      
	public Rectangle(int length, int width){
		this.length = length;
		this.width = width;
	}    
    
	public boolean equals(Rectangle rec) {
		if (this.length == rec.length && this.width == rec.width)
			return true;
		else
			return false;
	}
  
	
	/**
	 * Solution for problem a
	 */
	public int compareTo(Rectangle rec) {
		if (this.perimeter() < rec.perimeter())
			return -1;
		else if (this.perimeter() == rec.perimeter())
			return 0;
		else
			return 1;
	}

	/**
	 * Solution for problem b
	 */
	
	public int compareTo(Rectangle rec) {
		if (this.area() < rec.area())
			return -1;
		else if (this.area() == rec.area())
			return 0;
		else
			return 1;
	}
	
	public int perimeter() {
		return (2 * (width + length) );
	}
   
	public int area() {
		return width * length;
	}
	
	public String toString() {
		return String.valueOf(length) + " " + String.valueOf(width);
	}
	
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(2,5);
		Rectangle r2 = new Rectangle(3,3);
		Rectangle r3 = new Rectangle(2,3);
		
		Rectangle[] r = {r1, r2, r3};
		
		Arrays.sort(r);
		
		for (Rectangle i : r) {
			System.out.println(i);
		}
		
	}
}

