package ch01;

public class MyOrderArray {
    private long[] arr;
    //表示有效数据的长度
    private int elements;

    public MyOrderArray(int maxSize){
        arr = new long[maxSize];
    }

    /**
     * 添加数据
     * @param value
     */
    public void insert(long value){
        int i;
        for (i = 0; i < elements; i++){
            if (arr[i] > value){
                break;
            }
        }

        for (int j = elements; j > i; j--){
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
        elements++;
    }

    /**
     * 显示数据
     */
    public void display() {
        System.out.print("[");
        for(int i = 0; i < elements; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * 查找数据
     * @param value
     * @return
     */
    public int search(long value){
        int i;
        for (i = 0; i < elements; i++){
            if (value == arr[i]){
                break;
            }
        }

        if (i == elements){
            return -1;
        } else {
            return i;
        }
    }

    /**
     * 二分法查找数据
     * @param value
     * @return
     */
    public int binarySearch(long value){
        int middle = 0;
        int low = 0;
        int pow = elements;

        while (true){
            middle = (pow + low) / 2;
            if (arr[middle] == value){
                return middle;
            } else if (low > pow){
                return -1;
            } else {
                if (arr[middle] > value){
                    pow = middle -1;
                } else {
                    low = middle + 1;
                }
            }
        }
    }

    /**
     * 根据索引查找数据
     * @param index
     * @return
     */
    public long get(int index){
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else{
            return arr[index];
        }
    }

    /**
     * 根据索引删除数据
     * @param index
     */
    public void delete(int index){
        if (index >= elements || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        } else{
            for (int i = index; i < elements; i++){
                arr[index] = arr[index + 1];
            }
        }
        elements --;
    }

    /**
     * 更新数据
     * @param index
     * @param newValue
     */
    public void change(int index, int newValue){
        if (index >= elements || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[index] = newValue;
        }
    }
}
