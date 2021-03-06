package io.hari.mymoney.entity.input;

import io.hari.mymoney.constant.UserOperationType;
import lombok.*;

import java.math.BigInteger;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserOperationALLOCATE extends UserOperation {
    private BigInteger equity;
    private BigInteger dept;
    private BigInteger gold;

    @Builder
    public UserOperationALLOCATE(@NonNull UserOperationType operation,
                                 @NonNull BigInteger equity,
                                 @NonNull BigInteger dept,
                                 @NonNull BigInteger gold) {
        super(operation);
        this.equity = equity;
        this.dept = dept;
        this.gold = gold;
    }
}
