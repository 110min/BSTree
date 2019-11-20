/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstreeapp;

/**
 *
 * @author 174110J
 */
public class BSTreeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        BSTNode k  = new BSTNode(7);
//        System.out.println(k);
            BSTree t = new BSTree();
            t.addNode(9);
            t.addNode(25);
            t.addNode(7);
            t.addNode(14);
            t.addNode(2);
            t.addNode(8);
            t.addNode(31);
            t.addNode(20);
            t.addNode(14);
            t.addNode(1);
            t.inOrderTrvesal(t.root);
            System.out.println();
            t.remove(8);
            t.inOrderTrvesal(t.root);
            System.out.println();
            
            t.preOrderTravesal(t.root);
            System.out.println();
    }
    
}

class BSTNode{
    int data;
    BSTNode leftChild;
    BSTNode rightChild;

    public BSTNode(int data){
        this.data=data;
    }
    
    @Override
    public String toString(){
        return data+" ";
    }
    
    public int minValue(){
        if(this.leftChild == null){
            return this.data;
        }
        return this.leftChild.minValue();
    }
    
    public boolean remove( int data, BSTNode parent){
        if(data<this.data){
            if(this.leftChild == null){
                return false;
            }
            return this.leftChild.remove(data, this);
        }else if(data>this.data){
            if(this.rightChild==null){
               return false;      
            }return this.rightChild.remove(data, this);
        }else{
            if(this.leftChild!=null && this.rightChild!=null){
                this.data = this.rightChild.minValue();
                this.rightChild.remove(this.data, this);
            }else if(parent.leftChild == this){
                parent.leftChild = this.leftChild==null?rightChild:leftChild;
            }else{
                 parent.rightChild = this.leftChild==null?rightChild:leftChild;
            }
            return true;
        }
    }

}

class BSTree {
    
BSTNode root;

public BSTree(){
    this.root = null;
}
 
public void addNode(int data) {
    
    BSTNode n  = new BSTNode(data);
    BSTNode current = root;
    BSTNode parent;
    while(true){
        if(root==null){
            root =n;
            return;
        }
        parent = current;
        if(n.data<current.data){
            current = current.leftChild;
            if(current==null){
                parent.leftChild =n;
                return;
            }
        }else{
            current = current.rightChild;
            if(current==null){
                parent.rightChild =n;
                return;
            }
        }
    }
}

public BSTNode findNode(int data) {
    BSTNode current = root;
    while(true){
        if(current == null){
            return null;
        }
        if(data == current.data){
            return current;
        }else if(data<current.data){
            current =current.leftChild;
        }else{
            current = current.rightChild;
        } 
    }
}

public void preOrderTravesal(BSTNode root){
    if(root == null ){
        return;
    }
    System.out.println(root);
    preOrderTravesal(root.leftChild);
    preOrderTravesal(root.rightChild);
}

public void postOrderTrvesal(BSTNode root){
    if(root == null ){
        return;
    }
    postOrderTrvesal(root.leftChild);
    postOrderTrvesal(root.rightChild);
    System.out.println(root);
}

public void inOrderTrvesal(BSTNode root){
    if(root == null ){
        return;
    }
    inOrderTrvesal(root.leftChild);
    System.out.println(root);
    inOrderTrvesal(root.rightChild);
}

public boolean remove(int data){
    if(root==null){
        return false;
    }else if(data == root.data){
        if(root.leftChild == null){
            root = root.rightChild;
        }else if(root.rightChild == null){
            root = root.leftChild;
        }else{
            return root.remove(data,null);
        }
        return true;
    }
    else{
        return root.remove(data, null);
    }
}


}
