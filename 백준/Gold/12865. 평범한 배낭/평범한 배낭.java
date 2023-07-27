import java.util.*;

public class Main{
    
    // 클린코드 원칙 : 간결하고 명확한 단어 사용
    static int itemCount, maxWeight;
    static int[] itemWeights, itemValues;
    static Integer[][] memoization;
    
    public static void main(String[] args) {
        initialize(); // 메서드 분리로 가독성 개선
        System.out.println(calculateMaxValue());
    }
    
    // 사용자 입력 처리
    private static void initialize() {
        Scanner scanner = new Scanner(System.in);
        itemCount = scanner.nextInt();
        maxWeight = scanner.nextInt();
        
        
        itemWeights = new int[itemCount];
        itemValues = new int[itemCount];
        memoization = new Integer[itemCount][maxWeight + 1];
        
        for (int i = 0; i < itemCount; i++) {
            itemWeights[i] = scanner.nextInt();
            itemValues[i] = scanner.nextInt();
        }
        
        scanner.close();
    }
    
    private static int calculateMaxValue() {
        return getMaximumValue(itemCount - 1, maxWeight);
    }
    
    // 메모이제이션 기법으로 중복 계산 제거
    // 객체지향 체조 원칙 : "한 메서드에 오직 1 indent"
    private static int getMaximumValue(int itemIndex, int remainingWeight) {
        if (itemIndex < 0) return 0;
        if (memoization[itemIndex][remainingWeight] == null)
            memoization[itemIndex][remainingWeight] = calculateMemoization(itemIndex, remainingWeight);
        
        return Math.max(memoization[itemIndex][remainingWeight], getMaximumValue(itemIndex-1, remainingWeight));
    }
    
    // 가방에 넣을 수 있는 물건이면 물건의 가치를 계산하고, 그렇지 않으면 0 return
    private static int calculateMemoization(int itemIndex, int remainingWeight) {
        if (itemWeights[itemIndex] > remainingWeight)
            return 0;
        
        return getMaximumValue(itemIndex-1, remainingWeight-itemWeights[itemIndex]) + itemValues[itemIndex];
    }
    
}