package com.bankly.userservice.utiles.Jwts;

import com.bankly.userservice.entities.UserApp;
import com.bankly.userservice.services.dto.ResponseDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


@Service
public class JwtUtils {

    private final String jwtSingningKey = "secret";


    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    public boolean hasClaim(String token, String claimName){
        final  Claims claims = extractAllClaims(token);
        return claims.get(claimName) != null;
    }

    public <T> T extractClaim(String token , Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(jwtSingningKey).parseClaimsJws(token).getBody();
    }

    public Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }



    public ResponseDto createToken(Map<String,Object> claims, UserApp userDetails){

        return new ResponseDto("success","token",Jwts.builder().setClaims(claims)
                .setSubject(userDetails.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256,jwtSingningKey).compact());
    }

}
