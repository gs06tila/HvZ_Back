/*
package se.experis.HvZ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.experis.HvZ.domain.GameUserRepository;
import se.experis.HvZ.domain.GameUser;

@Service
public abstract class GameUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private GameUserRepository gameUserRepository;

    @Override
    public UserDetails loadGameUserByUserName(String username) throws UsernameNotFoundException
    {
        GameUser currentGameUser = gameUserRepository.findByUserName(username);
        UserDetails user = new org.springframework.security.core
                .userdetails.User(username, currentGameUser.getPassword()
                , true, true, true, true,
                AuthorityUtils.createAuthorityList(currentGameUser.getRole()));
        return user;
    }


}
*/