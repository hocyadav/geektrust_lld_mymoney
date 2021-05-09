package io.hari.mymoney.service;

import io.hari.mymoney.entity.Portfolio;
import io.hari.mymoney.entity.input.UserOperation;
import io.hari.mymoney.entity.input.UserOperationBalance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static io.hari.mymoney.constant.UserOperationType.balance;
import static io.hari.mymoney.constant.UserOperationType.rebalance;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final PortfolioService portfolioService;

    public void executeUserBALANCE_REBALANCEOperations(final List<UserOperation> userOperations,
                                                       final Portfolio portfolio) {
        userOperations.stream().filter(Objects::nonNull)
                .filter(i -> i.getOperation().equals(balance) || i.getOperation().equals(rebalance))
                .forEach(userOperation -> {
                    if (userOperation.getOperation().equals(balance)) {
                        final UserOperationBalance userOperationBalance = UserOperationBalance.class.cast(userOperation);
                        System.out.println(
                                portfolioService.getBALANCEOperation(portfolio, userOperationBalance.getMonth())
                        );
                    } else if (userOperation.getOperation().equals(rebalance)) {
                        System.out.println(portfolioService.getReBALANCEOperation(portfolio));
                    }
                });
    }
}
