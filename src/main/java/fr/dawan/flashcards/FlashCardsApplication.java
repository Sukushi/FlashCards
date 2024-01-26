package fr.dawan.flashcards;

import fr.dawan.flashcards.business.card.Card;
import fr.dawan.flashcards.business.card.CardRepository;
import fr.dawan.flashcards.business.card.Category;
import fr.dawan.flashcards.business.passage.Passage;
import fr.dawan.flashcards.business.passage.PassageRepository;
import fr.dawan.flashcards.business.passage.PassageServiceBDD;
import fr.dawan.flashcards.business.user.Role;
import fr.dawan.flashcards.business.user.UserRepository;
import fr.dawan.flashcards.security.auth.AuthServiceBDD;
import fr.dawan.flashcards.security.auth.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Pageable;

import java.util.List;


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
	@Autowired
	PassageServiceBDD passageService;
	
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
			cardRepository.save(new Card("allouer", Category.DEFINITION,"Qu'est ce que \"allouer\" signifie ?","En informatique, l'allocation est le fait d'associer un espace de mémoire à certaines données ou à un programme pour son exécution."));
			cardRepository.save(new Card("service", Category.DEFINITION,"Qu'est ce qu'un \"service\" ?","En informatique, un service est une fonctionnalité ou partie de fonctionnalité mise à disposition par un composant logiciel pour assurer une tâche particulière. Elle se présente sous forme de boîte noire, présentant uniquement son interface logicielle : nom du service, des fonctions qu'il inclut avec les variables d'entrée requises et sorties produites, et d'éventuelles données complémentaires informatives sur le service | https://fr.wikipedia.org/wiki/Service"));
			cardRepository.save(new Card("abstraction", Category.DEFINITION,"Qu'est ce qu'une \"abstraction\" ?","Dans le contexte orienté objet, l'abstraction est un mécanisme, ou une pratique, servant à réduire le code d'un niveau de détail. Autrement dit, l'abstraction permet de regrouper un certain nombre de classes selon des caractéristiques communes."));
			cardRepository.save(new Card("interface", Category.DEFINITION,"Qu'est ce qu'une \"interface\" ?","Une interface définit la frontière de communication entre deux entités. On appelle aussi interfaces des dispositifs fournissant un moyen de traduction entre des entités qui n'utilisent pas le même langage, comme entre un être humain et un ordinateur."));
			cardRepository.save(new Card("classe", Category.DEFINITION,"Qu'est ce qu'une \"classe\" ?","En programmation orientée objet, la déclaration d'une classe regroupe des membres, méthodes et propriétés (attributs) communs à un ensemble d'objets. La classe déclare, d'une part, des attributs représentant l'état des objets et, d'autre part, des méthodes représentant leur comportement."));
			cardRepository.save(new Card("dependance", Category.DEFINITION,"Qu'est ce qu'une \"dépendance fonctionnelle\" ?","En théorie des bases de données relationnelles, une dépendance fonctionnelle est une contrainte entre deux ensembles d'attributs dans une relation (table) d'une base de données"));
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
			cardRepository.save(new Card("injection-dependance", Category.DEFINITION,"Qu'est ce qu'une \"injection de dépendances\" ?","L'injection de dépendances {dependency (of) injection en anglais} est un mécanisme qui permet d'implémenter le principe de l'inversion de contrôle"));
			cardRepository.save(new Card("inversion-controle", Category.DEFINITION,"Qu'est ce qu'une \"entité\" ?","L’inversion de contrôle (inversion of control, IoC) est un patron d'architecture commun à tous les frameworks (ou cadre de développement et d'exécution). Il fonctionne selon le principe que le flot d'exécution d'un logiciel n'est plus sous le contrôle direct de l'application elle-même mais du framework ou de la couche logicielle sous-jacente."));
			cardRepository.save(new Card("inversion-dependances", Category.DEFINITION,"Qu'est ce qu'une \"inversion des dépendances\" ?","En programmation orientée objet, le principe d'inversion des dépendances (dependency inversion principle) fait référence à une forme spécifique de découplage des modules logiciels1. Il correspond au « D » de l'acronyme SOLID."));

			cardRepository.save(new Card("cahier-des-charges", Category.DEFINITION,"Qu'est ce qu'un \"cahier des charges\" ?",""));
			cardRepository.save(new Card("plugin", Category.DEFINITION,"Qu'est ce qu'un \"plugin\" ?",""));
			cardRepository.save(new Card("cardinalite", Category.DEFINITION,"Qu'est ce qu'une \"cardinalité\" ?",""));
			cardRepository.save(new Card("semantique", Category.DEFINITION,"Qu'est ce que le terme \"sémantique\" signifie ?",""));
			cardRepository.save(new Card("variable", Category.DEFINITION,"Qu'est ce qu'une \"variable\" ?",""));
			cardRepository.save(new Card("variable-systeme", Category.DEFINITION,"Qu'est ce qu'une \"variable système\" ?",""));
			cardRepository.save(new Card("variable-environnement", Category.DEFINITION,"Qu'est ce qu'une \"variable d'environnement\" ?",""));
	
			cardRepository.save(new Card("framework", Category.DEFINITION, "Qu'est ce qu'un \"framework\" ?","En Informatique, un framework {cadre de travail} est un ensemble cohérent de composants logiciels structurels qui sert à créer les fondations ainsi que les grandes lignes de tout ou partie d'un logiciel, c'est-à-dire une architecture."));
			
			cardRepository.save(new Card("back-end", Category.ARCHITECTURE,"Qu'est ce que le terme \"back-end\" signifie ?",""));
			cardRepository.save(new Card("front-end", Category.ARCHITECTURE,"Qu'est ce que le terme \"front-end\" signifie ?",""));
			cardRepository.save(new Card("full-stack", Category.ARCHITECTURE,"Qu'est ce que le terme \"full-stack\" signifie ?",""));
			


			cardRepository.save(new Card("UUID", Category.SIGLE,"Que veut dire le sigle : UUID ?","Universally Unique IDentifier ?"));
			cardRepository.save(new Card("DTO", Category.SIGLE,"Que veut dire le sigle : DTO ?","Data Transfer Object"));
			cardRepository.save(new Card("SCRUM", Category.SIGLE,"A quoi correspond le sigle : SCRUM ?","Méthodologie Agile de développement de logiciels : Scrum est considéré comme un groupe de pratiques répondant pour la plupart aux préconisations du manifeste agile.  <mêlée du rugby> "));
			cardRepository.save(new Card("DAO", Category.SIGLE,"Que veut dire le sigle : DAO ?","Data Access Object"));
			cardRepository.save(new Card("JPA", Category.SIGLE,"Que veut dire le sigle : JPA ?","Java Persistence API ?"));
			cardRepository.save(new Card("GAV", Category.SIGLE,"Que veut dire le sigle : GAV ?","Group ID, Artifact ID et Version. Pré-requis du POM.xml : nécessaire à une architecture Maven"));
			cardRepository.save(new Card("JVM", Category.SIGLE,"Que veut dire le sigle : JVM ?","Java Virtual-Machine"));
			cardRepository.save(new Card("POO", Category.SIGLE,"Que veut dire le sigle : POO ?","Programmation Orientée Objet"));
			cardRepository.save(new Card("DCU", Category.SIGLE,"Que veut dire le sigle : DCU ?","Diagramme de Cas d'Utilisation"));
			cardRepository.save(new Card("DC", Category.SIGLE,"Que veut dire le sigle : DC ?","Diagramme de Classes"));
			cardRepository.save(new Card("DLL", Category.SIGLE,"Que veut dire le sigle : DLL ?","Dynamic Link Library"));
			cardRepository.save(new Card("ORM", Category.SIGLE,"Que veut dire le sigle : ORM ?","Object-Relational Mapping : type de programme informatique qui se place en interface entre un programme applicatif et une base de données relationnelle pour simuler une base de données orientée objet."));
			cardRepository.save(new Card("API_REST", Category.SIGLE,"Que veut dire le sigle : API REST ?","API REpresentational State Transfer : Style d'architecture logicielle définissant un ensemble de contraintes à utiliser pour créer des services web"));
			//cardRepository.save(new Card("MOT", Category.SIGLE,"Que veut dire le sigle : MOT ?",""));

			cardRepository.save(new Card("JSON", Category.EXTENSION,"A quoi correspond cette extension : JSON",""));
			cardRepository.save(new Card("XML", Category.EXTENSION,"A quoi correspond cette extension : XML",""));
			cardRepository.save(new Card("TXT", Category.EXTENSION,"A quoi correspond cette extension : TXT","Texte : MIME Type : text/plain"));
			cardRepository.save(new Card("SQL", Category.EXTENSION,"A quoi correspond cette extension : SQL","Structured Query Language"));
			cardRepository.save(new Card("CSV", Category.EXTENSION,"A quoi correspond cette extension : CSV","Comma Separated Value"));
			cardRepository.save(new Card("WAR", Category.EXTENSION,"A quoi correspond cette extension : WAR","Web ARchive"));
			cardRepository.save(new Card("JAR", Category.EXTENSION,"A quoi correspond cette extension : JAR","Java ARchive"));

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
			cardRepository.save(new Card("hibernate", Category.SOFTWARE,"Qu'est-ce que le logiciel Hibernate ?","Hibernate est un framework open source gérant la persistance des objets en base de données relationnelle. C'est un ORM développé par Red Hat. V1 23 mai 2011."));

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
		
		List<Passage> passages = passageRepository.findByUserId(1, Pageable.ofSize(10)).toList();
		System.out.println(passages);
		try {
			passageService.insertPassage(1,3);
			passageService.insertPassage(2,5);
			passageService.insertPassage(250,3);
			passageService.insertPassage(2,250);
			passageService.insertPassage(250,250);
		} catch (Exception e) {
			// ignorer
		}
	}
}

// --spring.profiles.active=dev
// --spring.profiles.active=test
