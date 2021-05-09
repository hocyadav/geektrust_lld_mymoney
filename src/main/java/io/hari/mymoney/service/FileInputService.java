package io.hari.mymoney.service;

import io.hari.mymoney.constant.ActionType;
import io.hari.mymoney.constant.Month;
import io.hari.mymoney.entity.input.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

import static io.hari.mymoney.constant.ActionType.rebalance;
import static io.hari.mymoney.constant.ConstantUtil.INVALID_OPERATION;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Service
@Slf4j
public class FileInputService {

    public void readInputFile(List<UserOperation> abstracts, String line) {
        if (line.contains(ActionType.allocate.name()))
            abstracts.add(allocateOperation(line));

        else if (line.contains(ActionType.sip.name()))
            abstracts.add(sipOperation(line));

        else if (line.contains(ActionType.change.name()))
            abstracts.add(changeOperation(line));

        else if (line.contains(rebalance.name()))
            abstracts.add(UserOperationReBalance.builder().operation(rebalance).build());

        else if (line.contains(ActionType.balance.name())) {
            final String[] tokens = line.split(" ");
            final UserOperationBalance operationBalance = UserOperationBalance.builder().operation(ActionType.balance)
                    .month(Month.valueOf(tokens[1].toLowerCase()))
                    .build();
            abstracts.add(operationBalance);
        } else throw new RuntimeException("invalid operation");
    }

    public UserOperationChange changeOperation(@NonNull final String operation) {
        validateOperation(operation, 5);
        final String[] tokens = operation.split(" ");
        final UserOperationChange operationChange = UserOperationChange.builder()
                .operation(ActionType.change)
                .equityPercent(tokens[1])
                .deptPercent(tokens[2])
                .goldPercent(tokens[3])
                .month(tokens[4])
                .build();
        log.info("Operation [{}]    ,   input [{}]", operationChange.getOperation().name().toUpperCase(), operation);
        return operationChange;
    }

    public UserOperationAllocate allocateOperation(@NonNull final String operation) {
        validateOperation(operation, 4);
        final String[] tokens = operation.split(" ");
        final UserOperationAllocate operationAllocate = UserOperationAllocate.builder()
                .operation(ActionType.allocate)
                .equity(new BigInteger(tokens[1]))
                .dept(new BigInteger(tokens[2]))
                .gold(new BigInteger(tokens[3]))
                .build();
        log.info("Operation [{}]    ,   input [{}]", operationAllocate.getOperation().name().toUpperCase(), operation);
        return operationAllocate;
    }

    public UserOperationSIP sipOperation(@NonNull final String operation) {
        validateOperation(operation, 4);
        final String[] tokens = operation.split(" ");
        final UserOperationSIP operationSIP = UserOperationSIP.builder()
                .operation(ActionType.sip)
                .equity(new BigInteger(tokens[1]))
                .dept(new BigInteger(tokens[2]))
                .gold(new BigInteger(tokens[3]))
                .build();
        log.info("Operation [{}]    ,   input [{}]", operationSIP.getOperation().name().toUpperCase(), operation);
        return operationSIP;
    }


    private void validateOperation(@NonNull final String operation, final int length) {
        if (operation.split(" ").length < length) {
            log.info(INVALID_OPERATION + " :[{}]", operation);
            throw new RuntimeException(INVALID_OPERATION + " : " + operation);
        }
    }
}
