import java.util.*;

class TreeNode<T> {
	T data;
	ArrayList<TreeNode<T>> children;

	TreeNode(T data){
		this.data = data;
		children = new ArrayList<TreeNode<T>>();
	}
}

public class countLeafNodes {

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
		System.out.println(countLeafNodes(root));

	}
    
    
    
	public static int countLeafNodes(TreeNode<Integer> root)
    {
       
        if(root==null)
            return 0;
        
        if(root.children.size()==0)
            return 1;
        int count=0;
        for(int i=0;i<root.children.size();i++)
        {
            count+=countLeafNodes(root.children.get(i));
        }
        return count;
	}


}
