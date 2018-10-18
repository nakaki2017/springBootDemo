/**
 * 
 */
package com.demo.springboot.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 
 * 
 * lombok使用         自动生成Getter/Setter方法
 * @NoArgsConstructor: 自动生成无参数构造函数。
 * @AllArgsConstructor: 自动生成全参数构造函数。
 * @Data: 自动为所有字段添加@ToString, @EqualsAndHashCode, @Getter方法，为非final字段添加@Setter,和@RequiredArgsConstructor!
 * @author lzq
 * @date 2018年4月4日 下午4:14:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable{
    
    
    private static final long serialVersionUID = 6328650732875795716L;

    private Integer id;
    
    private String username;
    
    private String password;
    
    //fastjson注解
    @JSONField(format="yyyy-MM-dd")
    private Date birthday;

}
