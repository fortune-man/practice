// 사용자 입력 처리 && 문자열과 배열 다루기 위해 다양한 기본 인터페이스 제공하는 foundation 프레임워크 사용
import Foundation

func getInputs() -> (n: Int, k: Int, items: [(Int, Int)]) {
    let nk = readLine()!.split(separator: " ").map { Int($0)! }
    var items = [(0, 0)]
    for _ in 0..<nk[0] {
        let item = readLine()!.split(separator: " ").map { Int($0)! }
        items.append((item[0], item[1]))
    }
    return (nk[0], nk[1], items)
}

func initializeDPTable(n: Int, k: Int) -> [[Int]] {
    var dp = [[Int]](repeating: [Int](repeating: 0, count: k + 1), count: n + 1)
    return dp
}

func computeMaximumValue(n: Int, k: Int, items: [(Int, Int)], dp: inout [[Int]]) -> Int {
    for i in 1...n {
        for j in 1...k {
            if j >= items[i].0 {
                dp[i][j] = max(dp[i-1][j], dp[i-1][j - items[i].0] + items[i].1)
            } else {
                dp[i][j] = dp[i-1][j]
            }
        }
    }
    return dp[n][k]
}

func main() {
    let inputs = getInputs()
    var dp = initializeDPTable(n : inputs.n, k: inputs.k)
    let maxVal = computeMaximumValue(n: inputs.n, k: inputs.k, items: inputs.items, dp: &dp)
    print(maxVal)
}

main()