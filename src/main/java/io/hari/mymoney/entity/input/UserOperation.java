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

    public static boolean allocate(UserOperation i) {
        return i.getOperation().equals(allocate);
    }

    public static boolean change(UserOperation i) {
        return i.getOperation().equals(change);
    }

    public static boolean equalToBalanceORReBalance(UserOperation i) {
        return i.getOperation().equals(balance) ||
                i.getOperation().equals(rebalance);
    }

}
