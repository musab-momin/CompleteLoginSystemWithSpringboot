package com.reglog.security;

import com.reglog.dao.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService
{

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new AppUserDetails(userRepo.getByEmail(email)
                .orElseThrow(()->{
                    System.out.println(System.out.printf("User with this email %s does not exists: ", email));
                    return new UsernameNotFoundException(String.format("User with this email %s does not exists ", email));
                }
                ));
    }
}
