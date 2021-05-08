package io.hari.mymoney.service;

import io.hari.mymoney.constant.ActionType;
import io.hari.mymoney.entity.Portfolio;
import io.hari.mymoney.entity.input.UserOperation;
import io.hari.mymoney.entity.input.UserOperationBalance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.hari.mymoney.constant.ActionType.balance;
import static io.hari.mymoney.constant.ActionType.rebalance;

/**
 * @Author hayadav
 * @create 5/8/2021
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final PortfolioService portfolioService;

    public void executeUserBALANCE_REBALANCEOperations(List<UserOperation> userOperations, Portfolio portfolio) {
        userOperations.stream().filter(i -> i.getOperation().equals(balance) || i.getOperation().equals(rebalance)).forEach(i -> {
            final ActionType operation = i.getOperation();
            final UserOperation i1 = i;
            if (operation.equals(balance)) {
                final UserOperationBalance userOperationBalance = UserOperationBalance.class.cast(i1);
                System.out.println(portfolioService.getBalanceOperation(portfolio, userOperationBalance.getMonth()));
            } else if (operation.equals(rebalance)) {
                System.out.println(portfolioService.getReBalanceOperation(portfolio));
            }
        });
    }
}
