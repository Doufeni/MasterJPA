package com.hibernate.materJpa.repositories;

import com.hibernate.materJpa.entitiesWithHibernate.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {


}
