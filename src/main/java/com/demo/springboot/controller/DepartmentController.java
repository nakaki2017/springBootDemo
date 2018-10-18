/**
 * 
 */
package com.demo.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.springboot.manager.DepartmentManager;
import com.demo.springboot.model.Department;

/**
 * @description 
 * @author lzq
 * @date 2018年4月8日 下午2:12:03
 */
@Controller
@RequestMapping("department")
@ResponseBody
public class DepartmentController {
    @Autowired
    private DepartmentManager departmentManager;
    
    @RequestMapping("save")
    public Map<String,Object> save(Department department) {
        this.departmentManager.save(department);
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "保存成功");
        return map;
    }
    
    @RequestMapping("get/{id}")
    public Map<String,Object> get(@PathVariable("id") Integer id) {
        Department department = this.departmentManager.getDepartmentById(id);
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "获取成功");
        map.put("data", department);
        return map;
    }
    
    @RequestMapping("update")
    public Map<String,Object> update(Department department) {
        this.departmentManager.update(department);
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "修改成功");
        return map;
    }
    
    @RequestMapping("delete/{id}")
    public Map<String,Object> delete(@PathVariable("id") Integer id) {
        this.departmentManager.delete(id);
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "删除成功");
        return map;
    }
}