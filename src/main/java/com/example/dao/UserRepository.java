package com.example.dao;

import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 * 作者： terry
 * 日期： 2023/2/25 14:40
 **/

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user where name like %?1%", nativeQuery = true)
    Page<User> findByNameLike(String name, Pageable pageRequest);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    User findByUsername(@Param("name") String name);
}
