package dfs_bfs;

import java.util.*;

public class 타겟_넘버_bfs {

    public int solution(int[] numbers, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        for (int i = 0; i < numbers.length; i++) {
            int size = queue.size();

            updateSum(queue, size, numbers[i]);
        }

        int targetNumberCount = 0;

        return getTargetNumberCount(target, queue, targetNumberCount);
    }

    private static int getTargetNumberCount(int target, Queue<Integer> queue, int targetNumberCount) {
        while (!queue.isEmpty()) {
            if (queue.poll() == target) {
                targetNumberCount++;
            }
        }
        return targetNumberCount;
    }

    private static void updateSum(Queue<Integer> queue, int size, int numbers) {
        for (int j = 0; j < size; j++ ) {
            Integer sum = queue.poll();
            queue.offer(sum + numbers);
            queue.offer(sum - numbers);
        }
    }

}
