package ch05;

import ch04.Node;

/**
 * 双端链表
 */
public class FirstLastLinkList {
    //头节点
    private Node first;
    //尾节点
    private Node last;

    public FirstLastLinkList(){
        first = null;
        last = null;
    }

    /**
     * 插入一个节点，在头节点后进行插入
     */
    public void insertFirst(long value){
        Node node = new Node(value);
        if (isEmpty()) {
            last = node;
        }
        node.next = first;
        first = node;
    }

    /**
     * 插入一个节点，从尾节点插入
     */
    public void insertLast(long value){
        Node node = new Node(value);
        if (isEmpty()){
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    /**
     * 删除一个节点，在头节点后进行删除
     */
    public Node deleteFirst(){
        Node tmp = first;
        if (first.next == null){
            last = null;
        }
        first = tmp.next;
        return tmp;
    }

    /**
     * 显示方法
     */
    public void display(){
        Node current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 查找方法
     */
    public Node find(long value) {
        Node current = first;
        while (current.data != value){
            if (current.next == null){
                return null;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * 删除方法，根据数据域来进行删除
     */
    public Node delete(long value){
        Node current = first;
        Node previous = first;
        while (current.data != value){
            if (current.next == null){
                return null;
            }
            previous = current;
            current = current.next;
        }

        if (current == first){
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return (first == null);
    }
}
