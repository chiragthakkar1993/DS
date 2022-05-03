package binarytree;

/*



              1
            /   \
           /     \
          /       \
         2          3
       /   \       /  \
      4     5     6     7
                 / \
                8   9
    o/p:
        1 3 2 4 5 6 7 9 8
 */

import java.util.Stack;

public class BinaryTreeZigZagTraversal {

    public static void solution(Node root){
        Stack<Node> currStack = new Stack<>();
        Stack<Node> nextStack = new Stack<>();
        boolean leftToRight = false;
        currStack.add(root);
        while(!currStack.isEmpty()){
            Node node = currStack.pop();
            System.out.print(node.data+" ");
            if(leftToRight){
                if(node.rightChild != null)
                    nextStack.add(node.rightChild);
                if(node.leftChild != null)
                nextStack.add(node.leftChild);
            }
            else{
                if(node.leftChild != null)
                    nextStack.add(node.leftChild);
                if(node.rightChild != null)
                    nextStack.add(node.rightChild);
            }

            if(currStack.isEmpty()){
                leftToRight = !leftToRight;

                Stack temp = currStack;
                currStack = nextStack;
                nextStack = temp;
            }


        }

    }
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.leftChild = new Node(2);
        rootNode.rightChild = new Node(3);
        rootNode.leftChild.leftChild = new Node(4);
        rootNode.leftChild.rightChild = new Node(5);
        rootNode.rightChild.leftChild = new Node(6);
        rootNode.rightChild.leftChild.leftChild = new Node(8);
        rootNode.rightChild.leftChild.rightChild = new Node(9);
        rootNode.rightChild.rightChild = new Node(7);

        System.out.println("zig zag Order traversal of binary tree is");
        solution(rootNode);

    }
}
