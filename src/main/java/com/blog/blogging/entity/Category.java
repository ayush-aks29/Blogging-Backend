package com.blog.blogging.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @SequenceGenerator(name = "categoryId", sequenceName = "categoryIdSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryId")
    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;

}
