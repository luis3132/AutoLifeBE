package com.AutoLifeBE.AutoLifeBE.persistence.repository;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    
    @Modifying
    @Query(value = "UPDATE AutoLife.usuarios SET nombre=':nombre', apellidos=':apellidos', telefono=':telefono', direccion=':direccion', email=':email' WHERE dni=':dni';", nativeQuery = true)
    void updateUser(@Param("nombre") String nombre, @Param("apellidos") String apellidos, @Param("telefono") String telefono, @Param("direccion") String direccion, @Param("email") String email, @Param("dni") String dni);
    
}
