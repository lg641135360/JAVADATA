package ch16;

import java.math.BigInteger;

public class HashTable {
    private Info[] arr;

    /**
     * 默認的構造方法
     */
    public HashTable() {
        arr = new Info[10000];
    }

    /**
     * 指定數組初始化大小
     */
    public HashTable(int maxSize) {
        arr = new Info[maxSize];
    }

    /**
     * 插入數據
     */
    public void insert(Info info) {
        //獲得關鍵字
        String key = info.getKey();
        //獲得關鍵字自定的哈希值
        int hashVal = hashCode(key);
        //如果這個索引已經被占用，而且裏面是一個未被刪除的數據
        while (arr[hashVal] != null && arr[hashVal].getName() != null) {
            //進行遞加
            ++hashVal;
            //循環
            hashVal %= arr.length;
        }

        arr[hashVal] = info;
    }

    /**
     * 查找數據
     */
    public Info find(String key) {
        int hashVal = hashCode(key);
        while (arr[hashVal] != null) {
            if (arr[hashVal].getKey().equals(key)) {
                return arr[hashVal];
            }
            ++hashVal;
            hashVal %= arr.length;
        }
        return null;
    }

    /**
     * 刪除數據
     * @param key
     * @return
     */
    public Info delete(String key) {
        int hashVal = hashCode(key);
        while (arr[hashVal] != null) {
            if (arr[hashVal].getKey().equals(key)){
                Info tmp = arr[hashVal];
                tmp.setName(null);
                return tmp;
            }
            ++hashVal;
            hashVal %= arr.length;
        }
        return null;
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
