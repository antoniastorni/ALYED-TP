package Arboles;

import Queue.DynamicQueue;
import Queue.IsEmptyException;

public class ShowTree {

    public void preorden(BinaryTree  a){
        if(!a.isEmpty()){
            System.out.println( a.getRoot());
            preorden(a.getLeft());
            preorden(a.getRight());
        }
    }

    public  void inorden(BinaryTree  a){
        if(!a.isEmpty()){
            inorden(a.getLeft());
            System.out.println( a.getRoot());
            inorden(a.getRight());
        }
    }
    public void postorden(BinaryTree  a){
        if(!a.isEmpty()){
            postorden(a.getLeft());
            postorden(a.getRight());
            System.out.println( a.getRoot());
        }
    }

    public void porNiveles(BinaryTree a) throws IsEmptyException {
        DynamicQueue<BinaryTree> q = new DynamicQueue<>();
        q.enqueue(a);
        while(!q.isEmpty()) {
            //a = frente de cola
            System.out.println( a.getRoot());
            if (!a.getLeft().isEmpty())
                q.enqueue(a.getLeft());
            if (!a.getRight().isEmpty())
                q.enqueue(a.getRight());
            q.dequeue();
        }
    }
}
