package com.example.demo.mapper;

import com.example.demo.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

  List<User> selectAll();

  User select(int id);

  int insert(User user);

  int update(User user);

  int delete(int id);

}

