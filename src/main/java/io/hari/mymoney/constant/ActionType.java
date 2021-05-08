package io.hari.mymoney.constant;

import lombok.Getter;
import lombok.ToString;

/**
 * @Author hayadav
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
