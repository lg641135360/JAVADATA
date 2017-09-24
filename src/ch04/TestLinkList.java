package ch04;

public class TestLinkList {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFirst(34);
        linkList.insertFirst(22);
        linkList.insertFirst(12);

//        linkList.display();
//
//        linkList.deleteFirst();
//        linkList.display();
//
//        Node node = linkList.find(22);
//        node.display();

        Node node1 = linkList.delete(34);
        node1.display();

        linkList.display();
    }
}
