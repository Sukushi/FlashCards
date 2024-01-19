package fr.dawan.flashcards;

import fr.dawan.flashcards.business.card.Card;
import fr.dawan.flashcards.business.card.CardRepository;
import fr.dawan.flashcards.business.card.Category;
import fr.dawan.flashcards.business.passage.PassageRepository;
import fr.dawan.flashcards.business.user.Role;
import fr.dawan.flashcards.business.user.User;
import fr.dawan.flashcards.business.user.UserRepository;
import fr.dawan.flashcards.security.auth.AuthServiceBDD;
import fr.dawan.flashcards.security.auth.RegisterDto;
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
	@Autowired
	AuthServiceBDD authService;
	
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

		if (cardRepository.findAll().isEmpty()){
			cardRepository.save(new Card("temoin", Category.TEST,"Question Témoin","Réponse Témoin"));
			cardRepository.save(new Card("allouer", Category.DEFINITION,"Qu'est ce que \"allouer\" signifie ?",""));
			cardRepository.save(new Card("service", Category.DEFINITION,"Qu'est ce qu'un \"service\" ?",""));
			cardRepository.save(new Card("abstraction", Category.DEFINITION,"Qu'est ce qu'une \"abstraction\" ?",""));
			cardRepository.save(new Card("interface", Category.DEFINITION,"Qu'est ce qu'une \"interface\" ?",""));
			cardRepository.save(new Card("classe", Category.DEFINITION,"Qu'est ce qu'une \"classe\" ?",""));
			cardRepository.save(new Card("dependance", Category.DEFINITION,"Qu'est ce qu'une \"dépendance\" ?",""));
			cardRepository.save(new Card("objet", Category.DEFINITION,"Qu'est ce qu'un \"objet\" en programmation ?",""));
			cardRepository.save(new Card("algorithme", Category.DEFINITION,"Qu'est ce qu'un \"algorithme\" ?",""));
			cardRepository.save(new Card("heritage", Category.DEFINITION,"Qu'est ce qu'un \"heritage\" ?",""));
			cardRepository.save(new Card("encapsulation", Category.DEFINITION,"Qu'est ce que l' \"encapsulation\" ? Quels sont ces avantages ?",""));
			cardRepository.save(new Card("requete", Category.DEFINITION,"Qu'est ce qu'une \"requête\" ? Donner 3 exemples.",""));
			cardRepository.save(new Card("cyclomatique", Category.DEFINITION,"Qu'est ce que la \"complexité cyclomatique\" ?",""));
			cardRepository.save(new Card("dette_technique", Category.DEFINITION,"Qu'est ce que la \"dette technique\" ?",""));
			cardRepository.save(new Card("propriete", Category.DEFINITION,"Qu'est ce qu'une\"propriété\" signifie ?",""));
			cardRepository.save(new Card("configuration", Category.DEFINITION,"Qu'est ce qu'une \"configuration\" ?",""));
			cardRepository.save(new Card("implementation", Category.DEFINITION,"Qu'est ce qu'une \"implémentation\" ?",""));
			cardRepository.save(new Card("controller", Category.DEFINITION,"Qu'est ce qu'un \"controller\" ?",""));
			cardRepository.save(new Card("reflexion", Category.DEFINITION,"Qu'est ce que la \"réflexion\" signifie ?",""));
			cardRepository.save(new Card("genericite", Category.DEFINITION,"Qu'est ce que la \"généricité\" signifie ?",""));
			cardRepository.save(new Card("package", Category.DEFINITION,"Qu'est ce qu'un \"package\" ?",""));
			cardRepository.save(new Card("invoquer", Category.DEFINITION,"Qu'est ce qu' \"invoquer\" signifie ?",""));
			cardRepository.save(new Card("exceptions", Category.DEFINITION,"Qu'est ce qu'une \"exception\" ?",""));
			cardRepository.save(new Card("permissif", Category.DEFINITION,"Qu'est ce que le terme \"permissif\" signifie ?",""));
			cardRepository.save(new Card("statique", Category.DEFINITION,"Qu'est ce que le terme \"statique\" signifie ?",""));
			cardRepository.save(new Card("specifique", Category.DEFINITION,"Qu'est ce que le terme \"spécifique\" signifie ?",""));
			cardRepository.save(new Card("thread", Category.DEFINITION,"Qu'est ce qu'un \"thread\" ?",""));
			cardRepository.save(new Card("visibilite", Category.DEFINITION,"Qu'est ce que le terme \"visibilité\" signifie ? Citez les 4 valeurs",""));
			cardRepository.save(new Card("restfull", Category.DEFINITION,"Qu'est ce que le terme \"restfull\" signifie ?",""));
			cardRepository.save(new Card("annotation", Category.DEFINITION,"Qu'est ce qu'une\"annotation\" ?",""));
			cardRepository.save(new Card("repository", Category.DEFINITION,"Qu'est ce qu'un \"repository\" ?",""));
			cardRepository.save(new Card("audit", Category.DEFINITION,"Qu'est ce qu'un \"audit\" ?",""));
			cardRepository.save(new Card("entitee", Category.DEFINITION,"Qu'est ce qu'une \"entité\" ?",""));

			cardRepository.save(new Card("cahier-des-charges", Category.DEFINITION,"Qu'est ce qu'un \"cahier des charges\" ?",""));
			cardRepository.save(new Card("plugin", Category.DEFINITION,"Qu'est ce qu'un \"plugin\" ?",""));
			cardRepository.save(new Card("cardinalite", Category.DEFINITION,"Qu'est ce qu'une \"cardinalité\" ?",""));
			cardRepository.save(new Card("semantique", Category.DEFINITION,"Qu'est ce que le terme \"sémantique\" signifie ?",""));
			cardRepository.save(new Card("variable", Category.DEFINITION,"Qu'est ce qu'une \"variable\" ?",""));
			cardRepository.save(new Card("variable-systeme", Category.DEFINITION,"Qu'est ce qu'une \"variable système\" ?",""));
			cardRepository.save(new Card("variable-environnement", Category.DEFINITION,"Qu'est ce qu'une \"variable d'environnement\" ?",""));
	
			cardRepository.save(new Card("framework", Category.DEFINITION, "Qu'est ce qu'un \"framework\" ?",""));
			
			cardRepository.save(new Card("back-end", Category.ARCHITECTURE,"Qu'est ce que le terme \"back-end\" signifie ?",""));
			cardRepository.save(new Card("front-end", Category.ARCHITECTURE,"Qu'est ce que le terme \"front-end\" signifie ?",""));
			cardRepository.save(new Card("full-stack", Category.ARCHITECTURE,"Qu'est ce que le terme \"full-stack\" signifie ?",""));
			


			cardRepository.save(new Card("UUID", Category.SIGLE,"Que veut dire le sigle : UUID ?",""));
			cardRepository.save(new Card("DTO", Category.SIGLE,"Que veut dire le sigle : DTO ?",""));
			cardRepository.save(new Card("SCRUM", Category.SIGLE,"Que veut dire le sigle : SCRUM ?",""));
			cardRepository.save(new Card("DAO", Category.SIGLE,"Que veut dire le sigle : DAO ?",""));
			cardRepository.save(new Card("JPA", Category.SIGLE,"Que veut dire le sigle : JPA ?",""));
			cardRepository.save(new Card("GAV", Category.SIGLE,"Que veut dire le sigle : GAV ?",""));
			cardRepository.save(new Card("JVM", Category.SIGLE,"Que veut dire le sigle : JVM ?",""));
			cardRepository.save(new Card("POO", Category.SIGLE,"Que veut dire le sigle : POO ?",""));
			cardRepository.save(new Card("DCU", Category.SIGLE,"Que veut dire le sigle : DCU ?",""));
			cardRepository.save(new Card("DC", Category.SIGLE,"Que veut dire le sigle : DC ?",""));
			//cardRepository.save(new Card("MOT", Category.SIGLE,"Que veut dire le sigle : MOT ?",""));

			cardRepository.save(new Card("JSON", Category.EXTENSION,"A quoi correspond cette extension : JSON",""));
			cardRepository.save(new Card("XML", Category.EXTENSION,"A quoi correspond cette extension : XML",""));
			cardRepository.save(new Card("TXT", Category.EXTENSION,"A quoi correspond cette extension : TXT",""));
			cardRepository.save(new Card("SQL", Category.EXTENSION,"A quoi correspond cette extension : SQL",""));
			cardRepository.save(new Card("CSV", Category.EXTENSION,"A quoi correspond cette extension : CSV",""));
			cardRepository.save(new Card("WAR", Category.EXTENSION,"A quoi correspond cette extension : WAR",""));
			cardRepository.save(new Card("JAR", Category.EXTENSION,"A quoi correspond cette extension : JAR",""));

			cardRepository.save(new Card("trello", Category.SOFTWARE,"Quel est la fonction de ce logiciel : Trello",""));
			cardRepository.save(new Card("jacoco", Category.SOFTWARE,"Quel est la fonction de ce logiciel : JaCoCo",""));
			cardRepository.save(new Card("surefire", Category.SOFTWARE,"Quel est la fonction de ce logiciel : Surefire",""));
			cardRepository.save(new Card("maven", Category.SOFTWARE,"Quel est la fonction de ce logiciel : Maven",""));
			cardRepository.save(new Card("eclipse", Category.SOFTWARE,"Quel est la fonction de ce logiciel : Eclipse",""));
			cardRepository.save(new Card("intellij", Category.SOFTWARE,"Quel est la fonction de ce logiciel : IntelliJ",""));
			cardRepository.save(new Card("jenkins", Category.SOFTWARE,"Quel est la fonction de ce logiciel : Jenkins",""));
			cardRepository.save(new Card("sonarlint", Category.SOFTWARE,"Quel est la fonction de ce logiciel : Sonarlint",""));
			cardRepository.save(new Card("sonarqube", Category.SOFTWARE,"Quel est la fonction de ce logiciel : SonarQube",""));
			cardRepository.save(new Card("postman", Category.SOFTWARE,"Quel est la fonction de ce logiciel : POST Man",""));

			cardRepository.save(new Card("Java", Category.LANGAGE,"Citez moi trois particularités de ce langage : Java",""));
			cardRepository.save(new Card("Javascript", Category.LANGAGE,"Citez moi trois particularités de ce langage : Javascript",""));

			cardRepository.save(new Card("Angular", Category.FRAMEWORK,"Quels sont les particularités de ce framework : Angular",""));
			cardRepository.save(new Card("React", Category.FRAMEWORK,"Quels sont les particularités de ce framework : React",""));
			cardRepository.save(new Card("Spring", Category.FRAMEWORK,"Quels sont les particularités de ce framework : Spring",""));
			cardRepository.save(new Card("Symfony", Category.FRAMEWORK,"Quels sont les particularités de ce framework : Symfony",""));
		}

		if (userRepository.findAll().isEmpty()) {
			authService.register(new RegisterDto("baptiste","baptou","baptiste.l@gmail.com", Role.ADMIN));
			authService.register(new RegisterDto("romain","roro","romain.c@gmail.com", Role.ADMIN));
			authService.register(new RegisterDto("yanis","yanou","yanis.a@gmail.com", Role.MODO));
			authService.register(new RegisterDto("florian","floflo","florian.d@gmail.com", Role.USER));
			authService.register(new RegisterDto("chayanne","chayou","chayanne.p@gmail.com", Role.USER));
			authService.register(new RegisterDto("titouan","titou","titouan.m@gmail.com", Role.USER));
		}
	}
}

// --spring.profiles.active=dev
// --spring.profiles.active=test
