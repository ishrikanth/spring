package poc.endpoints.security;

    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poc.endpoints.dao.UserDaoRepository;
import poc.endpoints.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created by shrikanth on 2/8/17.
 */
@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDaoRepository userRepository;

//    @Autowired
//    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;

    public MyUserDetailsService() {
        super();
    }

    // API

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final String ip = getClientIP();
//        if (loginAttemptService.isBlocked(ip)) {
//            throw new RuntimeException("blocked");
//        }

        try {
            final UserEntity user = userRepository.findByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + email);
            }

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, null);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

//    // UTIL
//
//    private final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
//        return getGrantedAuthorities(getPrivileges(roles));
//    }
//
//    private final List<String> getPrivileges(final Collection<Role> roles) {
//        final List<String> privileges = new ArrayList<String>();
//        final List<Privilege> collection = new ArrayList<Privilege>();
//        for (final Role role : roles) {
//            collection.addAll(role.getPrivileges());
//        }
//        for (final Privilege item : collection) {
//            privileges.add(item.getName());
//        }
//
//        return privileges;
//    }
//
//    private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
//        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        for (final String privilege : privileges) {
//            authorities.add(new SimpleGrantedAuthority(privilege));
//        }
//        return authorities;
//    }
//
    private final String getClientIP() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr()+ new Random().nextInt();
        }
        return xfHeader.split(",")[0];
    }

}
