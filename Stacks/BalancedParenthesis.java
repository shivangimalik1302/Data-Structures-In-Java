import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = s.nextLine();
		System.out.println(checkBalanced(input));
	}
    
     public static boolean checkBalanced(String exp) {
        Stack<Character> st= new Stack<>();

        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
            if(c=='(' || c=='[' || c=='{')
            {
                st.push(c);
            }
            else if(c=='}')
            {
                if(st.isEmpty())
                    return false;
                if(st.peek()=='{')
                    st.pop();
                else
                    return false;
            }
            else if(c==']')
            {
                if(st.isEmpty())
                    return false;
                if(st.peek()=='[')
                    st.pop();
                else
                    return false;
            }
            else if(c==')')
            {
                if(st.isEmpty())
                    return false;
                if(st.peek()=='(')
                    st.pop();
                else
                    return false;
            }
        }
        if(st.isEmpty())
            return true;
        else
            return false;
    }
}