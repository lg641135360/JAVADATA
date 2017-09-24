package ch11;

/**
 * 二叉樹類
 */
public class Tree {
    //根節點
    public Node root;

    /**
     * 插入節點
     * @param value
     */
    public void insert(long value, String sData) {
        //封裝節點
        Node newNode = new Node(value,sData);
        //引用當前節點
        Node current = root;
        //引用父節點
        Node parrent;
        //如果root為null，也就是第一次插入的時候
        if (root == null) {
            root = newNode;
            return;
        } else {
            while (true) {
                //父節點指向當前節點
                parrent = current;
                //如果當前指向的節點比插入的要大，則向左走
                if (current.data > value) {
                    current = current.leftChild;
                    if (current == null) {
                        parrent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parrent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找節點
     * @param value
     */
    public Node find(long value) {
        //引用當前節點，從根節點開始
        Node current = root;
        //循環，衹要查找值不等於當前節點的數據項
        while (current.data != value){
            //進行比較，比較查找值和當前節點的大小
            if (current.data > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 刪除節點
     * @param value
     */
    public void delete(long value) {

    }
}
