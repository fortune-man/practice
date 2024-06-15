// 컨텍스트 이해
// k = 프로젝트 개수, w는 초기 자본, profits[] 이익 db, 자본 db = capital[] 
// 이익 db 변경에 따라 자본 db결과를 최대화하도록 설계하는 함수
// 기능 목록 정의
// w값을 전달받으면 이익 결과를 return 
// 이익 결과를 전달받으면 자본 db 변경
// 최종 자본 최대화하기 위한 k개 선택
// 최종 자본 db의 인덱스 합산 결과를 return 

// ---

// 자본을 기준으로 프로젝트 정렬 : 정렬
// 이익을 위한 최대 힙 사용 : 최대 힙 사용하여 항상 가장 높은 이익을 얻을 수 있는 프로젝트에 빠른 접근
// 자본 내 프로젝트 처리 : 해당 이익을 힙에 추가
// 최고 수익 프로젝트 선택 : 최대 k회 반복의 경우
// 결과 자본 : 잠재적으로 k개 프로젝트를 선택한 후 결과 자본
// 시간 (O(NlogN + Klogn)), 공간 (On)
class Solution {
    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        List<Project> projects = new ArrayList<>();

        // 자본과 이익이 포함된 프로젝트 목록 작성
        for (int i = 0; i < n; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }

        // 자본을 기준으로 프로젝트 정렬
        Collections.sort(projects, (a, b) -> a.capital - b.capital);

        // profit 저장을 위해 최대 힙 사용
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;

        // 최대 k개 프로젝트 선택 위한 메인 루프
        for (int j = 0; j < k; j++) {
            // 수용 가능한 모든 수익성 프로젝트 추가
            while (i < n && projects.get(i).capital <= w) {
                maxHeap.add(projects.get(i).profit);
                i++;
            }

            // 자금 조달할 있는 프로젝트가 없는 경우 break
            if (maxHeap.isEmpty()) {
                break;
            }

            // 아닌 경우, 최대 이익 프로젝트 진행
            w += maxHeap.poll();

        }
        return w;
        
    }
}