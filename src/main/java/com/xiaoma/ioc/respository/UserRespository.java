package com.xiaoma.ioc.respository;

import com.xiaoma.ioc.pra2.User;
import lombok.Data;

import java.util.Collection;

/**
 * @Author: Tang dandan
 * @Date: 2020/1/29 20:13
 */
@Data
public class UserRespository {
    private Collection<User> users;
}
