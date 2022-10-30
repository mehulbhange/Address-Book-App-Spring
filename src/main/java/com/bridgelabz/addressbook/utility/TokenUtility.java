package com.bridgelabz.addressbook.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.stereotype.Component;

@Component
public class TokenUtility {

    private static final String TOKEN_SECRET = "Mehul";

    /**
     *
     * @param email - user email
     * @return - token
     */
    public String createToken(String email){
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        String token = JWT.create().withClaim("email", email).sign(algorithm);
        return token;
    }

    /**
     *
     * @param token - generated token
     * @return - user email
     */
    public String decodeToken(String token){
        String email;
        Verification verification = null;
        verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        JWTVerifier jwtverifier=verification.build();
        DecodedJWT decodedjwt=jwtverifier.verify(token);
        Claim claim=decodedjwt.getClaim("email");
        email=claim.asString();
        return email;
    }
}
