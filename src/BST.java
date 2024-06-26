import java.util.ArrayList;
// Teddy Meeks
/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    // Use Helper
    public boolean search(int val) {
        // TODO: Complete the search function
        return search(root, val);
    }

    // Checks for null, then checks each right and left
    public boolean search(BSTNode n, int target)
    {
        if (n == null)
        {
            return false;
        }
        if (target == n.getVal())
        {
            return true;
        }
        if (target > n.getVal())
        {
            return search(n.getRight(), target);
        }
        return search(n.getLeft(), target);
    }
    /**
     * @return ArrayList of BSTNodes in inorder
     */

    // Uses helper
    public ArrayList<BSTNode> getInorder()
    {
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        getInorder(list, root);
        return list;
    }
    // Checks null then recurses down left, gets root, then goes right
    public void getInorder(ArrayList<BSTNode> list, BSTNode n) {
        // TODO: Complete inorder traversal
        if(n == null)
        {
            return;
        }
        getInorder(list, n.getLeft());
        list.add(n);
        getInorder(list, n.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder()
    {
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        getPreorder(list, root);
        return list;
    }
    // Checks null then gets root, recurses down left, then goes right
    public void getPreorder(ArrayList<BSTNode> list, BSTNode n) {
        // TODO: Complete preorder traversal
        if(n == null)
        {
            return;
        }
        list.add(n);
        getPreorder(list, n.getLeft());
        getPreorder(list, n.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder()
    {
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        getPostorder(list, root);
        return list;
    }
    // Checks null then recurses down left, then goes right, then gets root
    public void getPostorder(ArrayList<BSTNode> list, BSTNode n) {
        // TODO: Complete postorder traversal
        if(n == null)
        {
            return;
        }
        getPostorder(list, n.getLeft());
        getPostorder(list, n.getRight());
        list.add(n);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
//        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
//        insert(list, val);
    }

    public BSTNode insert(BSTNode curr, int val)
    {
        // Check null
        if (curr == null)
        {
            curr = new BSTNode(val);
            return curr;
        }
        // Check for left
        else if (val < curr.getVal())
        {
            curr.setLeft(insert(curr.getLeft(), val));
        }
        // Check for right
        else if (val > curr.getVal())
        {
            curr.setRight(insert(curr.getRight(), val));
        }
        return curr;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
