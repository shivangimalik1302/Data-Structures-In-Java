import java.util.Scanner;
import java.util.Stack;

public class checkRedundantBrackets {
	static Scanner s = new Scanner(System.in);
    
    public static boolean checkRedundantBrackets(String input) 
    {
        Stack<Character> st=new Stack<>();
        int count=0;
        for(int i=0;i<input.length();i++)
        {
            char a=input.charAt(i);
            if(a==')')
            {
                while(st.peek()!='(')
                {
                    st.pop();
                    count++;
                }
                if(count==0)
                    return true;
                
                st.push(a);
                count=0;
            }
            else
            {
                st.push(a);
            }
        }
        return false;
	}

	
	public static void main(String[] args) {
		String input = s.nextLine();
		System.out.println(checkRedundantBrackets(input));
	}
}