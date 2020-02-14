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
public class DeleteeveryNnodes {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(skipMdeleteN(input(), s.nextInt(), s.nextInt()));
	}
    
    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        LinkedListNode<Integer> tail=head;
        LinkedListNode<Integer> ans=head;
        int count=0;
        int a=0;
        while(head!=null)
        {
            if(count>=1)
                tail=tail.next;
            head=head.next;
            count++;
            a++;
            if(a==M)
            {
                int j=0;
                while(head!=null && j!=N)
                {
                    head=head.next;
                    j++;
                }
                tail.next=head;
                a=0;
            }
        }
        return ans;
    }
    

	public static void print(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.next;
		}
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

}
