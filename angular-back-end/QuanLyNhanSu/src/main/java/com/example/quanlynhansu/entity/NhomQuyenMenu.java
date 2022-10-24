package com.example.quanlynhansu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nhom_quyen_menu")
public class NhomQuyenMenu {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "nhom_quyen_id", nullable = false)
    private NhomQuyen nhomQuyen;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;

    @JsonIgnore
    @OneToMany(mappedBy = "nhomQuyenMenu" , cascade = CascadeType.ALL)
    private List<QuanLyQuyen> quanLyQuyenList;

}