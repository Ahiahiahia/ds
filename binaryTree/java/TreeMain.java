package data_structure.binaryTree.java;

/**
 * Created by hunter on 2019/3/3
 */
public class TreeMain {
    public static void main(String[] args){
        int[] nums = new int[]{5,3,9,8,1,10,3,4};
        BinarySearchTree tree = new BinarySearchTree();
        tree.creatBinarySearchTree(nums);
        tree.printTree(tree.getRoot());
        System.out.println();
        int[] nums1 = new int[]{3,1,3,4};
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.creatBinarySearchTree(nums1);
        tree1.printTree(tree1.getRoot());
        System.out.println();
        int n = new BinarySearchTree().Tree(tree.getRoot(), tree1.getRoot());
        System.out.println(n);

    }
}
