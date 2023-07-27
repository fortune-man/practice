import java.util.*
import kotlin.math.max

// 물건의 무게와 가치를 나타내는 데이터 클래스
data class Item(val weight: Int, val value: Int)

fun main() {
    // 사용자 입력 초기화
    val (itemCount, maxWeight, items) = initialize()
    
    // 동적 프로그래밍을 통해 최대 가치 계산
    val maxValue = getMaxValue(itemCount, maxWeight, items)
    
    // 최대 가치 출력
    println(maxValue)
}

// 사용자 입력을 받아 초기화하는 함수
fun initialize(): Triple<Int, Int, Array<Item>> {
    // 사용자 입력
    val scanner = Scanner(System.`in`)
    // 물건 개수 입력
    val itemCount = scanner.nextInt()
    // 최대 무게 입력
    val maxWeight = scanner.nextInt()
    // 정보 저장 데이터베이스 생성
    val items = Array(itemCount + 1) { Item(0,0) }
    
    // 사용자로부터 각 물건의 무게와 가치 입력 받기
    for (i in 1..itemCount) {
        val weight = scanner.nextInt()
        val value = scanner.nextInt()
        // 물건의 무게와 가치를 items 배열에 저장
        items[i] = Item(weight, value)
    }
    
    // 초기화된 값들을 반환
    return Triple(itemCount, maxWeight, items)
}

// 동적 프로그래밍을 통해 최대 가치를 계산하는 함수
fun getMaxValue(itemCount: Int, maxWeight: Int, items: Array<Item>): Int {
    // 동적 프로그래밍을 위한 DP 테이블 생성
    val dp = Array(itemCount + 1){ IntArray(maxWeight + 1)}
    
    // 각 물건에 대해 동적 프로그래밍 수행
    for (i in 1..itemCount) {
        val (currentWeight, currentValue) = items[i]
        
        for (j in 0..maxWeight) {
            dp[i][j] = if (j < currentWeight) {
                // 현재 물건을 배낭에 넣을 수 없는 경우
                // 이전 물건까지의 최대 가치를 그대로 조회
                dp[i-1][j]
            } else {
                max(dp[i-1][j], dp[i-1][j-currentWeight] + currentValue)
            }
        }
    }
    
    // 최대 가치 반환
    return dp[itemCount][maxWeight]
}