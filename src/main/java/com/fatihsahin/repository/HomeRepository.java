package com.fatihsahin.repository;

import com.fatihsahin.entites.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository  extends JpaRepository<Home,Long> {
}
