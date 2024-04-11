package com.AutoLifeBE.AutoLifeBE.persistence.repository;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface UsuariosRepository extends JpaRepository<Usuarios, String>{
    
    @Query("SELECT u FROM Usuarios u WHERE u.nombreUsuario = :nombreUsuario")
    Optional<Usuarios> findNombreUsuario(@Param("nombreUsuario") String nombreUsuario);
    
    @Query("SELECT u FROM Usuarios u WHERE u.email = :email")
    Optional<Usuarios> findEmail(@Param("email") String email);
    
}
