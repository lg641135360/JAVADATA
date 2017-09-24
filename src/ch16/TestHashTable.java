package ch16;

public class TestHashTable {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.insert(new Info("a","張三"));
        ht.insert(new Info("ct","李四"));
        ht.insert(new Info("cba","王五"));

        System.out.println(ht.find("a").getName());
        System.out.println(ht.find("ct").getName());
        System.out.println(ht.find("cba").getName());

        ht.delete("cba");
        System.out.println(ht.find("cba").getName());

        System.out.println(ht.hashCode("a"));
        System.out.println(ht.hashCode("ct"));
    }
}
