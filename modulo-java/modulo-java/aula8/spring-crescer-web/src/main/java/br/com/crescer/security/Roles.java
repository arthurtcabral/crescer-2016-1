package br.com.crescer.security;

import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Carlos H. Nonnemacher
 */
public enum Roles implements GrantedAuthority {

    USER;

    @Override
    public String getAuthority() {
        return toString();
    }

    public static List<Roles> valuesToList() {
        return Arrays.asList(Roles.values());
    }

}
