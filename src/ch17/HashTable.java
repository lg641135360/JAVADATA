package ch17;

import java.math.BigInteger;

public class HashTable {
    private LinkList[] arr;

    /**
     * 默認的構造方法
     */
    public HashTable() {
        arr = new LinkList[10000];
    }

    /**
     * 指定數組初始化大小
     */
    public HashTable(int maxSize) {
        arr = new LinkList[maxSize];
    }

    /**
     * 插入數據
     */
    public void insert(Info info) {
        //獲得關鍵字
        String key = info.getKey();
        //獲得關鍵字自定的哈希值
        int hashVal = hashCode(key);
        if (arr[hashVal] == null) {
            arr[hashVal] = new LinkList();
        }
        arr[hashVal].insertFirst(info);
    }

    /**
     * 查找數據
     */
    public Info find(String key) {
        int hashVal = hashCode(key);
        return arr[hashVal].find(key).info;
    }

    /**
     * 刪除數據
     * @param key
     * @return
     */
    public Info delete(String key) {
        int hashVal = hashCode(key);
        return arr[hashVal].delete(key).info;
    }

    public int hashCode(String key) {
//        int hashVal = 0;
//        for (int i = key.length() - 1; i >= 0 ; i--) {
//            int letter = key.charAt(i) - 96;
//            hashVal += letter;
//        }
//        return hashVal;

        BigInteger hashVal = new BigInteger("0");
        BigInteger pow27 = new BigInteger("1");
        for (int i = key.length() - 1; i >= 0 ; i--) {
            int letter = key.charAt(i) - 96;
            BigInteger letterB = new BigInteger(String.valueOf(letter));
            hashVal = hashVal.add(letterB.multiply(pow27));
            pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
        }
        return hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue();
    }
}
