package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*



              1
            /   \
           /     \
          /       \
         2          3
       /   \       /  \
      4     5     6     7

o/p: 1 2 3 4 5 6 7

 */
class Node{
    int data;
    Node leftChild,rightChild;
    public Node(int data){
        this.data = data;
    }

}
public class BinaryTreeLevelOrderTraversal {

    public static void solution(Node root){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data+" ");
            if(node.leftChild != null)
                queue.add(node.leftChild);
            if(node.rightChild !=null)
                queue.add(node.rightChild);
        }

    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();
        Node rootNode = new Node(1);
        rootNode.leftChild = new Node(2);
        rootNode.rightChild = new Node(3);
        rootNode.leftChild.leftChild = new Node(4);
        rootNode.leftChild.rightChild = new Node(5);
        rootNode.rightChild.leftChild = new Node(6);
        rootNode.rightChild.rightChild = new Node(7);

        System.out.println("level Order traversal of binary tree is");
        tree.solution(rootNode);
    }
}
