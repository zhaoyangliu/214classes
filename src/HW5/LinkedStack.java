package HW5;

public class LinkedStack<T> implements StackInterface {

	protected LLNode<T> top;
	
	public LinkedStack() {
		top = null;
	}
	
	public LinkedStack(T[] elements) {
		for (int i = 0; i < elements.length; i++) {
			push(elements[i]);
		}
	}
	
	
	public void push(T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
	}
	
	public boolean isEmpty() {
		return top == null ? true : false;
	}
	
	public void pop() throws StackUnderflowException {
		if (!isEmpty()) {
			top = top.getLink();
		}
		else
			throw new StackUnderflowException("PopTop attempted on an empty stack.");
	}
	
	public T popTop() throws StackUnderflowException {
		if(!isEmpty())
		{
		   LLNode<T> curTop = top;
		   pop();
		   return curTop.getInfo();
		}
		else
		{
		     throw new StackUnderflowException("PopTop attempted on an empty stack.");
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr = {1,4,5};
		LinkedStack<Integer> ls = new LinkedStack<Integer>(arr);

		System.out.print(ls.popTop());
		System.out.print(ls.popTop());
		System.out.print(ls.popTop());

	}
	
}
