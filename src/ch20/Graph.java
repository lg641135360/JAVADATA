package ch20;


import ch03.MyStack;

/**
 *  圖
 */
public class Graph {
    //頂點數組
    private Vertex[] vertexList;
    //鄰接矩陣
    private int[][] adjMat;
    //頂點的最大數量
    private int maxSize = 20;
    //當前頂點
    private int nVertex;
    //棧
    private MyStack stack;

    public Graph() {
        vertexList = new Vertex[maxSize];
        adjMat = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjMat[i][j] = 0;
            }
        }
        nVertex = 0;
        stack = new MyStack();
    }

    /**
     * 添加頂點
     */
    public void addVertex(char label) {
        vertexList[nVertex++] = new Vertex(label);
    }

    /**
     * 添加邊
     *
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public int getadjUnvisitedVertex(int v) {
        for (int i = 0; i < nVertex; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public void dfs() {
        //首先訪問0號節點
        vertexList[0].wasVisited = true;
        //顯示該節點
        displayVertex(0);
        //壓入棧中
        stack.push(0);
        while (!stack.isEmpty()) {
            //獲得一個未訪問過的鄰接點
            int v = getadjUnvisitedVertex((int)stack.peek());
            if (v == -1) {
                //彈出一個頂點
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        
        //搜索完成以後，要將訪問信息修改
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    public void mst() {
        //首先訪問0號節點
        vertexList[0].wasVisited = true;
        //顯示該節點
        displayVertex(0);
        //壓入棧中
        stack.push(0);
        while (!stack.isEmpty()) {
            //當前頂點
            int currentVertex = (int) stack.peek();
            //獲得一個未訪問過的鄰接點
            int v = getadjUnvisitedVertex(currentVertex);
            if (v == -1) {
                //彈出一個頂點
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;

                stack.push(v);
                displayVertex(currentVertex);
                System.out.print("-");
                displayVertex(v);
                System.out.print(" ");
            }
        }

        //搜索完成以後，要將訪問信息修改
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}
