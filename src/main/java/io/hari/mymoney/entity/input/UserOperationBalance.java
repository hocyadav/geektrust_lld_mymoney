package io.hari.mymoney.entity.input;

import io.hari.mymoney.constant.ActionType;
import io.hari.mymoney.constant.Month;
import lombok.*;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserOperationBalance extends UserOperation {

    private Month month;

    @Builder
    public UserOperationBalance(@NonNull ActionType operation, @NonNull Month month) {
        super(operation);
        this.month = month;
    }
}
