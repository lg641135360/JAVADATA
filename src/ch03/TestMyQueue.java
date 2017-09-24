package ch03;

public class TestMyQueue {
    public static void main(String[] args) {
        MyCycleQueue mq = new MyCycleQueue(4);
        mq.insert(23);
        mq.insert(45);
        mq.insert(16);
        mq.insert(1);

        System.out.println(mq.isEmpty());
        System.out.println(mq.isFull());

        System.out.println(mq.peek());
        System.out.println(mq.peek());

        while (!mq.isEmpty()){
            System.out.println(mq.remove() + " ");
        }

        mq.insert(23);
    }
}
