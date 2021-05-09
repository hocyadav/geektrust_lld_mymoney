package io.hari.mymoney.constant;

import lombok.Getter;
import lombok.ToString;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Getter
@ToString
public enum ActionType {
    allocate,
    sip,
    change,
    balance,
    rebalance;
}
