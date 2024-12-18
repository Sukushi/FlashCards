package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.BaseEntity;
import fr.dawan.flashcards.business.passage.Passage;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Card extends BaseEntity {
    private String title;
    private Category category;
    private String question;
    @Column(columnDefinition="Text")
    private String answer;
	@OneToMany(mappedBy = "card", cascade = {CascadeType.REMOVE})
	@ToString.Exclude
	private List<Passage> passages;
	
	public Card(String title, Category category, String question, String answer) {
		this.title = title;
		this.category = category;
		this.question = question;
		this.answer = answer;
	}
}
