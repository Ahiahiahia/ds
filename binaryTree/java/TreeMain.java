package data_structure.binaryTree.java;

/**
 * Created by hunter on 2019/3/3
 */
public class TreeMain {
    public static void main(String[] args){
        int[] nums = new int[]{5,3,9,8,1,10,3,4};
        BinarySearchTree tree = new BinarySearchTree();
        tree.creatBinarySearchTree(nums);
        tree.addNode(7);
        tree.printTree(tree.getRoot());
    }
}
