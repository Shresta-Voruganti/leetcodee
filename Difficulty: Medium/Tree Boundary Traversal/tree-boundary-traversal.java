//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    public ArrayList<Integer> nodes = new ArrayList<>(1000);
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        if(node == null || node.data == -1) {
            return nodes;
        }
        
        nodes.add(node.data);
        leftBoundaryBT(node.left);
        leaves(node.left);
        leaves(node.right);
        rightBoundaryBT(node.right);
        
        return nodes;
    }
    
    void leftBoundaryBT(Node root) {
        if(root == null || root.data == -1 || ((root.left == null || root.left.data == -1) && (root.right == null || root.right.data == -1))) {
            return;
        }
        nodes.add(root.data);
        
        if(root.left == null || root.left.data == -1) {
            leftBoundaryBT(root.right);
        }
        else {
            leftBoundaryBT(root.left);
        }
    }
    
    void rightBoundaryBT(Node root) {
        if(root == null || root.data == -1 || ((root.left == null || root.left.data == -1) && (root.right == null || root.right.data == -1))) {
            return;
        }
        
        if(root.right == null || root.right.data == -1) {
            rightBoundaryBT(root.left);
        }
        else {
            rightBoundaryBT(root.right);
        }
        
        nodes.add(root.data);
    }
    
    void leaves(Node root) {
        if(root == null || root.data == -1) {
            return;
        }
        
        if((root.left == null || root.left.data == -1) && (root.right == null || root.right.data == -1)) {
            nodes.add(root.data);
            return;
        }
        
        leaves(root.left);
        leaves(root.right);
    }
}
