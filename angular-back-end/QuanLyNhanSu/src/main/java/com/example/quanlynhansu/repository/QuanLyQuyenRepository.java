package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.entity.QuanLyQuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuanLyQuyenRepository extends JpaRepository<QuanLyQuyen, Integer> {
    @Query("select qlq from QuanLyQuyen qlq where qlq.nhomQuyenMenu.id =:id")
    List<QuanLyQuyen> getByIdQlqAndNQMM(Integer id);

    @Modifying
    @Transactional
    @Query("delete from QuanLyQuyen qlq where qlq.nhomQuyenMenu.id =:id and qlq.right.id =:idMang")
    void deleteById(@Param("id") Integer id, @Param("idMang") Integer idMang);
}
