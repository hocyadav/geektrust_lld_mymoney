package io.hari.mymoney.service;

import io.hari.mymoney.constant.Month;
import io.hari.mymoney.entity.input.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

import static io.hari.mymoney.constant.UserOperationType.*;
import static io.hari.mymoney.constant.ConstantUtil.INVALID_OPERATION;
import static io.hari.mymoney.constant.ConstantUtil.SPACE_REGEX;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Service
@Slf4j
public class FileInputService {

    public void readInputFile(List<UserOperation> userOperations, String operation) {
        if (operation.contains(allocate.name()))
            userOperations.add(getALLOCATEOperation(operation));

        else if (operation.contains(sip.name()))
            userOperations.add(getSIPOperation(operation));

        else if (operation.contains(change.name()))
            userOperations.add(getCHANGEOperation(operation));

        else if (operation.contains(rebalance.name()))
            userOperations.add(UserOperationREBALANCE.builder().operation(rebalance).build());

        else if (operation.contains(balance.name())) {
            final String[] tokens = operation.split(" ");
            final UserOperationBALANCE operationBALANCE = UserOperationBALANCE.builder().operation(balance)
                    .month(Month.valueOf(tokens[1].toLowerCase()))
                    .build();
            userOperations.add(operationBALANCE);
        } else throw new RuntimeException("invalid operation");
    }

    public UserOperationCHANGE getCHANGEOperation(@NonNull final String operation) {
        validateUserOperation(operation, 5);
        final String[] tokens = operation.split(" ");
        final UserOperationCHANGE userOperation = UserOperationCHANGE.builder()
                .operation(change)
                .equityPercent(tokens[1])
                .deptPercent(tokens[2])
                .goldPercent(tokens[3])
                .month(tokens[4])
                .build();
        log.info("Operation [{}]    ,   input [{}]", userOperation.getOperation().name().toUpperCase(), operation);
        return userOperation;
    }

    public UserOperationALLOCATE getALLOCATEOperation(@NonNull final String operation) {
        validateUserOperation(operation, 4);
        final String[] tokens = operation.split(" ");
        final UserOperationALLOCATE userOperation = UserOperationALLOCATE.builder()
                .operation(allocate)
                .equity(new BigInteger(tokens[1]))
                .dept(new BigInteger(tokens[2]))
                .gold(new BigInteger(tokens[3]))
                .build();
        log.info("Operation [{}]    ,   input [{}]", userOperation.getOperation().name().toUpperCase(), operation);
        return userOperation;
    }

    public UserOperationSIP getSIPOperation(@NonNull final String operation) {
        validateUserOperation(operation, 4);
        final String[] tokens = operation.split(" ");
        final UserOperationSIP userOperation = UserOperationSIP.builder()
                .operation(sip)
                .equity(new BigInteger(tokens[1]))
                .dept(new BigInteger(tokens[2]))
                .gold(new BigInteger(tokens[3]))
                .build();
        log.info("Operation [{}]    ,   input [{}]", userOperation.getOperation().name().toUpperCase(), operation);
        return userOperation;
    }


    private void validateUserOperation(@NonNull final String operation, final int requiredTokenLength) {
        if (operation.split(SPACE_REGEX).length < requiredTokenLength) {
            log.info(INVALID_OPERATION + " :[{}]", operation);
            throw new RuntimeException(INVALID_OPERATION + " : " + operation);
        }
    }
}
