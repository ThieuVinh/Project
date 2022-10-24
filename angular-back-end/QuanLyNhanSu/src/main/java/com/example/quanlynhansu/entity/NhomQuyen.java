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
@Table(name = "nhom_quyen")
public class NhomQuyen {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "nhomQuyen" , cascade = CascadeType.ALL)
    private List<NhomQuyenMenu> nhomQuyenMenuList;

}