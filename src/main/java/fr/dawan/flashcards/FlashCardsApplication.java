package fr.dawan.flashcards;

import fr.dawan.flashcards.business.card.Card;
import fr.dawan.flashcards.business.card.CardRepository;
import fr.dawan.flashcards.business.card.Category;
import fr.dawan.flashcards.business.passage.*;
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

		System.out.println("\t>>>>>>>>> Run before App\n");

		/*
		cardRepository.save(new Card("", Category.TEST, "",""));
		 */

		if (cardRepository.findAll().isEmpty()){
			cardRepository.saveAll(List.of(
			new Card("temoin", Category.TEST, "Question Témoin", "Réponse Témoin"),
			new Card("allouer", Category.DEFINITION, "Qu'est ce que \"allouer\" signifie ?", "En informatique, l'allocation est le fait d'associer un espace de mémoire à certaines données ou à un programme pour son exécution."),
			new Card("service", Category.DEFINITION, "Qu'est ce qu'un \"service\" ?", "En informatique, un service est une fonctionnalité ou partie de fonctionnalité mise à disposition par un composant logiciel pour assurer une tâche particulière. Elle se présente sous forme de boîte noire, présentant uniquement son interface logicielle : nom du service, des fonctions qu'il inclut avec les variables d'entrée requises et sorties produites, et d'éventuelles données complémentaires informatives sur le service | https://fr.wikipedia.org/wiki/Service"),
			new Card("abstraction", Category.DEFINITION, "Qu'est ce qu'une \"abstraction\" ?", "Dans le contexte orienté objet, l'abstraction est un mécanisme, ou une pratique, servant à réduire le code d'un niveau de détail. Autrement dit, l'abstraction permet de regrouper un certain nombre de classes selon des caractéristiques communes."),
			new Card("interface", Category.DEFINITION, "Qu'est ce qu'une \"interface\" ?", "Une interface définit la frontière de communication entre deux entités. On appelle aussi interfaces des dispositifs fournissant un moyen de traduction entre des entités qui n'utilisent pas le même langage, comme entre un être humain et un ordinateur."),
			new Card("classe", Category.DEFINITION, "Qu'est ce qu'une \"classe\" ?", "En programmation orientée objet, la déclaration d'une classe regroupe des membres, méthodes et propriétés (attributs), communs à un ensemble d'objets. La classe déclare, d'une part, des attributs représentant l'état des objets et, d'autre part, des méthodes représentant leur comportement."),
			new Card("dependance", Category.DEFINITION, "Qu'est ce qu'une \"dépendance fonctionnelle\" ?", "En théorie des bases de données relationnelles, une dépendance fonctionnelle est une contrainte entre deux ensembles d'attributs dans une relation (table), d'une base de données"),

			new Card("objet", Category.DEFINITION, "Qu'est ce qu'un \"objet\" en programmation ?", "En informatique, un objet est un conteneur symbolique et autonome qui contient des informations et des mécanismes concernant un sujet, manipulés dans un programme."),
			new Card("algorithme", Category.DEFINITION, "Qu'est ce qu'un \"algorithme\" ?", "Ensemble de règles opératoires dont l'application permet de résoudre un problème énoncé au moyen d'un nombre fini d'opérations. Un algorithme peut être traduit, grâce à un langage de programmation, en un programme exécutable par un ordinateur."),
			new Card("heritage", Category.DEFINITION, "Qu'est ce qu'un \"heritage\" ?", "L'héritage établit une relation de généralisation-spécialisation qui permet d'hériter dans la déclaration d’une nouvelle classe (appelée classe dérivée, classe fille, classe enfant ou sous-classe), des caractéristiques (propriétés et méthodes), de la déclaration d'une autre classe (appelée classe de base, classe mère, classe parent ou super-classe),."),
			new Card("encapsulation", Category.DEFINITION, "Qu'est ce que le principe d'\"encapsulation\" ? Quels sont ces avantages ?", ""),
			new Card("requete", Category.DEFINITION, "Qu'est ce qu'une \"requête\" ? Donner 3 exemples.", "dans un réseau informatique, un message envoyé par un client vers un serveur qui émet une réponse. dans une bases de données, une interrogation de la base. Le client reçoit comme réponse des éléments de cette base correspondant aux critères définis dans la requête. Dans le cas particulier des bases de données relationnelles, le format standard de requête est le SQL"),
			new Card("cyclomatique", Category.DEFINITION, "Qu'est ce que la \"complexité cyclomatique\" ?", "Le nombre cyclomatique, la complexité cyclomatique ou la mesure de McCabe est un outil de métrologie logicielle développé par Thomas McCabe en 1976 pour mesurer la complexité d'un programme informatique. Cette mesure reflète le nombre de décisions d'un algorithme en comptabilisant le nombre de « chemins » linéairement indépendants au travers d'un programme représenté sous la forme d'un graphe."),
			new Card("dette_technique", Category.DEFINITION, "Qu'est ce que la \"dette technique\" ?", "La dette technique est un concept du développement logiciel inventé par Ward Cunningham en 19921. Le terme vient d'une métaphore, inspirée du concept existant de dette dans le domaine des finances et des entreprises, appliquée au domaine du développement logiciel. Elle désigne la difficulté à faire évoluer et à corriger un code source qui a été mal conçu initialement."),
			new Card("propriete", Category.DEFINITION, "Qu'est ce qu'une\"propriété\" signifie ?", "Une propriété, dans certains langages de programmation orientés objet, est une sorte de membre de classe. Il se traduit par un champ du point de vue de l'interface d'une classe, mais auquel sont adjoints une ou plusieurs méthodes, dites accesseurs et mutateurs, vouées à lire (get / accesseur), et modifier (set / mutateur), la valeur du champ de l'instance."),
			new Card("configuration", Category.DEFINITION, "Qu'est ce qu'une \"configuration\" ?", "Ensemble des caractéristiques matérielles et logicielles d'un système informatique (processeur, mémoire, système d'exploitation…),. || Modification ou réglage de paramètres informatiques en vue de l'optimisation du fonctionnement du système."),
			new Card("implementation", Category.DEFINITION, "Qu'est ce qu'une \"implémentation\" ?", "L'implémentation est la réalisation, l'exécution ou la mise en pratique d'un plan, d'une méthode ou bien d'un concept, d'une idée, d'un modèle, d'une spécification, d'une norme ou d'une règle dans un but précis. L'implémentation est donc l'action qui doit suivre une réflexion pour la concrétiser."),
			new Card("controller", Category.DEFINITION, "Qu'est ce qu'un \"contrôleur\" en POO (mvc),?", "Un contrôleur (Controller), contient la logique concernant les actions effectuées par l'utilisateur."),
			new Card("reflexion", Category.DEFINITION, "Qu'est ce que la \"réflexion\" signifie ?", " En programmation informatique, la réflexion est la capacité d'un programme à examiner, et éventuellement à modifier, ses propres structures internes de haut niveau lors de son exécution."),
			new Card("genericite", Category.DEFINITION, "Qu'est ce que la \"généricité\" signifie ?", "En programmation, la généricité (ou programmation générique),, consiste à définir des algorithmes identiques opérant sur des données de types différents. On définit de cette façon des procédures ou des types entiers génériques."),
			new Card("package", Category.DEFINITION, "Qu'est ce qu'un \"package\" ?", "En programmation, le terme paquetage(package), est le nom donné aux bibliothèques logicielles et sert aussi à la partition des espaces de noms."),
			new Card("invoquer", Category.DEFINITION, "En informatique, qu'est ce qu' \"invoquer\" signifie ?", "le terme \"invoquer\" est souvent utilisé dans le contexte de la programmation pour faire référence à l'action d'appeler ou d'exécuter une fonction, une méthode ou un programme .L'invocation est une partie fondamentale de la programmation, car elle permet de réutiliser du code en le décomposant en fonctions, méthodes ou programmes modulaires, que l'on peut invoquer à différents endroits de son code."),
			new Card("exceptions", Category.DEFINITION, "Qu'est ce qu'une \"exception\" ?", "En programmation informatique, une exception est une situation anormale ou imprévue qui se produit pendant l'exécution d'un programme. Les exceptions sont souvent associées à des erreurs qui peuvent survenir pendant l'exécution d'un programme et qui empêchent le flux normal d'instructions. La gestion appropriée des exceptions contribue à rendre les programmes plus robustes en anticipant et en traitant les erreurs potentielles de manière élégante, plutôt que de provoquer des arrêts abrupts ou des comportements inattendus."),
			new Card("permissif", Category.DEFINITION, "Qu'est ce qu'une \"licence permissive\" ?", " Une licence permissive, ou licence open source permissive, se réfère à un type de licence qui accorde aux utilisateurs un large ensemble de droits pour utiliser, modifier et distribuer le logiciel. "),
			new Card("statique", Category.DEFINITION, "Qu'elles sont les concepts de terme \"statique\" ?", "Ces utilisations du terme \"statique\" partagent le concept de quelque chose qui est fixe, déterminé à l'avance, ou qui ne change pas dynamiquement pendant l'exécution du programme."),
			new Card("statique", Category.DEFINITION, "Qu'est ce qu'une \"analyse statique\" ?", "L'analyse statique fait référence à l'examen d'un programme informatique sans l'exécuter. Cela peut inclure la vérification du code source pour détecter des erreurs potentielles, des violations de style, ou d'autres problèmes sans avoir besoin de l'exécuter."),
			new Card("statique", Category.DEFINITION, "Qu'est ce qu'un \"typage statique\" ?", " Le typage statique signifie que le type d'une variable est vérifié au moment de la compilation du programme plutôt qu'au moment de son exécution. Les langages de programmation avec un typage statique exigent que les variables soient déclarées avec un type spécifique et que ces types soient respectés tout au long du programme."),
			new Card("statique", Category.DEFINITION, "Qu'est ce qu'une \"allocation statique de mémoire\" ?", "L'allocation statique de mémoire se produit au moment de la compilation du programme. Cela signifie que l'espace mémoire nécessaire pour les variables est réservé à l'avance, et la taille de la mémoire allouée ne change pas pendant l'exécution du programme."),
			new Card("statique", Category.DEFINITION, "Qu'est ce qu'une \"page statique\" dans le contexte Web ?", "Une page statique est une page web dont le contenu est fixe et ne change pas dynamiquement en fonction de l'interaction de l'utilisateur. Elle est généralement écrite en HTML et peut inclure des images, des textes, et des liens, mais ces éléments restent inchangés, sauf si la page elle-même est modifiée."),
			new Card("statique", Category.DEFINITION, "Qu'est ce qu'une \"méthode statique\" dans le contexte de POO ?", "Une méthode statique est une méthode liée à la classe plutôt qu'à une instance spécifique de la classe. Elle peut être appelée sans avoir besoin d'instancier un objet de la classe."),
			new Card("specifique", Category.DEFINITION, "Qu'est ce que le terme \"spécifique\" signifie ?", "En résumé, le terme \"spécifique\" est utilisé pour mettre en évidence ce qui est distinct, particulier ou propre à une personne, à un objet, à un groupe ou à une situation particulière dans un contexte donné."),
			new Card("thread", Category.DEFINITION, "Qu'est ce qu'un \"thread\" ?", "un \"thread\" (fil ou processus léger en français), est une séquence d'instructions qui peut être exécutée par un processeur. Un thread est une unité d'exécution plus petite qu'un processus, mais elle partage les mêmes ressources d'un processus, telles que l'espace mémoire. Il existe deux types de threads : Kernel-level threads & User-level threads"),
			new Card("visibilite", Category.DEFINITION, "Qu'est ce que le terme \"visibilité\" signifie ? Citez les 4 valeurs", ""),
			new Card("restfull", Category.DEFINITION, "Qu'est ce que le terme \"restfull\" signifie ?", "Le terme \"visibilité\" dans le contexte de la programmation concerne généralement la portée des variables, c'est-à-dire la partie du code où une variable peut être utilisée ou modifiée. Il y a plusieurs niveaux de visibilité, généralement définis par le lieu où une variable est déclarée. Public, Private, Protected, Default/package-private"),
			new Card("annotation", Category.DEFINITION, "Qu'est ce qu'une\"@annotation\" ?", "Le terme Annotation fait référence à des mécanismes permettant d'ajouter des métadonnées ou des informations supplémentaires à du code source, des documents ou d'autres éléments. Les annotations peuvent être utilisées dans divers langages de programmation, outils de développement, et même dans des contextes tels que la documentation et la modélisation."),
			new Card("repository", Category.DEFINITION, "Qu'est ce qu'un \"repository\" ?", "Le terme \"repository\" (ou dépôt en français), a plusieurs significations selon le contexte, mais dans le domaine de l'informatique et du développement logiciel, il est généralement associé à la gestion de versions, au stockage de code source et à la collaboration entre développeurs. Exemples : VCS-Système de gestion de versions (Git), ou encore Dépôt de logiciels (package repo like npm, apt, maven),"),
			new Card("audit", Category.DEFINITION, "Qu'est ce qu'un \"audit\" ?", "Audit informatique : Un examen des systèmes informatiques, des procédures et des contrôles de sécurité pour évaluer la protection des données, la conformité aux politiques de sécurité, et la résilience contre les menaces informatiques."),
			new Card("entitee", Category.DEFINITION, "Qu'est ce qu'une \"entité\" dans le contexte d'une BDD ?", "En base de données, une entité représente généralement un objet distinct ou une personne que l'on souhaite suivre. Par exemple, dans une base de données client, chaque client serait considéré comme une entité, et ses caractéristiques (nom, adresse, numéro de téléphone, etc.), seraient enregistrées comme des attributs associés à cette entité."),
			new Card("entitee", Category.DEFINITION, "Qu'est ce qu'une \"entité\" dans le contexte de POO ?", "En programmation orientée objet, une entité peut être une instance d'une classe. Les classes définissent des modèles pour créer des objets, et chaque objet créé à partir de ces modèles est considéré comme une entité."),
			new Card("injection-dependance", Category.DEFINITION, "Qu'est ce qu'une \"injection de dépendances\" ?", "L'injection de dépendances {dependency (of), injection en anglais} est un mécanisme qui permet d'implémenter le principe de l'inversion de contrôle"),
			new Card("inversion-controle", Category.DEFINITION, "Qu'est ce qu'une \"entité\" ?", "L’inversion de contrôle (inversion of control, IoC), est un patron d'architecture commun à tous les frameworks (ou cadre de développement et d'exécution),. Il fonctionne selon le principe que le flot d'exécution d'un logiciel n'est plus sous le contrôle direct de l'application elle-même mais du framework ou de la couche logicielle sous-jacente."),
			new Card("inversion-dependances", Category.DEFINITION, "Qu'est ce qu'une \"inversion des dépendances\" ?", "En programmation orientée objet, le principe d'inversion des dépendances (dependency inversion principle), fait référence à une forme spécifique de découplage des modules logiciels1. Il correspond au « D » de l'acronyme SOLID."),

			new Card("cahier-des-charges", Category.DEFINITION, "Qu'est ce qu'un \"cahier des charges\" ?", "Un cahier des charges est un document qui spécifie les exigences, les caractéristiques, les fonctionnalités et les contraintes d'un projet. Il sert de référence commune entre les parties prenantes (clients, développeurs, etc.), pour garantir une compréhension claire des attentes et des objectifs du projet."),
			new Card("user-story", Category.DEFINITION, "Qu'est ce qu'une \"User Story\" ?", "A user story is a short, simple description of a feature told from the perspective of the person who desires the new capability, usually a user or customer of the system. TEMPLATE = As a <type of user>, I want <some goal> so that <some reason>."),
			new Card("plugin", Category.DEFINITION, "Qu'est ce qu'un \"plugin\" ?", "Un plugin, également appelé module d'extension, est un logiciel additionnel qui s'intègre à un programme existant pour étendre ou enrichir ses fonctionnalités. Les plugins sont couramment utilisés dans les applications pour permettre une personnalisation ou l'ajout de nouvelles fonctionnalités sans modifier le programme de base."),
			new Card("cardinalite", Category.DEFINITION, "Qu'est ce qu'une \"cardinalité\" ?", "En informatique et en bases de données, la cardinalité fait référence au nombre d'éléments dans un ensemble ou à la relation entre deux ensembles. Par exemple, la cardinalité d'une relation entre deux tables de base de données peut indiquer combien d'entrées dans une table peuvent être associées à une entrée dans une autre table."),
			new Card("semantique", Category.DEFINITION, "Qu'est ce que le terme \"sémantique\" signifie ?", "Le terme \"sémantique\" concerne le sens ou la signification. En informatique, il est souvent utilisé pour décrire le sens des données ou des instructions dans un contexte particulier. Par exemple, la sémantique d'un langage de programmation se réfère à la signification des constructions et des expressions dans ce langage."),
			new Card("variable", Category.DEFINITION, "Qu'est ce qu'une \"variable\" ?", "En programmation informatique, une variable est un espace de stockage nommé qui peut contenir une valeur ou une référence à une valeur. Les variables sont utilisées pour stocker et manipuler des données dans un programme."),
			new Card("variable-systeme", Category.DEFINITION, "Qu'est ce qu'une \"variable système\" ?", "Une variable système est une variable utilisée par le système d'exploitation pour stocker des informations spécifiques au système, telles que des paramètres de configuration ou des informations sur l'environnement d'exécution. Ces variables sont souvent utilisées par le système et les applications pour communiquer et partager des données."),
			new Card("variable-environnement", Category.DEFINITION, "Qu'est ce qu'une \"variable d'environnement\" ?", "Une variable d'environnement est une variable dont la portée est définie par l'environnement dans lequel un processus s'exécute. Ces variables sont utilisées pour stocker des informations telles que les chemins d'accès aux fichiers, les paramètres de configuration ou d'autres informations spécifiques à l'environnement d'exécution d'une application."),

			new Card("framework", Category.DEFINITION, "Qu'est ce qu'un \"framework\" ?", "En Informatique, un framework {cadre de travail} est un ensemble cohérent de composants logiciels structurels qui sert à créer les fondations ainsi que les grandes lignes de tout ou partie d'un logiciel, c'est-à-dire une architecture."),

			new Card("back-end", Category.ARCHITECTURE, "Qu'est ce que le terme \"back-end\" signifie ?", "Le terme \"back-end\" se réfère à la partie invisible d'une application ou d'un site web, gérant les opérations en coulisses, comme la gestion des données, la logique métier et les interactions avec la base de données."),
			new Card("front-end", Category.ARCHITECTURE, "Qu'est ce que le terme \"front-end\" signifie ?", "Le terme \"front-end\" se rapporte à la partie visible et interactive d'une application ou d'un site web, avec laquelle les utilisateurs interagissent directement. Cela inclut l'interface utilisateur, la présentation des données, et les interactions utilisateur."),
			new Card("full-stack", Category.ARCHITECTURE, "Qu'est ce que le terme \"full-stack\" signifie ?", "Le terme \"full-stack\" fait référence à la capacité de travailler à la fois sur le \"front-end\" et le \"back-end\" d'une application. Un développeur \"full-stack\" est capable de gérer toutes les facettes du développement logiciel, de la conception de l'interface utilisateur à la gestion des données en coulisses."),


			new Card("UUID", Category.SIGLE, "Que veut dire le sigle : UUID ?", "Translation: Universally Unique Identifier Definition: A UUID is a 128-bit identifier that is globally unique, often used to uniquely identify information in distributed systems."),
			new Card("DTO", Category.SIGLE, "Que veut dire le sigle : DTO ?", "Translation: Data Transfer Object Definition: A DTO is a design pattern used to transfer data between software application subsystems, containing only data attributes without business logic."),
			new Card("SCRUM", Category.SIGLE, "A quoi correspond le sigle : SCRUM ?", "Méthodologie Agile de développement de logiciels : Scrum est considéré comme un groupe de pratiques répondant pour la plupart aux préconisations du manifeste agile.  <mêlée du rugby>. Scrum est un cadre de gestion de projet agile utilisé pour le développement logiciel, mettant l'accent sur des processus itératifs et incrémentaux. "),
			new Card("DAO", Category.SIGLE, "Que veut dire le sigle : DAO ?", "Data Access Object : Objet d'Accès aux Données : DAO est un modèle de conception qui fournit une interface abstraite à un type de base de données ou à un autre mécanisme de persistance, permettant la séparation entre la logique métier et l'accès aux données."),
			new Card("JPA", Category.SIGLE, "Que veut dire le sigle : JPA ?", "Java Persistence API : JPA est une spécification Java pour la gestion des données relationnelles dans les applications Java, offrant une manière standard d'interagir avec les bases de données en utilisant des objets Java."),
			new Card("GAV", Category.SIGLE, "Que veut dire le sigle : GAV ?", "Group ID, Artifact ID et Version. Pré-requis du POM.xml : nécessaire à une architecture Maven pour identifier de manière unique et localiser la dépendance d'un projet spécifique dans un référentiel."),
			new Card("JVM", Category.SIGLE, "Que veut dire le sigle : JVM ?", "Java Virtual-Machine"),
			new Card("POO", Category.SIGLE, "Que veut dire le sigle : POO ?", "Programmation Orientée Objet"),
			new Card("DCU", Category.SIGLE, "Que veut dire le sigle : DCU ?", "Diagramme de Cas d'Utilisation"),
			new Card("DC", Category.SIGLE, "Que veut dire le sigle : DC ?", "Diagramme de Classes"),
			new Card("DLL", Category.SIGLE, "Que veut dire le sigle : DLL ?", "Dynamic Link Library"),
			new Card("DLL", Category.SIGLE, "Que veut dire le sigle : MVC ?", "Modèle-vue-contrôleur"),
			new Card("ORM", Category.SIGLE, "Que veut dire le sigle : ORM ?", "Object-Relational Mapping : type de programme informatique qui se place en interface entre un programme applicatif et une base de données relationnelle pour simuler une base de données orientée objet."),
			new Card("API_REST", Category.SIGLE, "Que veut dire le sigle : API REST ?", "API REpresentational State Transfer : Style d'architecture logicielle définissant un ensemble de contraintes à utiliser pour créer des services web"),

			new Card("JSON", Category.EXTENSION, "A quoi correspond cette extension : JSON", "JSON, ou JavaScript Object Notation, est un format d'échange de données léger, facile à lire et à écrire pour les humains, et facile à analyser et générer pour les machines."),
			new Card("XML", Category.EXTENSION, "A quoi correspond cette extension : XML", "eXtensible Markdown Langage, ou Langage de Balisage Extensible, est un langage de balisage qui définit des règles pour encoder des documents dans un format lisible à la fois par les humains et les machines."),
			new Card("TXT", Category.EXTENSION, "A quoi correspond cette extension : TXT", "Texte : MIME Type : text/plain"),
			new Card("SQL", Category.EXTENSION, "A quoi correspond cette extension : SQL", "Structured Query Language"),
			new Card("CSV", Category.EXTENSION, "A quoi correspond cette extension : CSV", "Comma Separated Value"),
			new Card("WAR", Category.EXTENSION, "A quoi correspond cette extension : WAR", "Web ARchive"),
			new Card("JAR", Category.EXTENSION, "A quoi correspond cette extension : JAR", "Java ARchive"),

			new Card("trello", Category.SOFTWARE, "Quelle est la fonction de ce logiciel : Trello", "Trello est un outil de gestion de projet en ligne qui vous aide à organiser vos tâches et collaborer avec d'autres personnes."),
			new Card("jacoco", Category.SOFTWARE, "Quelle est la fonction de ce logiciel : JaCoCo", "JaCoCo est un outil de mesure de la couverture de code, ce qui signifie qu'il vous aide à comprendre quelle partie de votre code est testée par vos tests automatisés."),
			new Card("surefire", Category.SOFTWARE, "Quelle est la fonction de ce logiciel : Surefire", "Surefire est un plugin de Maven qui s'occupe de l'exécution des tests unitaires de votre projet."),
			new Card("maven", Category.SOFTWARE, "Quelle est la fonction de ce logiciel : Maven", "Maven est un outil de gestion de projet qui vous aide à construire, gérer et documenter votre projet Java."),
			new Card("eclipse", Category.SOFTWARE, "Quelle est la fonction de ce logiciel : Eclipse", "Eclipse est un environnement de développement intégré (IDE), qui vous aide à écrire, compiler, et déboguer votre code."),
			new Card("intellij", Category.SOFTWARE, "Quelle est la fonction de ce logiciel : IntelliJ", "IntelliJ est un environnement de développement intégré (IDE), développé par JetBrains"),
			new Card("jenkins", Category.SOFTWARE, "Quelle est la fonction de ce logiciel : Jenkins", "Jenkins est un outil d'intégration continue qui automatise le processus d'intégration, de test et de déploiement de logiciels."),
			new Card("sonarlint", Category.SOFTWARE, "Quelle est la fonction de ce logiciel : Sonarlint", "SonarLint est un plugin d'analyse de code statique qui vous aide à détecter et corriger les problèmes de qualité du code pendant le développement."),
			new Card("sonarqube", Category.SOFTWARE, "Quelle est la fonction de ce logiciel : SonarQube", "SonarQube est une plateforme d'analyse continue de la qualité du code qui fournit des informations détaillées sur la santé générale de votre code source."),
			new Card("postman", Category.SOFTWARE, "Quelle est la fonction de ce logiciel : POST Man", "Postman est un outil de développement d'API qui permet de tester, développer et documenter les API de manière efficace."),
			new Card("hibernate", Category.SOFTWARE, "Qu'est-ce que le logiciel Hibernate ?", "Hibernate est un framework open source gérant la persistance des objets en base de données relationnelle. C'est un ORM développé par Red Hat. V1 23 mai 2011."),

			new Card("Java", Category.LANGAGE, "Citez moi trois particularités de ce langage : Java", "1.Portabilité et Indépendance de la Plateforme \n2.Orienté Objet \n3.Gestion de la Mémoire Automatique (Garbage collector),"),
			new Card("Javascript", Category.LANGAGE, "Citez moi trois particularités de ce langage : Javascript", "1.Langage de Programmation Côté Client \n2.Asynchrone et Orienté Événements \n3.Polyvalence et Utilisation Étendue (Dev Web Client Side && Server side {NodeJs} && IoT"),

			new Card("Angular", Category.FRAMEWORK, "Quels sont les particularités de ce framework : Angular", ""),
			new Card("React", Category.FRAMEWORK, "Quels sont les particularités de ce framework : React", ""),
			new Card("Spring", Category.FRAMEWORK, "Quels sont les particularités de ce framework : Spring", ""),
			new Card("Symfony", Category.FRAMEWORK, "Quels sont les particularités de ce framework : Symfony", "")));
		}

		if (userRepository.findAll().isEmpty()) {
			authService.register(new RegisterDto("baptiste","baptou","baptiste.l@gmail.com"));
			authService.register(new RegisterDto("romain","roro","romain.c@gmail.com"));
			authService.register(new RegisterDto("yanis","yanou","yanis.a@gmail.com"));
			authService.register(new RegisterDto("florian","floflo","florian.d@gmail.com"));
			authService.register(new RegisterDto("chayanne","chayou","chayanne.p@gmail.com"));
			authService.register(new RegisterDto("titouan","titou","titouan.m@gmail.com"));
		}
		
		List<Passage> passages = passageRepository.findByUserId(1, Pageable.ofSize(10)).toList();
		System.out.println(passages);
		try {
			passageService.insertPassage(1,3);
			passageService.insertPassage(2,5);
			// CECI EST UN TEST JE REPETE
//			passageService.insertPassage(250,3);
//			passageService.insertPassage(2,250);
//			passageService.insertPassage(250,250);
//			passageService.insertPassage(1,70);
//			passageService.insertPassage(1,69);
//			passageService.insertPassage(1,68);
		} catch (Exception e) {
			// ignorer
		}
	}
}

// --spring.profiles.active=dev
// --spring.profiles.active=test
