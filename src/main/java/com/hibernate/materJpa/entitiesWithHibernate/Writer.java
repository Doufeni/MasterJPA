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
@Table(name="writer")
public class Writer {

  @Id
  @GeneratedValue
  private Long Id;

  private String name;

  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(
          name = "writer_book",
          joinColumns = @JoinColumn(name = "writer_id"))
  private List<Book> books;

  public Writer(String name, List<Book> books) {
    this.name = name;
    this.books = books;
  }
}
