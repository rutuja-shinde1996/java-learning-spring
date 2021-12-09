package com.learning.spring.data.repository;

import com.learning.spring.data.entity.Guest;
import com.learning.spring.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long>{

}
