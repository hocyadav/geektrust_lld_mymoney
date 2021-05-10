package io.hari.mymoney.service;

import io.hari.mymoney.entity.Portfolio;
import io.hari.mymoney.entity.input.UserOperation;
import io.hari.mymoney.entity.input.UserOperationBALANCE;
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

    public void executeUserBALANCE_REBALANCEOperations(final Portfolio portfolio,
                                                       final List<UserOperation> userOperations) {
        userOperations.stream().filter(Objects::nonNull)
                .filter(UserOperation::equalToBalanceORReBalance)
                .forEach(userOperation -> {
                    if (userOperation.getOperation().equals(balance)) {
                        final UserOperationBALANCE userOperationBalance = UserOperationBALANCE.class.cast(userOperation);
                        System.out.println(
                                portfolioService.getBALANCEOperation(portfolio, userOperationBalance.getMonth())
                        );
                    } else if (userOperation.getOperation().equals(rebalance)) {
                        System.out.println(portfolioService.getReBALANCEOperation(portfolio));
                    }
                });
    }
}
