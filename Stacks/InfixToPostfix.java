import java.util.Stack;
import java.util.Scanner;

public class InfixToPostfix {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		evaluatePostfix(input);
	}
    
    public static void evaluatePostfix(String input)
    {
        Stack<Character> s=new Stack<>();
        String res="";
        for(int i=0;i<input.length();i++)
        {

            char c=input.charAt(i);
            if(Character.isDigit(c))
            {
                res+=c;
            }
            else if(c=='(')
                s.push(c);
            else if(c==')')
            {
                while(!(s.peek()=='('))
                {
                    res+=s.pop();

                }
                s.pop();
            }
            else
            {
                while(!s.isEmpty() && precedence(s.peek())>=precedence(c))
                {
                    res+=s.peek();
                    s.pop();
                }
                s.push(c);
            }

        }
        while(!s.isEmpty())
        {
            res+=s.pop();
        }
        System.out.println(res);

        evaluate(res);
    }
    
    public static int precedence(char c)
    {
        if(c=='*' || c=='/')
            return 2;
        else if(c=='+' || c=='-')
            return 1;
        else
            return 0;
    }

    public static void evaluate(String res)
    {
        Stack<Integer> stack=new Stack<>(); 

        for(int i=0;i<res.length();i++) 
        { 
            char c=res.charAt(i); 

            if(Character.isDigit(c)) 
            { 
                int n=c-'0'; 
                stack.push(n); 
            } 
            else
            { 
                int a=stack.pop(); 
                int b=stack.pop(); 

                switch(c) 
                { 
                    case '+': 
                        stack.push(a+b); 
                        break; 

                    case '-': 
                        stack.push(b-a); 
                        break; 

                    case '/': 
                        stack.push(b/a); 
                        break; 

                    case '*': 
                        stack.push(a*b); 
                        break; 
                } 
            } 
        } 
        System.out.print(stack.pop()); 
    }
}


