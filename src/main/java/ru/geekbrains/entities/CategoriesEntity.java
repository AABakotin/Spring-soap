package ru.geekbrains.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "categories")
@Data
public class CategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "categories")
    private List<ProductEntity> products;

}
