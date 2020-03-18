import java.util.*;

 

   class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}
 
public class printLevelWise 
{
	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>(); 
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.remove();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.add(childNode);
					currentNode.children.add(childNode);
				}
			} catch (Exception e) {
			}
		}
		return root;
	}


	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		printLevelWise(root); 
	}
    
    public static void printLevelWise(TreeNode<Integer> root)
    {
        Queue<TreeNode<Integer>> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int a=q.size();
            for(int i=0;i<a;i++)
            {
                TreeNode<Integer> in=null;
                try
                {
                   in =q.peek();
                    q.remove();
                }
                catch(Exception e){}

                System.out.print(in.data+" ");
                
                for(int j=0;j<in.children.size();j++)
                {
                    q.add(in.children.get(j));
                }
            }
            System.out.println();
        }
    }


}
