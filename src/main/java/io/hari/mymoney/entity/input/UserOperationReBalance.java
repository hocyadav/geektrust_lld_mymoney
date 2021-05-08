package io.hari.mymoney.entity.input;

import io.hari.mymoney.constant.ActionType;
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
public class UserOperationReBalance extends UserOperation {

    @Builder
    public UserOperationReBalance(ActionType operation) {
        super(operation);
    }
}
