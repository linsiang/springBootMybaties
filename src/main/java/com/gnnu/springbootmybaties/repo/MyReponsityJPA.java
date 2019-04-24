package com.gnnu.springbootmybaties.repo;

import com.gnnu.springbootmybaties.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyReponsityJPA extends JpaRepository<User,Integer> {

}
