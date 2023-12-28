package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.generic.BaseEntity;
import fr.dawan.flashcards.business.passage.Passage;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User extends BaseEntity implements UserDetails {

    private String name;
    private String password; // spring security à implémenter
    @OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<Passage> tiroir;
    private String email;
    private String role;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    // TODO Need this car pas d'attribution de roles à la création d'un User ?
    public User(String name, String password, List<Passage> tiroir, String email) {
        this.name = name;
        this.password = password;
        this.tiroir = tiroir;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(role.split(",")).map(SimpleGrantedAuthority::new).toList();
        // Récupérer l'user avec la liste de GrantedAuthority qui correspond au nom du role donnée à l'utilisateur
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
