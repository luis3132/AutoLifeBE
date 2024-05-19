package com.AutoLifeBE.AutoLifeBE.persistence.repository;

import com.AutoLifeBE.AutoLifeBE.domain.dto.DuenosDTO;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Duenos;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface DuenosRepository extends JpaRepository<Duenos, Long> {

    @Query(value = "SELECT * FROM duenos WHERE usuario = :usuarios", nativeQuery = true)
    Optional<List<Duenos>> findByIdUsuarios(@Param("usuarios") String usuarios);

    @Query(value = "SELECT * FROM duenos WHERE vehiculo = :vehiculos", nativeQuery = true)
    Optional<List<Duenos>> findByIdVehiculos(@Param("vehiculos") String vehiculos);

    @Modifying
    @Query(value = "INSERT INTO duenos (usuario, vehiculo, kmstart, kmfinish, datestart, datefinish, ciudadpromtransi) VALUES (:usuario, :vehiculo, :kmstart, :kmfinish, :datestart, :datefinish, :ciudadpromtransi)", nativeQuery = true)
    void saveSID(@Param("usuario") String usuario, @Param("vehiculo") String vehiculo, @Param("kmstart") int kmstart, @Param("kmfinish") int kmfinish, @Param("datestart") Date datestart, @Param("datefinish") Date datefinish, @Param("ciudadpromtransi") String ciudadpromtransi);

}
