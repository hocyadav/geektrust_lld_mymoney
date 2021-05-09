package io.hari.mymoney.entity.input;

import io.hari.mymoney.constant.ActionType;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Getter
@ToString
public abstract class UserOperation {
    private ActionType operation;

    public UserOperation(final ActionType operation) {
        this.operation = operation;
    }
}
