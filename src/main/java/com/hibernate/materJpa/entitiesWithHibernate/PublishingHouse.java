package com.hibernate.materJpa.entitiesWithHibernate;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })

public class PublishingHouse {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String name;

    @OneToMany(mappedBy="publishingHouse")
    List<Book> books;


    public PublishingHouse(String name, List<Book> books) {
        this.name = name;
        this.books = books;

    }

    public PublishingHouse(String name) {
        this.name = name;
    }
}
