package xAuto.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xAuto.dao.UserDAO;
import xAuto.domain.Role;
import xAuto.domain.User;
import xAuto.domain.UserStatus;

import java.util.ArrayList;
import java.util.Collection;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDao.findUserByName(username);
        if (user != null) {
            String password = user.getPassword();
            boolean enabled = user.getStatus().equals(UserStatus.ACTIVE);
            boolean accountNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
            boolean credentialsNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
            boolean accountNonLocked = user.getStatus().equals(UserStatus.ACTIVE);


            Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
            for (Role role : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }

            org.springframework.security.core.userdetails.User securityUser = new
                    org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
            return securityUser;
        } else {
            throw new UsernameNotFoundException("Користувача не знайдено");
        }
    }

}