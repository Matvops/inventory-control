package com.cadenassi.inventory_control.repositories;

import com.cadenassi.inventory_control.model.person.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
