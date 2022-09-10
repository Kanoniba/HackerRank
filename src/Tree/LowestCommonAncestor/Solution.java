package Tree.LowestCommonAncestor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


class NodeB {
    static int times = 0;

    Node node;
    NodeB lb;
    NodeB rb;
    int in = -1;
    int out = -1;

    NodeB(Node n) {
        in = times;
        times++;
        if (n.left != null) {
            lb = new NodeB(n.left);
        }
        if (n.right != null) {
            rb = new NodeB(n.right);
        }
        out = times;
        times++;
    }

}

class Solution {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    static List<Integer> pathA = new ArrayList<>();
    static List<Integer> pathB = new ArrayList<>();


    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        NodeB nb = new NodeB(root);
        foundVal(root, v1, new ArrayList<Integer>(), 1);
        foundVal(root, v2, new ArrayList<Integer>(), 2);
        System.out.println(pathA);
        System.out.println(pathB);
        int s1 = pathA.size();
        int s2 = pathB.size();
        List l1;
        List l2;
        if (s1 > s2) {
            l1 = pathA;
            l2 = pathB;
        } else {
            l1 = pathB;
            l2 = pathA;
        }
        for(int i=l1.size()-1;i>=0 ;i--){
            if(l2.contains(l1.get(i))){
                return foundNode(root, (Integer) l1.get(i));
            }
        }
        return null;
    }
    public static Node foundNode(Node n,int v) {
        if (n == null)
            return null;
        if (n.data == v)
            return n;
        Node l =  foundNode(n.left,v);
        Node r=   foundNode(n.right,v);
        if(l!=null)
            return l;
        else
            return r;
    }

    public static List<Integer> foundVal(Node n, int v, List<Integer> list, int path) {
        if (n == null)
            return list;
        if (n.data == v) {
            list.add(v);
            if (path == 1)
                pathA = new ArrayList<>(list);
            else
                pathB = new ArrayList<>(list);
            return list;
        }
        list.add(n.data);
        list = foundVal(n.left, v, list, path);
        list = foundVal(n.right, v, list, path);
        list.remove(list.size() - 1);
        return list;
    }


    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner scan = new Scanner(doc);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }
}