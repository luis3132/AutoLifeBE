package com.AutoLifeBE.AutoLifeBE.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthResponse {
    private String token;
}
