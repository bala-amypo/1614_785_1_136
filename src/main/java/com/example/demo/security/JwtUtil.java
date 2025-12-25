public class JwtUtil {

    private final Key key;
    private final long validity;

    public JwtUtil(String secret, long validityMs) {
        key = Keys.hmacShaKeyFor(secret.getBytes());
        validity = validityMs;
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(key)
                .compact();
    }

    public Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
