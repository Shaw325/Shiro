package com.shaw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: Stock
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/9/6
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Stock {
    private static final long serialVersionUID = -8437012513227627973L;

    private Integer id;

    private String name;

    private Integer count;

    private Integer sale;

    private Integer version;

}
