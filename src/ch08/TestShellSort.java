package ch08;

import com.sun.xml.internal.ws.message.saaj.SAAJHeader;

public class TestShellSort {
    public static void main(String[] args) {
        long[] arr = new long[5];
        arr[0] = 34;
        arr[1] = 23;
        arr[2] = 2;
        arr[3] = 1;
        arr[4] = -4;

        System.out.print("[");
        for(long num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();

        ShellSort.sort(arr);

        System.out.print("[");
        for(long num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
