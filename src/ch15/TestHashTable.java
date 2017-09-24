package ch15;

public class TestHashTable {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.insert(new Info("abcabcabcabcacbgads","張三"));
        ht.insert(new Info("bbb","李四"));
        ht.insert(new Info("cba","王五"));

        System.out.println(ht.find("abcabcabcabcacbgads").getName());
        System.out.println(ht.find("bbb").getName());
        System.out.println(ht.find("cba").getName());
    }
}
