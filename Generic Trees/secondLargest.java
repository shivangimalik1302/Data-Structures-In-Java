import java.util.*;

class TreeNode<T> {
	T data;
	ArrayList<TreeNode<T>> children;

	TreeNode(T data){
		this.data = data;
		children = new ArrayList<TreeNode<T>>();
	}
}

public class secondLargest {

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
		TreeNode<Integer> ans = findSecondLargest(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		} 
	}

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> roo)
    {
        if(roo==null)
            return null;
        TreeNode<Integer> large=new TreeNode<>(Integer.MIN_VALUE);
        TreeNode<Integer> small=new TreeNode<>(Integer.MIN_VALUE);
        Queue<TreeNode<Integer>> q=new LinkedList<TreeNode<Integer>>();
        q.add(roo);
        while(!q.isEmpty())
        {
            TreeNode<Integer> root=null;
            try{
                root=q.remove();
            }
            catch(Exception e){

            }
            if(root.data>large.data)
            {
                small.data=large.data;
                large.data=root.data;
            }
            else if(root.data<large.data && root.data>small.data)
            {
                small.data=root.data;
            }
            for(int i=0;i<root.children.size();i++)
            {
                q.add(root.children.get(i));
            }

        }

        return small;
    }
    
    
    
	


}
