package HW6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P28 {
	private static long factorial(int n) {
	    long retValue = 1;   // return value
	    if ( n == 0) 
	    	return 1;
	    Stack<Integer> stack = new Stack<Integer>(); 
	   
	    
	    for (int i = n; i >= 1; i--) {
	    	stack.push(i);
	    }
	    
	    while(!stack.isEmpty()) {
	    	retValue *= stack.pop();
	    }
	    return retValue;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Type an integer to calculate factorial\nNumber: ");
		int number = 1;
				
		while (number != -1) {
			try {
				number = Integer.valueOf(br.readLine());
				if (number < -1)
					throw new Exception();
				if (number > 20) {
					System.out.println("Error: That might be too large, type a new one.");
					throw new Exception();
				}
			} 
			catch(Exception e) {
				System.out.print("Error: Please type an POSITIVE INTEGER\nNumber: ");
				continue;
			}
			if (number != -1)
				System.out.print("Result: " + factorial(number) + "\nNumber: ");
		}
		
	}
}



