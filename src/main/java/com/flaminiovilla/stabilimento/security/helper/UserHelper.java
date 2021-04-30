package com.flaminiovilla.stabilimento.security.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flaminiovilla.stabilimento.security.exception.UserException;
import com.flaminiovilla.stabilimento.security.jwt.JWTFilter;
import com.flaminiovilla.stabilimento.security.jwt.TokenProvider;
import com.flaminiovilla.stabilimento.security.model.Authority;
import com.flaminiovilla.stabilimento.security.model.User;
import com.flaminiovilla.stabilimento.security.repository.AuthorityRepository;
import com.flaminiovilla.stabilimento.security.repository.UserRepository;
import com.flaminiovilla.stabilimento.security.rest.dto.LoginDTO;
import com.flaminiovilla.stabilimento.security.rest.dto.UserDTO;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.flaminiovilla.stabilimento.security.exception.UserException.userExceptionCode.AUTHORITY_NOT_EXIST;
import static com.flaminiovilla.stabilimento.security.exception.UserException.userExceptionCode.USER_ALREADY_EXISTS;

@Component
public class UserHelper {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public UserHelper(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginDTO loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.email, loginDto.password);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        //SecurityContextHolder è una classe di supporto, che forniscono l'accesso al contesto di protezione
        SecurityContextHolder.getContext().setAuthentication(authentication);

        boolean rememberMe = (loginDto.rememberMe == null) ? false : loginDto.isRememberMe();
        String jwt = tokenProvider.createToken(authentication, rememberMe);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    public static class JWTToken {

        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }

    public void ceckUser(UserDTO userDTO) {
        Preconditions.checkArgument(Objects.nonNull(userDTO.email));
        Preconditions.checkArgument(Objects.nonNull(userDTO.password));
        Preconditions.checkArgument(Objects.nonNull(userDTO.role));
        Preconditions.checkArgument(Objects.nonNull(userDTO.firstName));
        Preconditions.checkArgument(Objects.nonNull(userDTO.lastName));
    }

    public User register(UserDTO userDTO) {
        ceckUser(userDTO);
        if (!userRepository.existsByEmail(userDTO.email) && !role(userDTO).isEmpty()) {
            return userRepository.save(User.builder()
                    .email(userDTO.email)
                    .password(bcryptEncoder.encode(userDTO.password))
                    .firstName(userDTO.firstName)
                    .lastName(userDTO.lastName)
                    .activated(true)
                    .authorities(role(userDTO))
                    .build());
        }
        throw new UserException(USER_ALREADY_EXISTS);
    }

    private Set<Authority> role(UserDTO userDTO){
        Set<Authority> author = new HashSet<>();
        if(userDTO.role.equals("USER")){
            author.add(authorityRepository.getByName("USER"));
        }else if(userDTO.role.equals("ADMIN")){
            author.add(authorityRepository.getByName("USER"));
            author.add(authorityRepository.getByName("ADMIN"));
        }else {
            throw new UserException(AUTHORITY_NOT_EXIST);
        }
        return author;
    }

}
