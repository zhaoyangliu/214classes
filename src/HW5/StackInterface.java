package HW5;

public interface StackInterface {

	
	/**
	 * Effect: Removes top item from this stack and returns it
	 * Postconditions: If (this stack is empty) an exception that communicates 'pop on stack empty' is thrown 
	 * else top element has been removed from this stack. return value = (the removed element)
	 * @return top element
	 * @throws StackUnderflowException
	 */
	public Object popTop() throws StackUnderflowException;

	
	
}
