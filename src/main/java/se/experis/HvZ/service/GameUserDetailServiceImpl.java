
package se.experis.HvZ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.experis.HvZ.domain.GameUser;
import se.experis.HvZ.domain.GameUserRepository;

@Service
public class GameUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private GameUserRepository gameUserRepository;

        @Override
        public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
        {
            GameUser currentGameUser = gameUserRepository.findByUserName(userName);
            UserDetails gameUser = new org.springframework.security.core
                    .userdetails.User(userName, currentGameUser.getPassword()
                    , true, true, true, true,
                    AuthorityUtils.createAuthorityList(currentGameUser.getRole()));
            return gameUser;
        }

}
