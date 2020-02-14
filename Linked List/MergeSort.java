import java.util.Scanner;
class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}
}

public class MergeSort{
	private static Scanner s = new Scanner(System.in);

	public static LinkedListNode<Integer> input() {
		int data = s.nextInt();

		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data != -1) {
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

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {

		print(mergeSort(input()));

	}
    
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        // write your code here
        if(head.next==null)
            return head;

        LinkedListNode<Integer> mid=midnode(head);
        LinkedListNode<Integer> save=mid.next;
        mid.next=null;
        LinkedListNode<Integer> head1=mergeSort(head);
        LinkedListNode<Integer> head2=mergeSort(save);
        LinkedListNode<Integer> ans =merge2sorted(head1,head2);
        return ans;
    }



    public static LinkedListNode<Integer> midnode(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> slow=head;
        LinkedListNode<Integer> fast=head;
        while(fast.next !=null && fast.next.next !=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static LinkedListNode<Integer> merge2sorted(LinkedListNode<Integer> head1,LinkedListNode<Integer> head2)
    {
        LinkedListNode<Integer> head=null;
        LinkedListNode<Integer> tail=null;
        while(head1!=null && head2!=null)
        {
            if(head1.data<head2.data)
            {
                LinkedListNode<Integer> save=head1;
                head1=head1.next;
                save.next=null;
                if(head==null)
                {
                    head=save;
                    tail=save;
                }
                else
                {
                    tail.next=save;
                    tail=save;
                }
            }
            else
            {
                LinkedListNode<Integer> save=head2;
                head2=head2.next;
                save.next=null;
                if(head==null)
                {
                    head=save;
                    tail=save;
                }
                else
                {
                    tail.next=save;
                    tail=save;
                }
            }
        }
        if(head1==null)
        {
            if(head==null)
            {
                head=head2;
                tail=head2;
            }
            else
            {
                tail.next=head2;
                tail=head2;
            }
        }
        else if(head2==null)
        {
            if(head==null)
            {
                head=head1;
                tail=head1;
            }
            else
            {
                tail.next=head1;
                tail=head1;
            }
        }
        return head;
    }

}
