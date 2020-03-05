import java.util.*;
import java.util.Stack;

public class ReverseFirstKElements
{
    
     public static Queue<Integer> reverseKElements(Queue<Integer> input,int k)
    {
        
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<k;i++)
        {
            s.push(input.peek());
            input.remove();
        }

        while(!s.isEmpty())
        {
            input.add(s.peek());
            s.pop();
        }
        
        
        for(int i=0;i<input.size()-k;i++)
        {
            input.add(input.peek());
            input.remove();
        }
        return input;
    }
    
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < n; i++){
			q.add(s.nextInt());
		}
		int k = s.nextInt();
		Queue<Integer> ans = reverseKElements(q,k);
		while(!ans.isEmpty()){
			System.out.println(ans.remove()+" ");
		}
	}
}
