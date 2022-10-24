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
@Table(name = "rights")
public class Right {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "right" , cascade = CascadeType.ALL)
    private List<QuanLyQuyen> quanLyQuyenList;

}