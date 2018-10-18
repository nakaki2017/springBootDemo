/**
 * 
 */
package com.demo.springboot.manager;

import com.demo.springboot.model.Department;

/**
 * @description 
 * @author lzq
 * @date 2018年4月4日 下午8:15:46
 */
public interface DepartmentManager {
    public Department save(Department department);
    
    public Department update(Department department);
    
    public Department getDepartmentById(Integer id);
    
    public void delete(Integer id);
}