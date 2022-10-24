package com.example.quanlynhansu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "menu" , cascade = CascadeType.ALL)
    private List<MenuItem> menuItemList;
}