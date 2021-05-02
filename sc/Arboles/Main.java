package Arboles;

import QueueAndStack.IsEmptyException;

public class Main {

    public static void main(String[] args) {
        BinaryTreeAPI api = new BinaryTreeAPI();
        DoubleNode<String> tleft = new DoubleNode<>("j");
        DoubleNode<String> tright = new DoubleNode<>("k");
        tleft.right = new DoubleNode<>("g");
        tleft.right.left = new DoubleNode<>("u");
        tleft.left = new DoubleNode<>("w");
        tright.left = new DoubleNode<>("s");
        tright.right = new DoubleNode<>("t");
        tleft.left.left = new DoubleNode<>("f");
        tleft.left.right = new DoubleNode<>("m");
        tright.left.left = new DoubleNode<>("a");
        tright.left.right = new DoubleNode<>("b");
        BinaryTree<String> myTree = new BinaryTree<>("h");
        myTree.root.right = tright;
        myTree.root.left = tleft;

        BinaryTree<String> myTree3 = new BinaryTree<>("h");
        myTree3.root.right = tright;
        myTree3.root.left = tleft;


        DoubleNode<String> rtleft = new DoubleNode<>("j");
        DoubleNode<String> rtright = new DoubleNode<>("k");
        rtleft.right = new DoubleNode<>("g");
        rtleft.right.left = new DoubleNode<>("u");
        rtleft.left = new DoubleNode<>("w");
        rtright.left = new DoubleNode<>("s");
        rtright.right = new DoubleNode<>("t");
        rtright.right.left = new DoubleNode<>("f");
        //rtleft.left.left = new DoubleNode<>("f");
        rtleft.left.right = new DoubleNode<>("m");
        rtright.left.left = new DoubleNode<>("a");
        rtright.left.right = new DoubleNode<>("b");
        BinaryTree<String> myTree2 = new BinaryTree<>("h");
        myTree2.root.right = rtright;
        myTree2.root.left = rtleft;
        System.out.println(api.semejantes(myTree, myTree2));
        System.out.println(api.equals(myTree, myTree3));
        api.mostrarFrontera(myTree);

    }
}
