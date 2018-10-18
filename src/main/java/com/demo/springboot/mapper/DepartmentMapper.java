/**
 * 
 */
package com.demo.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.demo.springboot.model.Department;

/**
 * @description 
 * 注意：Mapper 接口要添加 @Mapper 注解
 * 还要修改xml
 * mybatis/mapper/departmentMapper.xml
 * @author lzq
 * @date 2018年4月7日 上午1:36:51
 */
@Mapper
public interface DepartmentMapper {
    public void insert(Department department);
    
    public Department getById(Integer id);
    
    public void update(Department department);
    
    public void deleteById(Integer id);
}