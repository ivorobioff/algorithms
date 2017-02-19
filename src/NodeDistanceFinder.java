/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class NodeDistanceFinder {

    public static void main(String[] args) {
        int[] numbers = { 25, 20, 10, 23, 5, 21, 30, 35, 32 };

        Node root = null;

        for (int number : numbers){
            Node node = new Node(number);
            if (root == null){
                root = node;
            } else {
                setNode(root, node);
            }
        }

        System.out.println(distance(root, 25, 5));
    }

    private static int distance(Node root, int n1, int n2){
        Node node1 = new Node(n1);
        Node node2 = new Node(n2);

        Node lca = lca(root, node1, node2);

        if (lca == null){
            return -1;
        }

        int l1 = length(lca, node1);
        int l2 = length(lca, node2);

        if (l1 == -1 || l2 == -1){
            return -1;
        }

        return l1 + l2;
    }

    private static Node lca(Node root, Node n1, Node n2){

        if (root == null){
            return null;
        }

        if (root.value == n1.value || root.value == n2.value){
            return root;
        }

        if (root.value > n1.value && root.value > n2.value){
            return lca(root.left, n1, n2);
        }

        if (root.value < n1.value && root.value < n2.value){
            return lca(root.right, n1, n2);
        }

        return root;
    }

    private static int length(Node root, Node node, int steps)
    {
        if (root == null){
            return -1;
        }

        if (root.value == node.value){
            return steps;
        }

        int l = length(root.left, node, steps + 1);

        if (l > -1){
            return l;
        }

        int r = length(root.right, node, steps + 1);

        if (r > -1){
            return r;
        }

        return -1;
    }

    private static int length(Node root, Node node)
    {
        return length(root, node, 0);
    }

    private static void setNode(Node parent, Node node){

        if (node.value < parent.value){
            if (parent.left == null){
                parent.left = node;
            } else {
                setNode(parent.left, node);
            }
        } else {
            if (parent.right == null){
                parent.right = node;
            } else {
                setNode(parent.right, node);
            }
        }
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v){
            value = v;
        }
    }
}
