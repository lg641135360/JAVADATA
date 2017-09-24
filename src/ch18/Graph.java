package ch18;

/**
 *  圖
 */
public class Graph {
    //頂點數組
    private Vertex[] vertexList;
    //鄰接矩陣
    private int[][] adjMat;
    //頂點的最大數量
    private int maxSize;
    //當前頂點
    private int nVertex;

    public Graph() {
        vertexList = new Vertex[maxSize];
        adjMat = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjMat[i][j] = 0;
            }
        }
        nVertex = 0;
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
}
