/**
 * 
 */
package com.demo.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 
 * @author lzq
 * @date 2018年4月6日 下午11:57:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role implements Serializable{
    private static final long serialVersionUID = 3926276668667517847L;
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column
    private String name;
    
    @Column
    private String descr;
}