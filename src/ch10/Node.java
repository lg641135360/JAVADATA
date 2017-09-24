package ch10;

/**
 * 二叉樹節點
 */
public class Node {
    //數據項
    public long data;
    //左子節點
    public Node leftChild;
    //右子節點
    public Node rightChild;

    /**
     * 構造方法
     * @param data
     */
    public Node(long data) {
        this.data = data;
    }
}
