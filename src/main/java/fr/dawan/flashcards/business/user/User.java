package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.generic.BaseEntity;
import fr.dawan.flashcards.business.passage.Passage;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User extends BaseEntity implements UserDetails {

    /*
    J'aimerais bien refactor pour avoir email, password en premier. Le nom ensuite, son (ou ses ?) tiroir(s)
    et enfin ses rôles
     */
    private String name;
    private String password;
    @OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<Passage> tiroir;
    private String email;

    private boolean active;

    @Enumerated(value = EnumType.ORDINAL)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
	@ToString.Exclude
	private List<Passage> passages;
    // TODO Si je modifie le role en une List<Role> :
    /**
     * L'utilisateur peut donc avoir plusieurs rôles
     * Ce n'est pas vraiment ce que je voulais ?
     * Je veux plutôt que chaque question est une ou plusieurs "category" tag like
     *
     * En même temps, c'est ce que je souhaite aussi ? Un Modo est aussi un User et un Admin est aussi un Modo et
     * un User ...
     */

    // TODO Need this car pas d'attribution de roles à la création d'un User ?
    public User(String name, String password, String email, List<Role> roles) {
        this.name = name;
        this.password = password;
        this.email = email;
		this.roles = roles;
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(Objects.toString(getRoles(), "PUBLIC").split(",")).map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
