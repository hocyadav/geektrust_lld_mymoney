package io.hari.mymoney.entity.input;

import io.hari.mymoney.constant.UserOperationType;
import lombok.*;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserOperationReBalance extends UserOperation {

    @Builder
    public UserOperationReBalance(@NonNull UserOperationType operation) {
        super(operation);
    }
}
