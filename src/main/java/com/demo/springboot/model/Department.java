/**
 * 
 */
package com.demo.springboot.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 
 * @author lzq
 * @date 2018年4月7日 上午1:20:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable{
    private static final long serialVersionUID = 6067283535977178571L;
    private Integer id;
    
    private String name;
    
    private String descr;
}