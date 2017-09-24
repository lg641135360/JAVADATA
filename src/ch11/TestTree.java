package ch11;

public class TestTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10,"James");
        tree.insert(20,"YAO");
        tree.insert(60,"Mac");

        System.out.println(tree.root.data);
        System.out.println(tree.root.rightChild.data);

        Node node = tree.find(20);
        System.out.println(node.data + "," + node.sData);
    }
}
