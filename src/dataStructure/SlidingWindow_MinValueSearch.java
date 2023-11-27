package dataStructure;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow_MinValueSearch {
    public static void slidingWindow_MinValueSearch(int[] arr, int L) {
        Deque<Node> deque = new LinkedList<>();
        int[] eachMinValue = new int[arr.length];
        Node now = new Node();

        now.setIndex(0);
        now.setValue(arr[0]);
        eachMinValue[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            //현재노드
            now.setIndex(i);
            now.setValue(arr[i]);
            //덱의 마지막부터 현재값보다 큰 노드 remove
            while (now.value > deque.peekLast().value || deque.isEmpty()) {
                if (now.getValue() <= deque.peekLast().value) {
                    deque.removeLast();
                }
            }
            //현재 노드 추가
            deque.addFirst(now);
            //인덱스 유효성 검사 / 조절
            if (deque.peekFirst().index - now.getIndex() > L) {
                deque.removeFirst();
            }
            //덱의 맨 앞 값 add
            deque.addFirst(now);

            //결과 업데이트
            eachMinValue[i] = deque.peekFirst().value;
        }

        for(int i=0; i< eachMinValue.length;i++){
            System.out.println(eachMinValue[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,3,6,2,4,7,3,5,2,6};
        int L = 3;
        slidingWindow_MinValueSearch(arr, L);
    }
}

class Node {
    int index;
    int value;

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
