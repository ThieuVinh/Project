package com.example.quanlynhansu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quan_ly_quyen")
public class QuanLyQuyen {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "right_id", nullable = false)
    private Right right;

    @ManyToOne
    @JoinColumn(name = "nhom_quyen_menu_id", nullable = false)
    private NhomQuyenMenu nhomQuyenMenu;


}