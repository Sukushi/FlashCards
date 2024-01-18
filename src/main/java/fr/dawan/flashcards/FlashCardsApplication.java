package fr.dawan.flashcards;

import fr.dawan.flashcards.business.card.Card;
import fr.dawan.flashcards.business.card.CardRepository;
import fr.dawan.flashcards.business.card.Category;
import fr.dawan.flashcards.business.passage.PassageRepository;
import fr.dawan.flashcards.business.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FlashCardsApplication implements CommandLineRunner {

	@Autowired
	CardRepository cardRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PassageRepository passageRepository;
	public static void main(String[] args) {
		SpringApplication.run(FlashCardsApplication.class, args);
		// SpringApplication.run(JoeLaBidouille.class, args);
		// SpringApplication.run(RoronoahSansChaussures.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Méthode qui s'exécute avant L'application
		System.out.println("\t>>>>>>>>> Run before App\n");

		/*
		cardRepository.save(new Card("", Category.TEST, "",""));
		 */

		if (cardRepository.findAll().size() == 0){
			cardRepository.save(new Card("temoin", Category.TEST,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("allouer", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("service", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("abstraction", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("interface", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("classe", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("dependance", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("objet", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("algorithme", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("heritage", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("encapsulation", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("requete", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("cyclomatique", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("dette_technique", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("propriete", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("configuration", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("implementation", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("controller", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("reflexion", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("genericite", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("package", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("invoquer", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("exceptions", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("permissif", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("statique", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("specifique", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("thread", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("visibilite", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("restfull", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("annotation", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("repository", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("audit", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("entitee", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("back-end", Category.ARCHITECTURE,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("front-end", Category.ARCHITECTURE,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("full-stack", Category.ARCHITECTURE,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("cahier-des-charges", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("plugin", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("cardinalite", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("semantique", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("variables", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("variable-systeme", Category.DEFINITION,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("variable-environnement", Category.DEFINITION,"Question Témoin","Réponse Témoin"));

			cardRepository.save(new Card("framework", Category.DEFINITION, "",""));

			cardRepository.save(new Card("UUID", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));
			cardRepository.save(new Card("DTO", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));
			cardRepository.save(new Card("SCRUM", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));
			cardRepository.save(new Card("DAO", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));
			cardRepository.save(new Card("JPA", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));
			cardRepository.save(new Card("GAV", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));
			cardRepository.save(new Card("JVM", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));
			cardRepository.save(new Card("POO", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));
			cardRepository.save(new Card("DCU", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));
			cardRepository.save(new Card("DC", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));
			cardRepository.save(new Card("JPA", Category.SIGLE,"Que veut dire ce sigle ?","U U I D"));

			cardRepository.save(new Card("JSON", Category.EXTENSION,"A quoi correspond cette extension ?","U U I D"));
			cardRepository.save(new Card("XML", Category.EXTENSION,"A quoi correspond cette extension ?","U U I D"));
			cardRepository.save(new Card("TXT", Category.EXTENSION,"A quoi correspond cette extension ?","U U I D"));
			cardRepository.save(new Card("SQL", Category.EXTENSION,"A quoi correspond cette extension ?","U U I D"));
			cardRepository.save(new Card("CSV", Category.EXTENSION,"A quoi correspond cette extension ?","U U I D"));
			cardRepository.save(new Card("WAR", Category.EXTENSION,"A quoi correspond cette extension ?","U U I D"));
			cardRepository.save(new Card("JAR", Category.EXTENSION,"A quoi correspond cette extension ?","U U I D"));

			cardRepository.save(new Card("trello", Category.SOFTWARE,"Quel est la fonction de ce logiciel ?","U U I D"));
			cardRepository.save(new Card("surefire", Category.SOFTWARE,"Quel est la fonction de ce logiciel ?","U U I D"));
			cardRepository.save(new Card("maven", Category.SOFTWARE,"Quel est la fonction de ce logiciel ?","U U I D"));
			cardRepository.save(new Card("eclipse", Category.SOFTWARE,"Quel est la fonction de ce logiciel ?","U U I D"));
			cardRepository.save(new Card("intellij", Category.SOFTWARE,"Quel est la fonction de ce logiciel ?","U U I D"));
			cardRepository.save(new Card("jenkins", Category.SOFTWARE,"Quel est la fonction de ce logiciel ?","U U I D"));
			cardRepository.save(new Card("sonarlint", Category.SOFTWARE,"Quel est la fonction de ce logiciel ?","U U I D"));
			cardRepository.save(new Card("sonarqube", Category.SOFTWARE,"Quel est la fonction de ce logiciel ?","U U I D"));
			cardRepository.save(new Card("postman", Category.SOFTWARE,"Quel est la fonction de ce logiciel ?","U U I D"));

			cardRepository.save(new Card("Java", Category.LANGAGE,"Citez moi trois particularités de ce langage : ","U U I D"));
			cardRepository.save(new Card("Javascript", Category.LANGAGE,"Citez moi trois particularités de ce langage : ","U U I D"));

			cardRepository.save(new Card("Angular", Category.FRAMEWORK,"Quel est la fonction de ce logiciel ?","U U I D"));
			cardRepository.save(new Card("React", Category.FRAMEWORK,"Quel est la fonction de ce logiciel ?","U U I D"));


		}


	}
}

// --spring.profiles.active=test