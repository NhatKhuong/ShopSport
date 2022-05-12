package com.se.util;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class EncryptUtils {
	 private final static String JWT_SECRET = "lodaaaaaa";

	    //Thời gian có hiệu lực của chuỗi jwt
	    private final static long JWT_EXPIRATION = 604800000L;
	
    public static String base64encode(String text) {
        try {
        	  Date now = new Date();
              Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        	 return Jwts.builder()
                     .setSubject(text)
                     .setIssuedAt(now)
                     .setExpiration(expiryDate)
                     .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                     .compact();
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }//base64encode
 
    public static String base64decode(String text) {
        try {
        	  Claims claims = Jwts.parser()
                      .setSigningKey(JWT_SECRET)
                      .parseClaimsJws(text)
                      .getBody();
        	  
        	return claims.getSubject();
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
}
