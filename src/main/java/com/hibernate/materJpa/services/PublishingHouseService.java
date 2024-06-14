package com.hibernate.materJpa.services;


import com.hibernate.materJpa.entitiesWithHibernate.PublishingHouse;
import org.springframework.stereotype.Service;

@Service
public interface PublishingHouseService {

    public PublishingHouse savePublishingHouse();
    public PublishingHouse findPublishingHouseById(Long id);

}
