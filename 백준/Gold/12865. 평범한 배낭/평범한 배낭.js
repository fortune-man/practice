// Readable Stream에서 한 번에 한 줄 씩 데이터를 읽기 위한 인터페이스를 제공하는 모듈
const readline = require('readline');

// 노드의 기본 입력 스트림을 사용하여 readline 인터페이스 생성
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let lines = [];
rl.on('line', (line) => lines.push(line));

rl.on('close', () => {
    const [numItems, capacity] = lines[0].split(' ').map(Number);
    const items = lines.slice(1).map(line => line.split(' ').map(Number));
    console.log(knapsackProblem(numItems, capacity, items));
});

// 주어진 항목들에 대해 배낭 문제를 해결하는 함수
function knapsackProblem(numItems, capacity, items) {
    // 메모이제이션 배열 초기화: 각 항목과 가능한 모든 무게에 대한 최대 가치를 저장하기 위한 2차원 배열
    const memoization = Array.from(Array(numItems + 1), () => Array(capacity + 1).fill(0));

    // 동적 프로그래밍: 각 항목을 순회하면서 배낭에 넣을 수 있는 최대 가치 계산
    for (let i = 1; i <= numItems; i++) {
        computeMaxValue(memoization, items, i, capacity);
    }

    // 결과 반환: 모든 항목과 주어진 배낭의 무게에 대한 최대 가치를 반환
    return memoization[numItems][capacity];
}

// 메모이제이션 배열을 계산하는 함수
function computeMaxValue(memoization, items, i, capacity) {
    const [weight, value] = items[i - 1];
    
    for (let j = 0; j <= capacity; j++) {
        // 현재 항목의 무게가 j보다 크다면, 이전 항목의 최대 가치를 그대로 사용
        memoization[i][j] = memoization[i - 1][j];
        if (weight <= j) {
            // 현재 항목을 배낭에 넣을 수 있다면, 이전 항목의 최대 가치와 현재 항목의 가치 + 현재 항목의 무게를 뺀 무게의 최대 가치 중 큰 값을 선택
            memoization[i][j] = Math.max(memoization[i][j], memoization[i - 1][j - weight] + value);
        }
    }
}
