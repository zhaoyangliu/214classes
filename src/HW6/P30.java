package HW6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P30 {
	private static int count;
	
	// Pre:  group and members are positive
	// Post: Return value = number of combinations of members size
	//	     that can be constructed from the total group size	
	private static long combinations(int group, int members) {
	count++;
	if (members == 1)
	    return group;             // Base case 1
	else if (members == group)
	    return 1;                 // Base case 2
	else
	    return (combinations(group - 1, members - 1) +
	            combinations(group - 1, members));
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("*********************************************");
		System.out.println("* Type two integer N and M to calculate the *");
		System.out.println("* number of cominations of M items that can *");
		System.out.println("* be made out of N items.                   *");
		System.out.println("* Type -1 to end                            *");
		System.out.println("*********************************************");
		
		int m = 0;
		int n = 0;
		
		while (m != -1) {
			
			try {
				System.out.print("M: ");
				m = Integer.valueOf(br.readLine());
				if (m == -1)
					continue;
				if (m <= 0)
					throw new Exception();
				System.out.print("N: ");
				n = Integer.valueOf(br.readLine());
				if (n <= 0) 
					throw new Exception();
				if (m > n) {
					System.out.println("Error: M shoudl not biger than N");
					throw new Exception();
				}
			}
			catch (Exception e) {
				System.out.println("Error: Please input POSITIVE INTEGER");
				continue;
			}
			if (m != -1) {
				count = 0;
				System.out.println("Comb(" + n + ", " + m + ") = " + combinations(n, m));
				System.out.println("Count times: " + count + " times");
			}
		}		
	}
}




