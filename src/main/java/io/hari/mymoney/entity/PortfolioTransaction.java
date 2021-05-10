package io.hari.mymoney.entity;

import io.hari.mymoney.constant.PortfolioOperationType;
import lombok.*;

import java.math.BigInteger;
import java.util.Optional;

import static io.hari.mymoney.constant.PortfolioOperationType.after_market_change;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Data
@Builder
public class PortfolioTransaction {
    private PortfolioOperationType operation;

    private Asset assets;

    private BigInteger total;

    @Data
    @Builder
    public static class Asset {
        BigInteger equity;

        BigInteger dept;

        BigInteger gold;

        @Override
        public String toString() {
            return equity+" "+dept+" "+gold;
        }
    }

    public BigInteger updateTotal() {
        final BigInteger equity = Optional.ofNullable(assets.equity).orElseGet(() -> BigInteger.ZERO);
        final BigInteger dept = Optional.ofNullable(assets.dept).orElseGet(() -> BigInteger.ZERO);
        final BigInteger gold = Optional.ofNullable(assets.gold).orElseGet(() -> BigInteger.ZERO);
        this.total = equity.add(dept).add(gold);
        return total;
    }


    public static boolean afterMarketChange(PortfolioTransaction i) {
        return i.getOperation().equals(after_market_change);
    }
}
