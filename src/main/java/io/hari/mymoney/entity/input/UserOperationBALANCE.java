package io.hari.mymoney.entity.input;

import io.hari.mymoney.constant.UserOperationType;
import io.hari.mymoney.constant.Month;
import lombok.*;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserOperationBALANCE extends UserOperation {
    private Month month;

    @Builder
    public UserOperationBALANCE(@NonNull UserOperationType operation, @NonNull Month month) {
        super(operation);
        this.month = month;
    }
}
