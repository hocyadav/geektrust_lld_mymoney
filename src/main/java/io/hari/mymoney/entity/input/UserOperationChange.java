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
public class UserOperationChange extends UserOperation {
    private Double equityPercent;
    private Double deptPercent;
    private Double goldPercent;
    private Month month;

    @Builder
    public UserOperationChange(@NonNull UserOperationType operation,
                               @NonNull String equityPercent,
                               @NonNull String deptPercent,
                               @NonNull String goldPercent,
                               @NonNull String month) {
        super(operation);
        this.equityPercent = Double.valueOf(equityPercent.replace("%", ""));
        this.deptPercent = Double.valueOf(deptPercent.replace("%", ""));
        this.goldPercent = Double.valueOf(goldPercent.replace("%", ""));
        this.month = Month.valueOf(month.toLowerCase());
    }
}
