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
@Table(name = "menu_item")
public class MenuItem {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "menuItem" , cascade = CascadeType.ALL)
    private List<NhomQuyenMenu> nhomQuyenMenuList;

}