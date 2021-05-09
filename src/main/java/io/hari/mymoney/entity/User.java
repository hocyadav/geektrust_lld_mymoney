package io.hari.mymoney.entity;


import io.hari.mymoney.constant.UserType;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
    @NotNull
    String name;

    @NotNull
    UserType type;

    @Builder.Default
    List<Portfolio> portfolios = new LinkedList<>();
}
