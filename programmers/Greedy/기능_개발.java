package Greedy;

import java.util.*;


public class 기능_개발 {
    static class Solution {
        public int solution(int[] scoville, int K) {

            int count = 0;

            // heap 사용으로 우선순위 따라 정렬하라
            Queue<Integer> heap = new PriorityQueue<>();

            offerScivilleUnits(scoville, heap);

            return increaseCount(K, count, heap);

        }

        // 연산 횟수를 증가시켜라
        private static int increaseCount(int K, int count, Queue<Integer> heap) {
            while (heap.peek() < K) {

                if ( heap.size() == 1 ) {
                    return -1;
                }

                initializeNewScoville(heap);

                count++;
            }

            return count;
        }

        // 스코빌 지수를 추가하라
        private static void offerScivilleUnits(int[] scoville, Queue<Integer> heap) {
            for (int scovilleUnit : scoville) {
                heap.offer(scovilleUnit);
            }
        }

        // 새로운 스코빌 지수의 음식을 생성하라
        private static void initializeNewScoville(Queue<Integer> heap) {

            int least = heap.poll();
            int second = heap.poll();

            int newScoville = least + (second * 2);
            heap.offer(newScoville);

        }

    }
}
