

import java.util.Scanner;

class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data=data;
		this.next = null;
	}
}

public class EvenafterOddLinkedList {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(sortEvenOdd(input()));
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
    
    public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
        if(head.next==null)
            return head;
        LinkedListNode<Integer> even=null;
        LinkedListNode<Integer> etail=null;
        LinkedListNode<Integer> odd=null;
        LinkedListNode<Integer> otail=null;
        while(head!=null)
        {
            if(head.data%2 ==0)
            {
                if(even==null)
                {
                    even=head;
                    etail=head;
                }
                else
                {
                    etail.next=head;
                    etail=head;
                }
            }
            else
            {
                if(odd==null)
                {
                    odd=head;
                    otail=head;
                }
                else
                {
                    otail.next=head;
                    otail=head;
                }
            }
            head=head.next;
        }
           if(even==null)
               return odd;
        if(odd==null)
            return even;
        
        otail.next=even;
        return odd;
        
        
	}

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
