/**
 * 
 */
package com.demo.springboot.manager;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.springboot.model.Department;


/**
 * @description 
 * @author lzq
 * @date 2018年4月8日 下午2:15:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentManagerTest{
    
    @Autowired
    private DepartmentManager departmentManager;

    @Test
    public void testSave(){
        Department department = new Department();
        department.setId(2);
        department.setName("test save");
        department.setDescr("test encache save");
        departmentManager.save(department);
        
    }

    /**
     * Test method for {@link com.demo.springboot.manager.DepartmentManager#update(com.demo.springboot.model.Department)}.
     */
    @Test
    public void testUpdate(){
        Department department = new Department();
        department.setName("test update");
        department.setDescr("test encache update");
        departmentManager.update(department);
    }

    /**
     * Test method for {@link com.demo.springboot.manager.DepartmentManager#getDepartmentById(java.lang.Integer)}.
     */
    @Test
    public void testGetDepartmentById(){
       Department department = departmentManager.getDepartmentById(2);
       if(department!=null)
       System.out.println(department.toString());
    }

    /**
     * Test method for {@link com.demo.springboot.manager.DepartmentManager#delete(java.lang.Integer)}.
     */
    @Test
    public void testDelete(){
        departmentManager.delete(2);
    }

    
    
    @Test
    public void testCache(){
        testGetDepartmentById();
        testDelete();
        testGetDepartmentById();
        testSave();
        testGetDepartmentById();
        testUpdate();
        testGetDepartmentById();
        testGetDepartmentById();
        
    }
}
