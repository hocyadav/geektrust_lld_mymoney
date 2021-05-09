package io.hari.mymoney.entity;

import io.hari.mymoney.constant.Month;
import lombok.*;

import java.util.*;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Data
@Builder
public class Portfolio {
    private Double initialEquityPercent;

    private Double initialDeptPercent;

    private Double initialGoldPercent;

    @Builder.Default
    private Map<Month, PortfolioOperation> portfolioOperations = new LinkedHashMap<>();

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class PortfolioOperation {

        @Builder.Default
        private List<PortfolioTransaction> portfolioTransactions = new LinkedList<>();
    }
}
