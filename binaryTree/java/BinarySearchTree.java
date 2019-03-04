package data_structure.binaryTree.java;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {
    private Node root;  // 根节点
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

    public Node getRoot() {
        return root;
    }

    /**
     * 创建二叉搜索树
     * @param nums
     */
    public void creatBinarySearchTree(int[] nums){
        Node rootNode = new Node(null, null, nums[0]);
        this.root = rootNode;
        for(int i=1; i<nums.length; i++){
            Node temp = this.root;
            Node newNode = new Node(null, null, nums[i]);
            while(temp.left != null && temp.right != null){
                if(nums[i] >= temp.data){
                    temp = temp.right;
                }else{
                    temp = temp.left;
                }
            }
            if(nums[i] >= temp.data){
                temp.right = newNode;
            }else{
                temp.left = newNode;
            }
        }
    }

    /**
     * 在二叉搜索树中添加节点
     * @param num
     */
    public void addNode(int num){
        Node newNode = new Node(null, null, num);
        if(this.root == null){
            this.root = newNode;
        }
        Node temp = this.root;
        while(temp.right != null && temp.left !=null){
            if(num >= temp.data){
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
        if(num >= temp.data){
            temp.right = newNode;
        }else{
            temp.left = newNode;
        }
    }

    /**
     * 在二叉搜索树中查找元素
     * @param num
     * @return
     */
    public boolean findNode(int num){
        if(this.root == null){
            return false;
        }
        Node temp = this.root;
        while(temp != null){
            if(temp.data == num){
                return true;
            }else if(num < temp.data){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return false;
    }

    /**
     * 删除一个节点
     * @param num
     */
    public void removeNode(int num){
        if(this.root == null){
            return;
        }
        Node parent = null;
        Node child = this.root;
        while(child.left != null && child.right != null){
            if(num < child.data){
                parent = child;
                child = child.left;
            }else if(num > child.data){
                parent = child;
                child = child.right;
            }else{
                // 删除叶子节点
                if(child.right == null && child.left == null) {
                    if(parent.left.data == num){
                        parent.left = null;
                    }else{
                        parent.right = null;
                    }
                // 删除有两个子节点的节点
                }else if(child.left != null && child.right != null){
                    //TODO 找后继节点（右子树里最小的），或者前驱节点（左子树里最大的）
                // 删除有一个叶子节点的节点
                }else{
                    //TODO 跟叶子节点交换，然后删除叶子节点
                }
            }
        }
        System.out.println("没找到该节点");
    }

    /**
     * 打印
     * @param root
     */
    public void printTree(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + "、");
        printTree(root.left);
        printTree(root.right);
    }
}
