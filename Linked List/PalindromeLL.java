import java.util.Scanner;

class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.setData(data);
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

public class PalindromeLL {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print(isPalindrome_2(input()));
	}

	public static LinkedListNode<Integer> input() {
		int data = s.nextInt();
		
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data!=-1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
    
    public static LinkedListNode<Integer> getNode(LinkedListNode<Integer> head,int i)
    {
        int count=0;
        while(head!=null && count!=i)
        {
            count++;
            head=head.next;
        }
        return head;
    }
    
    public static boolean isPalindrome_2(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> root=head;
        int len=1;
        while(root.next!=null)
        {
            len++;
            root=root.next;
        }
        int si=0;
        int ei=len-1;
        while(si<ei)
        {
        LinkedListNode<Integer> sn=getNode(head,si);
        LinkedListNode<Integer> en=getNode(head,ei);
            if(sn.data!=en.data)
                return false;;
            
            si++;
            ei--;
        }
        return true;
    }

}
