
public class Factory 
{
	public iPila getImplementStack(int op)
	{
		if(op == 1) 
	       {
	        return new ArrayStack();
	       }
       else if(op == 2) 
	       {
	        return new vectorStack();
	       }
       else
	       {
	        return new myList();
	       }
	}
}
