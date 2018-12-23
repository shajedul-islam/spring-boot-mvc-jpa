package com.uiu.cdip.springbootmvcjpa.dao;

import com.uiu.cdip.springbootmvcjpa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

}
