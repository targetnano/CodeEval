package moderate;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


class Node 
{ 
    Node right; 
    Node left; 
    int data; 
          
    Node (int key) 
    { 
        right = null; 
        left  = null; 
        data   = key; 
    } 
} 

class BinaryTree 
{ 
    Node root; 
      	      
    BinaryTree() 
    { 
        root = null; 
    } 
      
    public void insert(int key) 
    { 
        root = insert(root, key); 
    } 
      
    private Node insert(Node curNode, int key) 
    { 
        if(curNode == null) 
        { 
            curNode = new Node(key); 
            return curNode; 
        } 
        else 
        { 
            if(key <= curNode.data) 
            { 
                curNode.left = insert(curNode.left, key); 
                return curNode; 
            } 
            else 
            { 
                curNode.right = insert(curNode.right, key); 
                return curNode; 
            } 
        } 
    } 
}

public class LCA 
{	
	public static void main(String[] args) throws IOException
	{
		
		BinaryTree tree = new BinaryTree();
		tree.insert(30);
		tree.insert(52);
		tree.insert(8);
		tree.insert(20);
		tree.insert(29);
		tree.insert(10);
		tree.insert(3);
		
		FileInputStream fstream = new FileInputStream(args[0]);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		
		while((line = br.readLine()) != null)
		{
			String pieces[] = line.split(" ");
			int a = Integer.parseInt(pieces[0]);
			int b = Integer.parseInt(pieces[1]);
			if(a > b)
			{
				int temp = b;
				b = a;
				a = temp;
			}
			System.out.println(getLCA(tree.root, a, b).data);
		}
	}
	
	private static Node getLCA(Node root, int a, int b)
	{
		Node node = null;
		if(root == null)
		{
			return node;
		}
		
		if(root.data >= a && root.data <= b)
		{
			return root;
		}
		else if(root.data >= a)
		{
			node = getLCA(root.left, a, b);
		}
		else
		{
			node = getLCA(root.right, a, b);
		}
		return node;
	}
}
