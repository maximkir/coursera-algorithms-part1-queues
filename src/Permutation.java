import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Permutation {


    private static boolean isAdjacent(int k){

        if (k < 10) return false;

        int lastDigit = k % 10;
        int restDigits = k / 10;

        while (restDigits != 0) {
            if (Math.abs(lastDigit - (restDigits % 10)) != 1) return false;
            lastDigit = restDigits % 10;
            restDigits /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
//        int k = Integer.valueOf(args[0]);
//
//        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
//
//        while(!StdIn.isEmpty()){
//            String str = StdIn.readString();
//            randomizedQueue.enqueue(str);
//        }
//
//        Iterator<String> iter = randomizedQueue.iterator();
//        for (int i = 0; i < k & iter.hasNext(); i++){
//            System.out.println(iter.next());
//        }

        for (char c : "hello".toCharArray()){

        }
        System.out.println(isAdjacent(12));
        System.out.println(isAdjacent(10));
        System.out.println(isAdjacent(33));
        System.out.println(isAdjacent(123456));
    }
}
