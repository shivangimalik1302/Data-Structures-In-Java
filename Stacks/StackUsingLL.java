import java.util.Scanner;

class Node<T> {
	T data;
	Node next;

	public Node(T data) {
		this.data = data;
	}
}

public class StackUsingLL {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Stack<Integer> st = new Stack<Integer>();

		int choice = s.nextInt();
		int input;

		while (choice !=-1) {
			if(choice == 1) {
				input = s.nextInt();
				st.push(input);
			}
			else if(choice == 2) {
				try {
					System.out.println(st.pop());
				} catch (StackEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 3) {
				try {
					System.out.println(st.top());
				} catch (StackEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 4) {
				System.out.println(st.size());
			}
			else if(choice == 5) {
				System.out.println(st.isEmpty());
			}
			choice = s.nextInt();
		}
	}
}


class StackEmptyException extends Exception{
    
}
class Stack<T> {
    Node<T> head;
    int size;
    public Stack() {
        head=null;
        size=0;
    }

    public int size() {
        return size;
    }

    public void push(T data)
    {
        Node<T> a=new Node<T>(data);

        if(head==null)
        {
            head=a;
        }
        else
        {
            a.next=head;
            head=a;
        }
        size++;
    }

    public boolean isEmpty() 
    {
        if(size==0)
            return true;
        return false;
    }

    public T pop() throws StackEmptyException {
        if(isEmpty())
        {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        else
        {
            T del=head.data;
            head=head.next;
            size--;
            return del;
        }
    }

    public T top() throws StackEmptyException {
        if(isEmpty())
        {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        else
        {
            return head.data;
            
        }

    }
}
