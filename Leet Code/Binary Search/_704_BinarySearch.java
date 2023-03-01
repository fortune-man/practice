package binarySearch;

import java.util.stream.IntStream;


public class _704_BinarySearch {

    class Solution {

    public int search(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while ( startIndex <= endIndex ) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[middleIndex] == target) {
                return middleIndex;
            }

            if (nums[middleIndex] <= target) {
                startIndex = middleIndex + 1;
            }

            else { endIndex = middleIndex - 1; }
        }
  

        return -1;
        
        /**
        // 배열 인덱스를 탐색하는 메서드를 작성한다.
        return IntStream.range(0, nums.length)
        .filter(index -> target == nums[index])
        .findFirst()
        .orElse(-1);
        */
        
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
