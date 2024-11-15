package com.autolife.autolife.secure.jwt;

import java.security.Key;
import java.util.Base64;

import org.springframework.stereotype.Service;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class JwtService {
    
    private static final String KEY = "0987656789jhbvfgvght678uhbgt78yijbg78yjoimnygu78gfcrtyvhbunijo897fr4ref4gr";

    private Key getKey() {
        byte[] keyBytes = Base64.getDecoder().decode(KEY);
        return Keys
    }
}