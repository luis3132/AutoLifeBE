package com.AutoLifeBE.AutoLifeBE.persistence.repository;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface SeguroRepository extends JpaRepository<Seguro, String>{
    
}
