// 정상에 오르려면 n단계
// 매번 1 또는 2단계
// n단계에 오르려면 몇 단계가 필요한가
class Solution {
    public int climbStairs(int n) {
       int[] memoi = new int[10000];
       memoi[1] = 1;
       memoi[2] = 2;

       for(int i = 3; i <= n; i++) {
        memoi[i] = memoi[i-1] + memoi[i-2];
       }

       return memoi[n];
    }
}