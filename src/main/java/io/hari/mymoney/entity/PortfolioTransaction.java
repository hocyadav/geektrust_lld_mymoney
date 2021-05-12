package io.hari.mymoney.entity;

import io.hari.mymoney.constant.PortfolioOperationType;
import lombok.*;

import java.math.BigInteger;
import java.util.Optional;

import static io.hari.mymoney.constant.PortfolioOperationType.AFTER_MARKET_CHANGE;

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
        final BigInteger equityValue = Optional.ofNullable(assets.getEquity()).orElseGet(() -> BigInteger.ZERO);
        final BigInteger deptValue = Optional.ofNullable(assets.getDept()).orElseGet(() -> BigInteger.ZERO);
        final BigInteger goldValue = Optional.ofNullable(assets.getGold()).orElseGet(() -> BigInteger.ZERO);
        this.total = equityValue
                .add(deptValue)
                .add(goldValue);
//        this.total = Optional.ofNullable(assets.getEquity()).orElseGet(() -> BigInteger.ZERO)
//                .add(Optional.ofNullable(assets.getDept()).orElseGet(() -> BigInteger.ZERO))
//                .add(Optional.ofNullable(assets.getGold()).orElseGet(() -> BigInteger.ZERO));
        return total;
    }


    public static boolean afterMarketChange(PortfolioTransaction i) {
        return i.getOperation().equals(AFTER_MARKET_CHANGE);
    }
}
