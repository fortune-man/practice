package two_pointers;

public class _977_Squares_of_a_Sorted_Array {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int size = nums.length;
            int[] result = new int[size];
            int left = 0;
            int right = size - 1;

            for ( int i = size - 1; i >= 0; i-- ) {
                int square;
                if ( Math.abs(nums[left]) < Math.abs(nums[right]) ) {
                    square = nums[right];
                    right--;
                } else {
                    square = nums[left];
                    left++;
                }
                result[i] = square * square;
            }
            return result;
        }
    }
}
