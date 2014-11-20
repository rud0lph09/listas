class StackString{
	//Attributes
	private int top;
	private String []stack;
	
	//Constructors
	public StackString(int size){
		stack = new String [size];
		top = -1;
	}
	
	/*public void StackString(String []p,int index){
		stack=p;
		top=index;
	}*/
	
	//Methods
	public void push(String data){
		//Puts on the stack the data
		top++;
		stack[top]=data;
	}
	
	public String pop(){
		//Popped from the stack the data on top
		top--;
		return stack[top+1];
	}
	
	public boolean fullStack(){
		//Checks if the stack is Full
		return (top==stack.length-1);
	}
	
	public boolean emptyStack(){
		//Checks if the stack is empty
		return (top==-1);
	}
	
	public String dataOnTop(){
		//Returns the data on top
		return stack[top];
	}
	
	public boolean space(){
		//Checks if exist space in the stack
		return (top<stack.length-1);
	}
	
	public void lstStack(){
		//List all data in the stack
		for(int i=0;i<=top;i++){
			System.out.print(stack[i]);
		}
	}
	public String getStack(){
		//List all data in the stack
		String a="";
		for(int i=0;i<=top;i++){
			a=a+stack[i]+" ";
		}
		return a;
	}
}

