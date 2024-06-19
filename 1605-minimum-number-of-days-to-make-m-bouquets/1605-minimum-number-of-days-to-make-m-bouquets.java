// m = bouquets count, k = flowers count

// 이전 검색을 통한 효율적인 최소 일수 탐색
// 특정 일수 내 m개의 꽃다발 생성 가능 여부를 판단하기 위해 헬퍼 사용
// 이진 검색 적용 전 배열 반복으로 최대 개화일 탐색
// 이진 검색 최적 활용
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max=bloomDay[0];
        for(int i = 1; i < bloomDay.length;i++) {
            max=Math.max(max, bloomDay[i]);
        }
        return Days(bloomDay, m, k, max);
    }

    private int Days(int[] arr, int m, int k, int last) {
        int s = 1;
        int l = last;
        int answer = -1;

        while(s <= l) {
            int mid=(s+l)/2;
            if(bloom(arr, m, k, mid)) {
                answer = mid;
                l = mid-1;
            } else {
                s = mid+1;
            }
            
        }
        return answer;

    }
    
    private boolean bloom(int[] arr, int m, int k, int days) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<=days) {
                count++;
            }
            if(count==k){
                m--;
                count=0;
            }
            if(arr[i]>days){
                count=0;
            }
        }
        if(m<=0){
            return true;
        }
        return false;
    }
}