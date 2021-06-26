import java.util.Queue;
import java.util.LinkedList;
public class LevelOrderInsertion {
	static class Node {
        int data;
        Node left, right;
 
        // constructor
        Node(int key)
        {
            this.data = key;
            left = null;
            right = null;
        }
    }
	static void inorder(Node temp) {
		if (temp == null)
            return;
 
        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);
	}
	static void insert(Node temp,int key) {
		//null root
		if(temp==null) {
			root=new Node(key);
			return;
		}
		//insertion
		Queue<Node> q=new LinkedList<Node>();
		q.add(temp);
		while(!q.isEmpty()) {
			temp=q.peek();
			q.remove();
			
			if(temp.left==null) {
				temp.left=new Node(key);
				break;
			}
			else q.add(temp.left);
			
			if(temp.right==null) {
				temp.right=new Node(key);
				break;
			}
			else q.add(temp.right);
		}
		
	}
	static Node root;
    static Node temp = root;
	public static void main(String args[])
    {
        root = new Node(12);
        root.left = new Node(1);
        root.left.left = new Node(4);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
 
        System.out.print("Before Insertion: ");
        inorder(root);
 
        int key = 18;
        insert(root, key);
 
        System.out.print("\nAfter Insertion: ");
        inorder(root);
    }
}
