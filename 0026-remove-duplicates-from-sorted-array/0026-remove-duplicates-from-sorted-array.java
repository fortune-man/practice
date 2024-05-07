// 스스로 해결하라..
// 왜 투포인터인데

// 정수 배열의 중복을 제거하면서 순서를 보장하는 배열로 재생성후 크기를 return

// api 안 쓰고 자료구조와 알고리즘으로 해결
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
