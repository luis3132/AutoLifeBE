package com.autolife.autolife.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolife.autolife.persistence.entity.Duenos;
import com.autolife.autolife.persistence.entity.DuenosPK;

public interface DuenosRepository  extends JpaRepository<Duenos, DuenosPK> {
    
}
