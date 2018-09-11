package com.shaw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: User
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/8/29 18:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class User {

    private Integer id;

    private String name;

    private String password;

    private Set<String> roles = new HashSet<String>();

    private Set<String> permissions = new HashSet<String>();

}
