package HW5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.Scanner;

public class PostFixExpressionEvaluator {
	public static int evaluate(String expression) throws FileNotFoundException {
		Stack<Integer> stack = new Stack<Integer>();
		
		int value;
		String operator;
		
		int operand1;
		int operand2;
		
		int result = 0;
		Scanner tokenizer = new Scanner(expression);
		
		while (tokenizer.hasNext()) {
			if (tokenizer.hasNextInt()) {
				value = tokenizer.nextInt();
				stack.push(value);
			}
			
			else {
				operator = tokenizer.next();
				if (stack.isEmpty()) {
					throw new PostFixException("Not enough operands - stack underflow");
				}
				operand2 = stack.pop();
				
				if (stack.isEmpty()) 
					throw new PostFixException("Not enough operands - stack underflow");
				operand1 = stack.pop();
				
				if (operator.equals("/"))
					result = operand1 / operand2;
				else if (operator.equals("*"))
					result = operand1 * operand2;
				else if (operator.equals("+"))
					result = operand1 + operand2;
				else if (operator.equals("-"))
					result = operand1 - operand2;
				else 
					throw new PostFixException("Illegal symbol: " + operator);
				
				stack.push(result);
			}
		}
		
		result = stack.pop();
		
		if (!stack.isEmpty()) {
			throw new PostFixException("Too many operands - operands left over");
		}
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String filename = "test.data";
		
		filename = "src/" + PostFixExpressionEvaluator.class.getPackage().getName() + "/" + filename;
		File fin = new File(filename);
		Scanner lineScan = new Scanner(fin);
		
		while (lineScan.hasNextLine()) {
			String line = lineScan.nextLine();
			
			try {
				System.out.println(evaluate(line));
			}
			catch (PostFixException e) {
				System.err.println("PostFixException: " + e.getMessage() + " on the line: " + line);
			}
		}
		
		lineScan.close(); 
	}
	
}
		
		
		
		
		
		
		
		
		
		
	
