/**
 * 
 */
package com.demo.springboot.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.model.Role;

/**
 * @description 
 * @author lzq
 * @date 2018年4月7日 上午12:12:39
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
}
