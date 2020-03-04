package com.xiaoma.ioc.pra2;

import com.xiaoma.ioc.annotation.Super;
import lombok.Data;

/**
 * @Author: Tang dandan
 * @Date: 2020/1/29 17:12
 */
@Super
@Data
public class SuperUser extends User {
    private String address;
}
