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
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;
    private Integer numPage;

    @ManyToMany(mappedBy = "books")
    private List<Writer> writers;

    @ManyToOne
    @JoinColumn(name="publishingHouse_id")
    private PublishingHouse publishingHouse;

    @OneToOne(fetch = FetchType.LAZY)
    //@MapsId
    @JoinColumn(name = "review_id")
    private Review review;

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, Integer numPage) {
        this.name = name;
        this.numPage = numPage;
    }
}
