package com.AutoLifeBE.AutoLifeBE.persistence.repository;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Vehiculo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo, String>{
    @Query("SELECT v FROM Vehiculo v WHERE v.usuario = :usuario")
    List<Vehiculo> findUsuario(@Param("usuario") String usuario);
}
