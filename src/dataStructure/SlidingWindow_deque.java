package dataStructure;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SlidingWindow_deque {
    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            //최소값 검사 / index 유효성 검사
            while(deque.isEmpty() && deque.peekLast().value>now) {//현재 노드가 덱의 마지막 노드보다 작으면? 마지막 노드 제거 ( 반복_
                deque.removeLast();
            }

            if (i - deque.peekFirst().index > L) {
                deque.removeFirst();
            }
            //덱 업데이트
            deque.addLast(new Node(i, now));
            //최소값 결과 업데이트
            answer[i] = deque.peekFirst().value;
        }
    }

    class Node {
        public int value;
        public int index;

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
