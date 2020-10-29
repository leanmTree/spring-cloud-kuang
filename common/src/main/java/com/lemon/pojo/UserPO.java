package com.lemon.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:14
 **/
@Data
@Accessors(chain = true)
public class UserPO implements Serializable {
    private Integer id;
    private String name;
    private String phone;
    private String source;
}
