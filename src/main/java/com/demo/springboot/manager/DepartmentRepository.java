/**
 * 
 */
package com.demo.springboot.manager;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.springboot.model.Department;

/**
 * @description 
 * @author lzq
 * @date 2018年4月13日 下午8:02:23
 */
public interface DepartmentRepository extends MongoRepository<Department, Integer> {
}