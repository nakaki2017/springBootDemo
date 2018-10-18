/**
 * 
 */
package com.demo.springboot.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.demo.springboot.model.Department;

/**
 * @description
 * @author lzq
 * @date 2018年4月13日 下午7:58:57
 */
@Component
public class MongodbManager{

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(Department department){
        this.mongoTemplate.insert(department);
    }

    public void deleteById(int id){
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        this.mongoTemplate.remove(query, Department.class);
    }

    public void update(Department department){
        Criteria criteria = Criteria.where("id").is(department.getId());
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("descr", department.getDescr());
        this.mongoTemplate.updateMulti(query, update, Department.class);
    }

    public Department getById(int id){
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        return this.mongoTemplate.findOne(query, Department.class);
    }

    public List<Department> getAll(){
        List<Department> userList = this.mongoTemplate.findAll(Department.class);
        return userList;
    }
}
