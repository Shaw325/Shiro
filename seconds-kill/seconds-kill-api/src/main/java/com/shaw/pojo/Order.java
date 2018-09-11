package com.shaw.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

/**
 * @ClassName: Order
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/9/6
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Order {

    private Integer id;

    private Integer sid;

    private String name;

    private Date createTime;
}
