import java.util.Scanner;
import java.util.Stack;


    public class SortStack {

        static Scanner s = new Scanner(System.in);

    public static Stack<Integer> takeStackInput(){

            int size=s.nextInt();
            Stack<Integer> stack = new Stack<Integer>();
            for(int i = 0; i < size; i++){
                stack.push(s.nextInt());
            }
            return stack;
        }

    public static void printStack(Stack<Integer> stack){

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }
    
    public static void sortStack(Stack<Integer> s){
		if(s.isEmpty())
            return;
        
        int x=s.pop();
        sortStack(s);
        add(s,x);
	}

    public static void add(Stack<Integer> s,int x)
    {
        if(s.isEmpty() || s.peek()>x)
        {
            s.push(x);
            return;
        }
        
        int temp=s.pop();
        add(s,x);
        s.push(temp);
        
    }

	
	public static void main(String[] args) {
		
		Stack<Integer> stack = takeStackInput();
		sortStack(stack);
		printStack(stack);
		
	}

}
