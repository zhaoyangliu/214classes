package HW5;

public class LLNode<T> {
	
	private LLNode<T> link;
	private T info;
	
	public LLNode(T info) {
		this.info = info;
		link = null;
	}
	
	public void setInfor(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setLink(LLNode<T> link) {
		this.link = link;
	}
	
	public LLNode<T> getLink() {
		return link;
	}
	

}
