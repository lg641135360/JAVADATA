package ch13;

/**
 * 二叉樹節點
 */
public class Node {
    //數據項
    public long data;
    //數據項
    public String sData;
    //左子節點
    public Node leftChild;
    //右子節點
    public Node rightChild;

    /**
     * 構造方法
     * @param data
     */
    public Node(long data, String sData) {
        this.data = data;
        this.sData = sData;
    }
}
