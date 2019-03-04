package data_structure.binaryTree.java;

/**
 *
 * 二叉树
 */
public class BinaryTree {
    private Node root;  // 根节点
    private int size;   // 二叉树的当前节点个数

    class Node{
        private Node left;  // 左孩子
        private Node right; // 右孩子
        private int data;
        public Node(Node left, Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public Node getRoot(){
        return this.root;
    }

    /**
     * 创建二叉树
     * @param chs 层序遍历序列
     */
    public Node createTree(int chs[], int n){
        if(n>=chs.length){
            return null;
        }
        Node parent = new Node(null, null, chs[n]);
        if(n == 0){
            this.root = parent;
        }
        parent.left = createTree(chs, 2*n+1);
        parent.right = createTree(chs, 2*n+2);
        return parent;
    }

//    public void createTree(int chs[]){
//        Node newNode = new Node(null, null, chs[0]);
//        this.root = newNode;
//        int i = 0;
//        Node[] child = new Node[1];
//        child[0] = this.root;
//        while(i < chs.length){
//            int n = (int)Math.pow(2, i);
//            Node[] parents = new Node[n];
//            n = (int)Math.pow(2, i+1);
//            child = new Node[n];
//            parents = child;
//            for(int j=0,k=0; j<parents.length; j++){
//                Node newNode1 = new Node(null, null, chs[i*2+1]);
//                Node newNode2 = new Node(null, null, chs[i*2+2]);
//                parents[j].left = newNode1;
//                child[k] = newNode1;
//                k++;
//                parents[j].right = newNode2;
//                child[k] = newNode2;
//                k++;
//            }
//
//        }
//    }

    /**
     * 前序遍历
     */
    public void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(Node root){
        if(root == null){
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * 层序遍历
     * @param root
     */
    public void levelOrder(Node root){
        if(root == null){
            return ;
        }
    }
}
