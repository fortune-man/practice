package binarySearch;

import java.util.stream.IntStream;


public class _704_BinarySearch {

    class Solution {
        public int search(int[] nums, int target) {

            // 배열 인덱스를 탐색하는 메서드를 작성한다.
            return IntStream.range(0, nums.length)
                    .filter(index -> target == nums[index])
                    .findFirst()
                    .orElse(-1);

            /**
             for ( int i = 0; i < nums.length; i++ ) {
             if (nums[i] == target) {
             return i;
             }
             }

             return -1;
             */

        }
    }
}
