package fr.dawan.flashcards.records.config;

import fr.dawan.flashcards.business.card.*;
import fr.dawan.flashcards.business.passage.*;
import fr.dawan.flashcards.business.user.Role;
import fr.dawan.flashcards.business.user.User;
import fr.dawan.flashcards.business.user.UserServiceBDD;
import fr.dawan.flashcards.security.auth.RegisterDto;

import java.time.LocalDate;
import java.util.List;

// Does it need any Annotation ?? GG BG
public class ConfigData {

    // Useless ??
    private CardServiceBDD cardService;
    private UserServiceBDD userService;
    private PassageServiceBDD passageService;


    // Créer trois méthodes privées qui retournent les données :: Factoriser le code
    public static void main(String[] args) {

        List<RegisterDto> userDtos = null;

        List<Passage> passages = null;


        /**
         * Je set-up un User témoin
         *
         * C'est par défaut l'utilisateur PUBLIC ?
         */
        User temoin = new User();
        temoin.setName("temoin").setEmail("temoin@mail.ff").setRole(Role.USER);

        List<Card> cardList = null;

        //cardList.add(new Card("MOT", Category.SIGLE,"Que veut dire le sigle : MOT ?",""));

        cardList.add(new Card("temoin", Category.TEST, "Question Témoin", "Réponse Témoin"));
        cardList.add(new Card("allouer", Category.DEFINITION, "Qu'est ce que \"allouer\" signifie ?", "En informatique, l'allocation est le fait d'associer un espace de mémoire à certaines données ou à un programme pour son exécution."));
        cardList.add(new Card("service", Category.DEFINITION, "Qu'est ce qu'un \"service\" ?", "En informatique, un service est une fonctionnalité ou partie de fonctionnalité mise à disposition par un composant logiciel pour assurer une tâche particulière. Elle se présente sous forme de boîte noire, présentant uniquement son interface logicielle : nom du service, des fonctions qu'il inclut avec les variables d'entrée requises et sorties produites, et d'éventuelles données complémentaires informatives sur le service | https://fr.wikipedia.org/wiki/Service"));
        cardList.add(new Card("abstraction", Category.DEFINITION, "Qu'est ce qu'une \"abstraction\" ?", "Dans le contexte orienté objet, l'abstraction est un mécanisme, ou une pratique, servant à réduire le code d'un niveau de détail. Autrement dit, l'abstraction permet de regrouper un certain nombre de classes selon des caractéristiques communes."));
        cardList.add(new Card("interface", Category.DEFINITION, "Qu'est ce qu'une \"interface\" ?", "Une interface définit la frontière de communication entre deux entités. On appelle aussi interfaces des dispositifs fournissant un moyen de traduction entre des entités qui n'utilisent pas le même langage, comme entre un être humain et un ordinateur."));
        cardList.add(new Card("classe", Category.DEFINITION, "Qu'est ce qu'une \"classe\" ?", "En programmation orientée objet, la déclaration d'une classe regroupe des membres, méthodes et propriétés (attributs) communs à un ensemble d'objets. La classe déclare, d'une part, des attributs représentant l'état des objets et, d'autre part, des méthodes représentant leur comportement."));
        cardList.add(new Card("dependance", Category.DEFINITION, "Qu'est ce qu'une \"dépendance fonctionnelle\" ?", "En théorie des bases de données relationnelles, une dépendance fonctionnelle est une contrainte entre deux ensembles d'attributs dans une relation (table) d'une base de données"));

        cardList.add(new Card("objet", Category.DEFINITION, "Qu'est ce qu'un \"objet\" en programmation ?", ""));
        cardList.add(new Card("algorithme", Category.DEFINITION, "Qu'est ce qu'un \"algorithme\" ?", ""));
        cardList.add(new Card("heritage", Category.DEFINITION, "Qu'est ce qu'un \"heritage\" ?", ""));
        cardList.add(new Card("encapsulation", Category.DEFINITION, "Qu'est ce que l' \"encapsulation\" ? Quels sont ces avantages ?", ""));
        cardList.add(new Card("requete", Category.DEFINITION, "Qu'est ce qu'une \"requête\" ? Donner 3 exemples.", ""));
        cardList.add(new Card("cyclomatique", Category.DEFINITION, "Qu'est ce que la \"complexité cyclomatique\" ?", ""));
        cardList.add(new Card("dette_technique", Category.DEFINITION, "Qu'est ce que la \"dette technique\" ?", ""));
        cardList.add(new Card("propriete", Category.DEFINITION, "Qu'est ce qu'une\"propriété\" signifie ?", ""));
        cardList.add(new Card("configuration", Category.DEFINITION, "Qu'est ce qu'une \"configuration\" ?", ""));
        cardList.add(new Card("implementation", Category.DEFINITION, "Qu'est ce qu'une \"implémentation\" ?", ""));
        cardList.add(new Card("controller", Category.DEFINITION, "Qu'est ce qu'un \"controller\" ?", ""));
        cardList.add(new Card("reflexion", Category.DEFINITION, "Qu'est ce que la \"réflexion\" signifie ?", ""));
        cardList.add(new Card("genericite", Category.DEFINITION, "Qu'est ce que la \"généricité\" signifie ?", ""));
        cardList.add(new Card("package", Category.DEFINITION, "Qu'est ce qu'un \"package\" ?", ""));
        cardList.add(new Card("invoquer", Category.DEFINITION, "Qu'est ce qu' \"invoquer\" signifie ?", ""));
        cardList.add(new Card("exceptions", Category.DEFINITION, "Qu'est ce qu'une \"exception\" ?", ""));
        cardList.add(new Card("permissif", Category.DEFINITION, "Qu'est ce que le terme \"permissif\" signifie ?", ""));
        cardList.add(new Card("statique", Category.DEFINITION, "Qu'est ce que le terme \"statique\" signifie ?", ""));
        cardList.add(new Card("specifique", Category.DEFINITION, "Qu'est ce que le terme \"spécifique\" signifie ?", ""));
        cardList.add(new Card("thread", Category.DEFINITION, "Qu'est ce qu'un \"thread\" ?", ""));
        cardList.add(new Card("visibilite", Category.DEFINITION, "Qu'est ce que le terme \"visibilité\" signifie ? Citez les 4 valeurs", ""));
        cardList.add(new Card("restfull", Category.DEFINITION, "Qu'est ce que le terme \"restfull\" signifie ?", ""));
        cardList.add(new Card("annotation", Category.DEFINITION, "Qu'est ce qu'une\"annotation\" ?", ""));
        cardList.add(new Card("repository", Category.DEFINITION, "Qu'est ce qu'un \"repository\" ?", ""));
        cardList.add(new Card("audit", Category.DEFINITION, "Qu'est ce qu'un \"audit\" ?", ""));
        cardList.add(new Card("entitee", Category.DEFINITION, "Qu'est ce qu'une \"entité\" ?", ""));
        cardList.add(new Card("injection-dependance", Category.DEFINITION, "Qu'est ce qu'une \"injection de dépendances\" ?", "L'injection de dépendances {dependency (of) injection en anglais} est un mécanisme qui permet d'implémenter le principe de l'inversion de contrôle"));
        cardList.add(new Card("inversion-controle", Category.DEFINITION, "Qu'est ce qu'une \"entité\" ?", "L’inversion de contrôle (inversion of control, IoC) est un patron d'architecture commun à tous les frameworks (ou cadre de développement et d'exécution). Il fonctionne selon le principe que le flot d'exécution d'un logiciel n'est plus sous le contrôle direct de l'application elle-même mais du framework ou de la couche logicielle sous-jacente."));
        cardList.add(new Card("inversion-dependances", Category.DEFINITION, "Qu'est ce qu'une \"inversion des dépendances\" ?", "En programmation orientée objet, le principe d'inversion des dépendances (dependency inversion principle) fait référence à une forme spécifique de découplage des modules logiciels1. Il correspond au « D » de l'acronyme SOLID."));

        cardList.add(new Card("cahier-des-charges", Category.DEFINITION, "Qu'est ce qu'un \"cahier des charges\" ?", ""));
        cardList.add(new Card("plugin", Category.DEFINITION, "Qu'est ce qu'un \"plugin\" ?", ""));
        cardList.add(new Card("cardinalite", Category.DEFINITION, "Qu'est ce qu'une \"cardinalité\" ?", ""));
        cardList.add(new Card("semantique", Category.DEFINITION, "Qu'est ce que le terme \"sémantique\" signifie ?", ""));
        cardList.add(new Card("variable", Category.DEFINITION, "Qu'est ce qu'une \"variable\" ?", ""));
        cardList.add(new Card("variable-systeme", Category.DEFINITION, "Qu'est ce qu'une \"variable système\" ?", ""));
        cardList.add(new Card("variable-environnement", Category.DEFINITION, "Qu'est ce qu'une \"variable d'environnement\" ?", ""));

        cardList.add(new Card("framework", Category.DEFINITION, "Qu'est ce qu'un \"framework\" ?", "En Informatique, un framework {cadre de travail} est un ensemble cohérent de composants logiciels structurels qui sert à créer les fondations ainsi que les grandes lignes de tout ou partie d'un logiciel, c'est-à-dire une architecture."));

        cardList.add(new Card("back-end", Category.ARCHITECTURE, "Qu'est ce que le terme \"back-end\" signifie ?", ""));
        cardList.add(new Card("front-end", Category.ARCHITECTURE, "Qu'est ce que le terme \"front-end\" signifie ?", ""));
        cardList.add(new Card("full-stack", Category.ARCHITECTURE, "Qu'est ce que le terme \"full-stack\" signifie ?", ""));


        cardList.add(new Card("UUID", Category.SIGLE, "Que veut dire le sigle : UUID ?", "Universally Unique IDentifier ?"));
        cardList.add(new Card("DTO", Category.SIGLE, "Que veut dire le sigle : DTO ?", "Data Transfer Object"));
        cardList.add(new Card("SCRUM", Category.SIGLE, "A quoi correspond le sigle : SCRUM ?", "Méthodologie Agile de développement de logiciels : Scrum est considéré comme un groupe de pratiques répondant pour la plupart aux préconisations du manifeste agile.  <mêlée du rugby> "));
        cardList.add(new Card("DAO", Category.SIGLE, "Que veut dire le sigle : DAO ?", "Data Access Object"));
        cardList.add(new Card("JPA", Category.SIGLE, "Que veut dire le sigle : JPA ?", "Java Persistence API ?"));
        cardList.add(new Card("GAV", Category.SIGLE, "Que veut dire le sigle : GAV ?", "Group ID, Artifact ID et Version. Pré-requis du POM.xml : nécessaire à une architecture Maven"));
        cardList.add(new Card("JVM", Category.SIGLE, "Que veut dire le sigle : JVM ?", "Java Virtual-Machine"));
        cardList.add(new Card("POO", Category.SIGLE, "Que veut dire le sigle : POO ?", "Programmation Orientée Objet"));
        cardList.add(new Card("DCU", Category.SIGLE, "Que veut dire le sigle : DCU ?", "Diagramme de Cas d'Utilisation"));
        cardList.add(new Card("DC", Category.SIGLE, "Que veut dire le sigle : DC ?", "Diagramme de Classes"));
        cardList.add(new Card("DLL", Category.SIGLE, "Que veut dire le sigle : DLL ?", "Dynamic Link Library"));
        cardList.add(new Card("ORM", Category.SIGLE, "Que veut dire le sigle : ORM ?", "Object-Relational Mapping : type de programme informatique qui se place en interface entre un programme applicatif et une base de données relationnelle pour simuler une base de données orientée objet."));
        cardList.add(new Card("API_REST", Category.SIGLE, "Que veut dire le sigle : API REST ?", "API REpresentational State Transfer : Style d'architecture logicielle définissant un ensemble de contraintes à utiliser pour créer des services web"));

        cardList.add(new Card("JSON", Category.EXTENSION, "A quoi correspond cette extension : JSON", ""));
        cardList.add(new Card("XML", Category.EXTENSION, "A quoi correspond cette extension : XML", ""));
        cardList.add(new Card("TXT", Category.EXTENSION, "A quoi correspond cette extension : TXT", "Texte : MIME Type : text/plain"));
        cardList.add(new Card("SQL", Category.EXTENSION, "A quoi correspond cette extension : SQL", "Structured Query Language"));
        cardList.add(new Card("CSV", Category.EXTENSION, "A quoi correspond cette extension : CSV", "Comma Separated Value"));
        cardList.add(new Card("WAR", Category.EXTENSION, "A quoi correspond cette extension : WAR", "Web ARchive"));
        cardList.add(new Card("JAR", Category.EXTENSION, "A quoi correspond cette extension : JAR", "Java ARchive"));

        cardList.add(new Card("trello", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Trello", ""));
        cardList.add(new Card("jacoco", Category.SOFTWARE, "Quel est la fonction de ce logiciel : JaCoCo", ""));
        cardList.add(new Card("surefire", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Surefire", ""));
        cardList.add(new Card("maven", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Maven", ""));
        cardList.add(new Card("eclipse", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Eclipse", ""));
        cardList.add(new Card("intellij", Category.SOFTWARE, "Quel est la fonction de ce logiciel : IntelliJ", ""));
        cardList.add(new Card("jenkins", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Jenkins", ""));
        cardList.add(new Card("sonarlint", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Sonarlint", ""));
        cardList.add(new Card("sonarqube", Category.SOFTWARE, "Quel est la fonction de ce logiciel : SonarQube", ""));
        cardList.add(new Card("postman", Category.SOFTWARE, "Quel est la fonction de ce logiciel : POST Man", ""));
        cardList.add(new Card("hibernate", Category.SOFTWARE, "Qu'est-ce que le logiciel Hibernate ?", "Hibernate est un framework open source gérant la persistance des objets en base de données relationnelle. C'est un ORM développé par Red Hat. V1 23 mai 2011."));

        cardList.add(new Card("Java", Category.LANGAGE, "Citez moi trois particularités de ce langage : Java", ""));
        cardList.add(new Card("Javascript", Category.LANGAGE, "Citez moi trois particularités de ce langage : Javascript", ""));

        cardList.add(new Card("Angular", Category.FRAMEWORK, "Quels sont les particularités de ce framework : Angular", ""));
        cardList.add(new Card("React", Category.FRAMEWORK, "Quels sont les particularités de ce framework : React", ""));
        cardList.add(new Card("Spring", Category.FRAMEWORK, "Quels sont les particularités de ce framework : Spring", ""));
        cardList.add(new Card("Symfony", Category.FRAMEWORK, "Quels sont les particularités de ce framework : Symfony", ""));


        userDtos.add(new RegisterDto("baptiste", "baptou", "baptiste.l@gmail.com", Role.ADMIN));
        userDtos.add(new RegisterDto("romain", "roro", "romain.c@gmail.com", Role.ADMIN));
        userDtos.add(new RegisterDto("yanis", "yanou", "yanis.a@gmail.com", Role.MODO));
        userDtos.add(new RegisterDto("florian", "floflo", "florian.d@gmail.com", Role.USER));
        userDtos.add(new RegisterDto("chayanne", "chayou", "chayanne.p@gmail.com", Role.USER));
        userDtos.add(new RegisterDto("titouan", "titou", "titouan.m@gmail.com", Role.USER));

        passages.add(new Passage(cardList.get(0), Niveau.NIVEAU1, LocalDate.now(), temoin));
        passages.add(new Passage(cardList.get(0), Niveau.NIVEAU1, LocalDate.now(), temoin));
        passages.add(new Passage(cardList.get(0), Niveau.NIVEAU1, LocalDate.now(), temoin));
        passages.add(new Passage(cardList.get(0), Niveau.NIVEAU1, LocalDate.now(), temoin));
        passages.add(new Passage(cardList.get(0), Niveau.NIVEAU1, LocalDate.now(), temoin));
    }
}
