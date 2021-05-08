package io.hari.mymoney.entity.input;

import io.hari.mymoney.constant.ActionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

/**
 * @Author hayadav
 * @create 5/8/2021
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserOperationAllocate extends UserOperation {

    private BigInteger equity;
    private BigInteger dept;
    private BigInteger gold;

    @Builder
    public UserOperationAllocate(ActionType operation, BigInteger equity, BigInteger dept, BigInteger gold) {
        super(operation);
        this.equity = equity;
        this.dept = dept;
        this.gold = gold;
    }
}
