package io.hari.mymoney.entity.input;

import io.hari.mymoney.constant.ActionType;
import io.hari.mymoney.constant.Month;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author hayadav
 * @create 5/8/2021
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserOperationBalance extends UserOperation {

    private Month month;

    @Builder
    public UserOperationBalance(ActionType operation, Month month) {
        super(operation);
        this.month = month;
    }
}
