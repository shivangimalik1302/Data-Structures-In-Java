import java.util.Scanner;
import java.util.Stack;


public class reverseStack{
    
    public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
		while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        r(s1,s2);
	}
    public static void r(Stack<Integer> s1, Stack<Integer> s2){
        if(s2.isEmpty())
            return;
        int a=s2.pop();
        r(s1,s2);
        s1.push(a);
    }

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int size = s.nextInt();
		Stack<Integer> input = new Stack<Integer>();
		for(int i = 0; i < size; i++) {
			input.push(s.nextInt());
		}
		Stack<Integer> extra = new Stack<Integer>();
		reverseStack(input, extra);
		while(!input.isEmpty()) {
			System.out.print(input.pop() + " ");
		}
	}
}