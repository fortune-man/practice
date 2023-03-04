package dfs_bfs;

public class 타겟_넘버_dfs {
    private int answer = 0;
    public int solution(int[] numbers, int target) {
        depthFirstSearch(numbers, target, 0, 0);
        return answer;
    }

    private void depthFirstSearch(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            conditionBranch(target, sum);
            return;
        }

        depthFirstSearch(numbers, target, index+1, sum + numbers[index]);
        depthFirstSearch(numbers, target, index+1, sum - numbers[index]);
    }

    private void conditionBranch(int target, int sum) {
        if (sum == target) {
            answer++;
        }
    }
}
