package ch12;

public class TestTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10,"James");
        tree.insert(50,"YAO");
        tree.insert(5,"Mac");
        tree.insert(2,"Liukang");
        tree.insert(4,"Hugao");
        tree.insert(11,"Geng");

//        System.out.println(tree.root.data);
//        System.out.println(tree.root.rightChild.data);

//        Node node = tree.find(20);
//        System.out.println(node.data + "," + node.sData);

//        tree.frontOrder(tree.root);

//        tree.inOrder(tree.root);
        tree.postOrder(tree.root);
    }
}
