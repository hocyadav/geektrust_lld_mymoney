package io.hari.mymoney.entity.input;

import io.hari.mymoney.constant.UserOperationType;
import lombok.Getter;
import lombok.ToString;

import static io.hari.mymoney.constant.UserOperationType.*;
import static io.hari.mymoney.constant.UserOperationType.rebalance;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Getter
@ToString
public abstract class UserOperation {
    private UserOperationType operation;

    public UserOperation(final UserOperationType operation) {
        this.operation = operation;
    }

    public static boolean isALLOCATE(UserOperation i) {
        return i.getOperation().equals(allocate);
    }

    public static boolean isCHANGE(UserOperation i) {
        return i.getOperation().equals(change);
    }

    public static boolean isBALANCE_or_REBALANCE(UserOperation i) {
        return i.getOperation().equals(balance) ||
                i.getOperation().equals(rebalance);
    }

}
