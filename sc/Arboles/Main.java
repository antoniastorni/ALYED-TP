package Arboles;

public class Main {

    public static void main(String[] args) {
        DoubleNode<String> tleft = new DoubleNode<>("j");
        DoubleNode<String> tright = new DoubleNode<>("k");
        tleft.left = new DoubleNode<>("w");
        tright.left = new DoubleNode<>("s");
        tright.right = new DoubleNode<>("t");
        tleft.left.left = new DoubleNode<>("f");
        tleft.left.right = new DoubleNode<>("m");
        tright.left.left = new DoubleNode<>("a");
        tright.left.right = new DoubleNode<>("b");
        BinaryTree<String> myTree = new BinaryTree<>("h", tleft, tright);


    }
}
