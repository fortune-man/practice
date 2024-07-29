// 배열 내 두 정수의 합이 target이 되는 인덱스를 구하는 프로그램
// for문, if문
// 인덱스 끼리 덧셈
// 덧셈 결과가 target과 일치하는지 검사
// 일치하는 경우 인덱스 번호 저장
// 저장된 인덱스 번호 return

class Solution {
    public int[] twoSum(int[] nums, int target) {
        final int TWO_SUM = 2;
        int[] store = new int[TWO_SUM];

        for(int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                if(valid(nums, i, j, target)) {
                    store[0]= i;
                    store[1]= j;
                }
            }
        }

        return store;
        
    }

    private boolean valid(int[] nums, int i, int j, int target) {
        return nums[i]+nums[j]==target;
    }
}