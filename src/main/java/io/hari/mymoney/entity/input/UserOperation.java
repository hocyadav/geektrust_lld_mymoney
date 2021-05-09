package io.hari.mymoney.entity.input;

import io.hari.mymoney.constant.UserOperationType;
import lombok.Getter;
import lombok.ToString;

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
}
