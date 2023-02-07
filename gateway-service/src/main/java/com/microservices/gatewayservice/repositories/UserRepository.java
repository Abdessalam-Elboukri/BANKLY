package com.microservices.gatewayservice.repositories;

import com.microservices.gatewayservice.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
