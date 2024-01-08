package fr.dawan.flashcards.business.user;

import java.io.Serializable;

public interface UserDetails extends Serializable { // (2)

    String getUsername();
    String getPassword();

    // <3> more methods:
    // isAccountNonExpired,isAccountNonLocked,
    // isCredentialsNonExpired,isEnabled
}
