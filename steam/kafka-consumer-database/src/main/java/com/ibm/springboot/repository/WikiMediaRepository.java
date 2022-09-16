package com.ibm.springboot.repository;

import com.ibm.springboot.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaRepository extends JpaRepository<WikimediaData, Long> {

}
