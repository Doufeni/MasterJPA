package com.hibernate.materJpa.repositories;

import com.hibernate.materJpa.entitiesWithHibernate.PublishingHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, Long> {


    public PublishingHouse findPublishingHouseById(Long id);
}

