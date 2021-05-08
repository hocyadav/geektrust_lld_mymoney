package io.hari.mymoney.entity;

import io.hari.mymoney.constant.Month;
import lombok.*;

import java.util.*;

/**
 * @Author hayadav
 * @create 5/8/2021
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portfolio {
    private Double initialEquityPercent;

    private Double initialDeptPercent;

    private Double initialGoldPercent;

    @Builder.Default
    Map<Month, PortfolioOperation> portfolioOperations = new LinkedHashMap<>();

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PortfolioOperation {

        @Builder.Default
        List<PortfolioTransaction> portfolioTransactions = new LinkedList<>();
    }
}
