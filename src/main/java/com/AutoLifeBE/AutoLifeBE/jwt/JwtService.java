package com.AutoLifeBE.AutoLifeBE.jwt;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Usuarios;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Service
public class JwtService {
    
    private static final String KEY = "489646584694514684A416859484894F689466A46894865419189B189189C98198489A84";

    public String getToken(Usuarios user) {
        return getToken(new HashMap<>(), user);
    }

    private String getToken(Map<String, Object> extraClaims, Usuarios user) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getNombreUsuario())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
}
