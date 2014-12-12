package com.use.springcouchdb.security.authentication;

import com.use.springcouchdb.security.service.CustomUserServiceDetails;
import com.use.springcouchdb.user.model.Role;
import com.use.springcouchdb.user.model.User;
import com.use.springcouchdb.user.repository.UserRepository;
import com.use.springcouchdb.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by usegutierrez on 12/10/14.
 */
@Component
public class SpringCouchDbAuthenticationProvider implements AuthenticationProvider {

    static final Logger logger = LoggerFactory.getLogger(SpringCouchDbAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        logger.debug("====== principal: {}", authentication.getPrincipal());
        logger.debug("====== credentials: {}", authentication.getCredentials());
        logger.debug("====== details: {}", authentication.getDetails());
        logger.debug("====== authorities: {}", authentication.getAuthorities());

        User user = userService.findByUsername(authentication.getPrincipal().toString());

        if(null == user) {
            //throw Exception here
            throw new UsernameNotFoundException("USER NOT FOUND!!");
        } else {

            CustomUserServiceDetails currentUser = new CustomUserServiceDetails(authentication.getName(),
                                                                                authentication.getCredentials().toString(),
                                                                                getGrantedAuthorities(user));

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(currentUser,
                                                                                                null,
                                                                                                getGrantedAuthorities(user));
            SecurityContextHolder.getContext().setAuthentication(token);
            return token;
        }
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(User user) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

        if(user != null) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
            /*for(Role role : user.getRole()) {

            }*/
        }
        return authList;
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
