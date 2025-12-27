// public class JwtUtil {

//     private final Key key;
//     private final long validity;

//     public JwtUtil(String secret, long validityMs) {
//         key = Keys.hmacShaKeyFor(secret.getBytes());
//         validity = validityMs;
//     }

//     public String generateToken(Map<String, Object> claims, String subject) {
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(subject)
//                 .setExpiration(new Date(System.currentTimeMillis() + validity))
//                 .signWith(key)
//                 .compact();
//     }

//     public Claims getAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }




// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.security.Keys;

// import java.security.Key;
// import java.util.Date;
// import java.util.Map;

// public class JwtUtil {

//     private final Key key;
//     private final long validityMs;

//     public JwtUtil(String secret, long validityMs) {
//         this.key = Keys.hmacShaKeyFor(secret.getBytes());
//         this.validityMs = validityMs;
//     }

//     public String generateToken(Map<String, Object> claims, String subject) {
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(subject)
//                 .setExpiration(
//                         new Date(System.currentTimeMillis() + validityMs)
//                 )
//                 .signWith(key)
//                 .compact();
//     }

//     public Claims getAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }









// // src/main/java/com/example/demo/security/JwtUtil.java
// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;

// import java.security.Key;
// import java.util.Date;
// import java.util.Map;

// public class JwtUtil {

//     private final Key key;
//     private final long validityInMs;

//     public JwtUtil(String secret, long validityInMs) {
//         this.key = Keys.hmacShaKeyFor(secret.getBytes());
//         this.validityInMs = validityInMs;
//     }

//     public String generateToken(Map<String, Object> claims, String subject) {
//         Date now = new Date();
//         Date exp = new Date(now.getTime() + validityInMs);
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(subject)
//                 .setIssuedAt(now)
//                 .setExpiration(exp)
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public Claims getAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }













// // src/main/java/com/example/demo/security/JwtUtil.java
// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;

// import java.security.Key;
// import java.util.Date;
// import java.util.Map;

// public class JwtUtil {

//     private final Key key;
//     private final long validityInMs;

//     public JwtUtil(String secret, long validityInMs) {
//         this.key = Keys.hmacShaKeyFor(secret.getBytes());
//         this.validityInMs = validityInMs;
//     }

//     public String generateToken(Map<String, Object> claims, String subject) {
//         Date now = new Date();
//         Date exp = new Date(now.getTime() + validityInMs);
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(subject)
//                 .setIssuedAt(now)
//                 .setExpiration(exp)
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public Claims getAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }

















// package com.example.demo.security;

// import java.time.Instant;
// import java.util.Date;
// import java.util.function.Function;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.security.Keys;

// @Component
// public class JwtUtil {

//     @Value("${jwt.secret:MyJwtSecretKeyMyJwtSecretKeyMyJwtSecretKey123456}")
//     private String secret;

//     @Value("${jwt.expiration-ms:3600000}")
//     private long jwtExpirationMs;

//     private byte[] getSigningKeyBytes() {
//         return secret.getBytes();
//     }

//     public String generateToken(String username) {
//         Instant now = Instant.now();
//         Date issuedAt = Date.from(now);
//         Date expiration = Date.from(now.plusMillis(jwtExpirationMs));

//         return Jwts.builder()
//                 .subject(username)
//                 .issuedAt(issuedAt)
//                 .expiration(expiration)
//                 .signWith(Keys.hmacShaKeyFor(getSigningKeyBytes()), Jwts.SIG.HS256)
//                 .compact();
//     }

//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }

//     public Date extractExpiration(String token) {
//         return extractClaim(token, Claims::getExpiration);
//     }

//     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//         Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }

//     private Claims extractAllClaims(String token) {
//         return Jwts.parser()
//                 .verifyWith(Keys.hmacShaKeyFor(getSigningKeyBytes()))
//                 .build()
//                 .parseSignedClaims(token)
//                 .getPayload();
//     }

//     private boolean isTokenExpired(String token) {
//         return extractExpiration(token).before(new Date());
//     }

//     public boolean validateToken(String token, String username) {
//         String tokenUsername = extractUsername(token);
//         return tokenUsername.equals(username) && !isTokenExpired(token);
//     }
// }
















// package com.example.demo.security;

// import java.time.Instant;
// import java.util.Date;
// import java.util.Map;
// import java.util.function.Function;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.security.Keys;

// @Component
// public class JwtUtil {

//     @Value("${jwt.secret:MyJwtSecretKeyMyJwtSecretKeyMyJwtSecretKey123456}")
//     private String secret;

//     @Value("${jwt.expiration-ms:3600000}")
//     private long jwtExpirationMs;

//     private byte[] getSigningKeyBytes() {
//         return secret.getBytes();
//     }

//     // === CLAIMS HELPERS ===
//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }

//     public Date extractExpiration(String token) {
//         return extractClaim(token, Claims::getExpiration);
//     }

//     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//         Claims claims = getAllClaims(token);
//         return claimsResolver.apply(claims);
//     }

//     // This method is what JwtFilter is calling.
//     public Claims getAllClaims(String token) {
//         return Jwts.parser()
//                 .verifyWith(Keys.hmacShaKeyFor(getSigningKeyBytes()))
//                 .build()
//                 .parseSignedClaims(token)
//                 .getPayload();
//     }

//     private boolean isTokenExpired(String token) {
//         return extractExpiration(token).before(new Date());
//     }

//     // === TOKEN GENERATION ===

//     // Used when you only need username
//     public String generateToken(String username) {
//         return generateToken(Map.of(), username);
//     }

//     // Used when AuthController passes claims + username
//     public String generateToken(Map<String, Object> claims, String username) {
//         Instant now = Instant.now();
//         Date issuedAt = Date.from(now);
//         Date expiration = Date.from(now.plusMillis(jwtExpirationMs));

//         return Jwts.builder()
//                 .claims(claims)
//                 .subject(username)
//                 .issuedAt(issuedAt)
//                 .expiration(expiration)
//                 .signWith(Keys.hmacShaKeyFor(getSigningKeyBytes()), Jwts.SIG.HS256)
//                 .compact();
//     }

//     // === VALIDATION ===
//     public boolean validateToken(String token, String username) {
//         String tokenUsername = extractUsername(token);
//         return tokenUsername.equals(username) && !isTokenExpired(token);
//     }
// }







package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public class JwtUtil {

    // Use the same secret the tests expect; example:
    private static final String SECRET = "your-256-bit-secret-your-256-bit-secret";

    private Key getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET);
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    // ===== Generate token =====
    public String generateToken(String username, Map<String, Object> additionalClaims) {

        long now = System.currentTimeMillis();
        long expiry = now + 1000 * 60 * 60; // 1 hour

        return Jwts.builder()
                .setClaims(additionalClaims)                // all custom claims
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(expiry))
                .signWith(SignatureAlgorithm.HS256, getSigningKey())
                .compact();
    }

    // Overload if only username is needed
    public String generateToken(String username) {
        return generateToken(username, java.util.Collections.emptyMap());
    }

    // ===== Extract claims =====
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
        Date expiration = extractClaim(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    public boolean isTokenValid(String token, String expectedUsername) {
        String username = extractUsername(token);
        return username.equals(expectedUsername) && !isTokenExpired(token);
    }
}
