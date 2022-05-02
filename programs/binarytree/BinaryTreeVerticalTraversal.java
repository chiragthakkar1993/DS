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
        1 5 6
        2 8
        3 9
        4
        7



 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class QNode{
    Node node;
    int hd;
    public QNode(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}
public class BinaryTreeVerticalTraversal {
    static Map<Integer, ArrayList<Integer>> hdMap = new LinkedHashMap<>();
    public static void solution(Node root){
        if(root == null)
            return;


        Queue<QNode> queue = new LinkedBlockingQueue<>();
        queue.add(new QNode(root,0));
        ArrayList list;
        while(!queue.isEmpty()){
            QNode qNode = queue.poll();
            if(hdMap.containsKey(qNode.hd))
                list = hdMap.get(qNode.hd);
            else{
                list = new ArrayList();
            }
            list.add(qNode.node.data);
            hdMap.put(qNode.hd, list);
            if(qNode.node.leftChild != null)
                queue.add(new QNode(qNode.node.leftChild,qNode.hd - 1));
            if(qNode.node.rightChild != null)
                queue.add(new QNode(qNode.node.rightChild,qNode.hd + 1));
        }
    }
    public static void printBinaryTreeInVerticalOrder(){
        hdMap.values().forEach(
                list-> {
                    list.stream().map(val-> val+" ").forEach(System.out::print);
                    System.out.println();
                }
        );
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

        System.out.println("vertical Order traversal of binary tree is");
        solution(rootNode);
        printBinaryTreeInVerticalOrder();
    }
}
