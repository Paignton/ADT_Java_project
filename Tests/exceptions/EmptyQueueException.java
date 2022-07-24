package exceptions;

public class EmptyQueueException extends Exception{
	
	public EmptyQueueException() {
		String msg = "Empty Queue Exception";
		System.out.print(msg);
		return;
	};

}
