
import java.util.Scanner;
import java.util.Stack;

public class minimumBracketReversal 
{
    
    public static int countBracketReversals(String input)
    {

        if(input.length()%2 ==1)
        {
            return -1;
        }

        else
        {
            Stack<Character> s=new Stack<>();

            for(int i=0;i<input.length();i++)
            {
                char c=input.charAt(i);
                if(s.isEmpty())
                    s.push(c);
                else if(c=='}'&& s.peek()=='{')
                {
                    s.pop();
                }
                else
                {
                    s.push(c);
                }
            }
            int ans=0;
            while(!s.isEmpty())
            {
                char a=s.pop();
                char b=s.pop();
                if(a==b)
                {
                    ans+=1;
                }
                else
                    ans+=2;
            }
            return ans;
        }
        
    }






	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {

		String str = s.nextLine();
		System.out.println(countBracketReversals(str));

	}

}
