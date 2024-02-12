package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.generic.BaseEntity;
import fr.dawan.flashcards.business.passage.Passage;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserNew extends BaseEntity{
    private String email;
    private String password;

    private String name;
    private boolean active;

    @OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<Passage> tiroir;

    @Enumerated(value = EnumType.ORDINAL)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;
}
