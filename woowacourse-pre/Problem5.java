package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return takeLeastMoney(money);
    }

    // 최소한의 개수로 화폐를 출금하라
    private static List<Integer> takeLeastMoney(int money) {
        List<Integer> moneyList = new ArrayList<>();

        for (CurrencyUnit unit : CurrencyUnit.descendingOrder()) {
            int unitCount = money / unit.value;
            moneyList.add(unitCount);
            money = money - (unitCount * unit.value);
        }

        return moneyList;
    }

    // 화폐 단위를 관리하는 enum
    enum CurrencyUnit {
        WON_50000(50000),
        WON_10000(10000),
        WON_5000(5000),
        WON_1000(1000),
        WON_500(500),
        WON_100(100),
        WON_50(50),
        WON_10(10),
        WON_1(1);

        int value;

        CurrencyUnit(int value) {
            this.value = value;
        }

        // 화페 객체를 높은 금액부터 순서대로 반환하라
        public static List<CurrencyUnit> descendingOrder() {
            return Arrays.stream(values())
                    .sorted(((o1, o2) -> o2.value - o1.value))
                    .collect(Collectors.toList());
        }
    }
}
