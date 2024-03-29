package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.card.Card;
import fr.dawan.flashcards.business.card.Category;
import fr.dawan.flashcards.business.passage.Passage;

import java.util.List;

public class Tiroir {

    private List<Card> tiroir;

    private User user;

    private void initTiroir() {
      /*tiroir.addAll({
              Card("temoin", Category.TEST, "Question Témoin", "Réponse Témoin"),
              Card("allouer", Category.DEFINITION, "Qu'est ce que \"allouer\" signifie ?", "En informatique, l'allocation est le fait d'associer un espace de mémoire à certaines données ou à un programme pour son exécution.")
      });*/
      tiroir.add(new Card("temoin", Category.TEST, "Question Témoin", "Réponse Témoin"));
      tiroir.add(new Card("allouer", Category.DEFINITION, "Qu'est ce que \"allouer\" signifie ?", "En informatique, l'allocation est le fait d'associer un espace de mémoire à certaines données ou à un programme pour son exécution."));
      tiroir.add(new Card("service", Category.DEFINITION, "Qu'est ce qu'un \"service\" ?", "En informatique, un service est une fonctionnalité ou partie de fonctionnalité mise à disposition par un composant logiciel pour assurer une tâche particulière. Elle se présente sous forme de boîte noire, présentant uniquement son interface logicielle : nom du service, des fonctions qu'il inclut avec les variables d'entrée requises et sorties produites, et d'éventuelles données complémentaires informatives sur le service | https://fr.wikipedia.org/wiki/Service"));
      tiroir.add(new Card("abstraction", Category.DEFINITION, "Qu'est ce qu'une \"abstraction\" ?", "Dans le contexte orienté objet, l'abstraction est un mécanisme, ou une pratique, servant à réduire le code d'un niveau de détail. Autrement dit, l'abstraction permet de regrouper un certain nombre de classes selon des caractéristiques communes."));
      tiroir.add(new Card("interface", Category.DEFINITION, "Qu'est ce qu'une \"interface\" ?", "Une interface définit la frontière de communication entre deux entités. On appelle aussi interfaces des dispositifs fournissant un moyen de traduction entre des entités qui n'utilisent pas le même langage, comme entre un être humain et un ordinateur."));
      tiroir.add(new Card("classe", Category.DEFINITION, "Qu'est ce qu'une \"classe\" ?", "En programmation orientée objet, la déclaration d'une classe regroupe des membres, méthodes et propriétés (attributs) communs à un ensemble d'objets. La classe déclare, d'une part, des attributs représentant l'état des objets et, d'autre part, des méthodes représentant leur comportement."));
      tiroir.add(new Card("dependance", Category.DEFINITION, "Qu'est ce qu'une \"dépendance fonctionnelle\" ?", "En théorie des bases de données relationnelles, une dépendance fonctionnelle est une contrainte entre deux ensembles d'attributs dans une relation (table) d'une base de données"));
      tiroir.add(new Card("objet", Category.DEFINITION, "Qu'est ce qu'un \"objet\" en programmation ?", ""));
      tiroir.add(new Card("algorithme", Category.DEFINITION, "Qu'est ce qu'un \"algorithme\" ?", ""));
      tiroir.add(new Card("heritage", Category.DEFINITION, "Qu'est ce qu'un \"heritage\" ?", ""));
      tiroir.add(new Card("encapsulation", Category.DEFINITION, "Qu'est ce que l' \"encapsulation\" ? Quels sont ces avantages ?", ""));
      tiroir.add(new Card("requete", Category.DEFINITION, "Qu'est ce qu'une \"requête\" ? Donner 3 exemples.", ""));
      tiroir.add(new Card("cyclomatique", Category.DEFINITION, "Qu'est ce que la \"complexité cyclomatique\" ?", ""));
      tiroir.add(new Card("dette_technique", Category.DEFINITION, "Qu'est ce que la \"dette technique\" ?", ""));
      tiroir.add(new Card("propriete", Category.DEFINITION, "Qu'est ce qu'une\"propriété\" signifie ?", ""));
      tiroir.add(new Card("configuration", Category.DEFINITION, "Qu'est ce qu'une \"configuration\" ?", ""));
      tiroir.add(new Card("implementation", Category.DEFINITION, "Qu'est ce qu'une \"implémentation\" ?", ""));
      tiroir.add(new Card("controller", Category.DEFINITION, "Qu'est ce qu'un \"controller\" ?", ""));
      tiroir.add(new Card("reflexion", Category.DEFINITION, "Qu'est ce que la \"réflexion\" signifie ?", ""));
      tiroir.add(new Card("genericite", Category.DEFINITION, "Qu'est ce que la \"généricité\" signifie ?", ""));
      tiroir.add(new Card("package", Category.DEFINITION, "Qu'est ce qu'un \"package\" ?", ""));
      tiroir.add(new Card("invoquer", Category.DEFINITION, "Qu'est ce qu' \"invoquer\" signifie ?", ""));
      tiroir.add(new Card("exceptions", Category.DEFINITION, "Qu'est ce qu'une \"exception\" ?", ""));
      tiroir.add(new Card("permissif", Category.DEFINITION, "Qu'est ce que le terme \"permissif\" signifie ?", ""));
      tiroir.add(new Card("statique", Category.DEFINITION, "Qu'est ce que le terme \"statique\" signifie ?", ""));
      tiroir.add(new Card("specifique", Category.DEFINITION, "Qu'est ce que le terme \"spécifique\" signifie ?", ""));
      tiroir.add(new Card("thread", Category.DEFINITION, "Qu'est ce qu'un \"thread\" ?", ""));
      tiroir.add(new Card("visibilite", Category.DEFINITION, "Qu'est ce que le terme \"visibilité\" signifie ? Citez les 4 valeurs", ""));
      tiroir.add(new Card("restfull", Category.DEFINITION, "Qu'est ce que le terme \"restfull\" signifie ?", ""));
      tiroir.add(new Card("annotation", Category.DEFINITION, "Qu'est ce qu'une\"annotation\" ?", ""));
      tiroir.add(new Card("repository", Category.DEFINITION, "Qu'est ce qu'un \"repository\" ?", ""));
      tiroir.add(new Card("audit", Category.DEFINITION, "Qu'est ce qu'un \"audit\" ?", ""));
      tiroir.add(new Card("entitee", Category.DEFINITION, "Qu'est ce qu'une \"entité\" ?", ""));
      tiroir.add(new Card("injection-dependance", Category.DEFINITION, "Qu'est ce qu'une \"injection de dépendances\" ?", "L'injection de dépendances {dependency (of) injection en anglais} est un mécanisme qui permet d'implémenter le principe de l'inversion de contrôle"));
      tiroir.add(new Card("inversion-controle", Category.DEFINITION, "Qu'est ce qu'une \"entité\" ?", "L’inversion de contrôle (inversion of control, IoC) est un patron d'architecture commun à tous les frameworks (ou cadre de développement et d'exécution). Il fonctionne selon le principe que le flot d'exécution d'un logiciel n'est plus sous le contrôle direct de l'application elle-même mais du framework ou de la couche logicielle sous-jacente."));
      tiroir.add(new Card("inversion-dependances", Category.DEFINITION, "Qu'est ce qu'une \"inversion des dépendances\" ?", "En programmation orientée objet, le principe d'inversion des dépendances (dependency inversion principle) fait référence à une forme spécifique de découplage des modules logiciels1. Il correspond au « D » de l'acronyme SOLID."));

      tiroir.add(new Card("cahier-des-charges", Category.DEFINITION, "Qu'est ce qu'un \"cahier des charges\" ?", ""));
      tiroir.add(new Card("plugin", Category.DEFINITION, "Qu'est ce qu'un \"plugin\" ?", ""));
      tiroir.add(new Card("cardinalite", Category.DEFINITION, "Qu'est ce qu'une \"cardinalité\" ?", ""));
      tiroir.add(new Card("semantique", Category.DEFINITION, "Qu'est ce que le terme \"sémantique\" signifie ?", ""));
      tiroir.add(new Card("variable", Category.DEFINITION, "Qu'est ce qu'une \"variable\" ?", ""));
      tiroir.add(new Card("variable-systeme", Category.DEFINITION, "Qu'est ce qu'une \"variable système\" ?", ""));
      tiroir.add(new Card("variable-environnement", Category.DEFINITION, "Qu'est ce qu'une \"variable d'environnement\" ?", ""));

      tiroir.add(new Card("framework", Category.DEFINITION, "Qu'est ce qu'un \"framework\" ?", "En Informatique, un framework {cadre de travail} est un ensemble cohérent de composants logiciels structurels qui sert à créer les fondations ainsi que les grandes lignes de tout ou partie d'un logiciel, c'est-à-dire une architecture."));

      tiroir.add(new Card("back-end", Category.ARCHITECTURE, "Qu'est ce que le terme \"back-end\" signifie ?", ""));
      tiroir.add(new Card("front-end", Category.ARCHITECTURE, "Qu'est ce que le terme \"front-end\" signifie ?", ""));
      tiroir.add(new Card("full-stack", Category.ARCHITECTURE, "Qu'est ce que le terme \"full-stack\" signifie ?", ""));


      tiroir.add(new Card("UUID", Category.SIGLE, "Que veut dire le sigle : UUID ?", "Universally Unique IDentifier ?"));
      tiroir.add(new Card("DTO", Category.SIGLE, "Que veut dire le sigle : DTO ?", "Data Transfer Object"));
      tiroir.add(new Card("SCRUM", Category.SIGLE, "A quoi correspond le sigle : SCRUM ?", "Méthodologie Agile de développement de logiciels : Scrum est considéré comme un groupe de pratiques répondant pour la plupart aux préconisations du manifeste agile.  <mêlée du rugby> "));
      tiroir.add(new Card("DAO", Category.SIGLE, "Que veut dire le sigle : DAO ?", "Data Access Object"));
      tiroir.add(new Card("JPA", Category.SIGLE, "Que veut dire le sigle : JPA ?", "Java Persistence API ?"));
      tiroir.add(new Card("GAV", Category.SIGLE, "Que veut dire le sigle : GAV ?", "Group ID, Artifact ID et Version. Pré-requis du POM.xml : nécessaire à une architecture Maven"));
      tiroir.add(new Card("JVM", Category.SIGLE, "Que veut dire le sigle : JVM ?", "Java Virtual-Machine"));
      tiroir.add(new Card("POO", Category.SIGLE, "Que veut dire le sigle : POO ?", "Programmation Orientée Objet"));
      tiroir.add(new Card("DCU", Category.SIGLE, "Que veut dire le sigle : DCU ?", "Diagramme de Cas d'Utilisation"));
      tiroir.add(new Card("DC", Category.SIGLE, "Que veut dire le sigle : DC ?", "Diagramme de Classes"));
      tiroir.add(new Card("DLL", Category.SIGLE, "Que veut dire le sigle : DLL ?", "Dynamic Link Library"));
      tiroir.add(new Card("ORM", Category.SIGLE, "Que veut dire le sigle : ORM ?", "Object-Relational Mapping : type de programme informatique qui se place en interface entre un programme applicatif et une base de données relationnelle pour simuler une base de données orientée objet."));
      tiroir.add(new Card("API_REST", Category.SIGLE, "Que veut dire le sigle : API REST ?", "API REpresentational State Transfer : Style d'architecture logicielle définissant un ensemble de contraintes à utiliser pour créer des services web"));

      tiroir.add(new Card("JSON", Category.EXTENSION, "A quoi correspond cette extension : JSON", ""));
      tiroir.add(new Card("XML", Category.EXTENSION, "A quoi correspond cette extension : XML", "eXtensible Markup Language"));
      tiroir.add(new Card("TXT", Category.EXTENSION, "A quoi correspond cette extension : TXT", "Texte : MIME Type : text/plain"));
      tiroir.add(new Card("SQL", Category.EXTENSION, "A quoi correspond cette extension : SQL", "Structured Query Language"));
      tiroir.add(new Card("CSV", Category.EXTENSION, "A quoi correspond cette extension : CSV", "Comma Separated Value"));
      tiroir.add(new Card("WAR", Category.EXTENSION, "A quoi correspond cette extension : WAR", "Web ARchive"));
      tiroir.add(new Card("JAR", Category.EXTENSION, "A quoi correspond cette extension : JAR", "Java ARchive"));

      tiroir.add(new Card("trello", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Trello", ""));
      tiroir.add(new Card("jacoco", Category.SOFTWARE, "Quel est la fonction de ce logiciel : JaCoCo", ""));
      tiroir.add(new Card("surefire", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Surefire", ""));
      tiroir.add(new Card("maven", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Maven", ""));
      tiroir.add(new Card("eclipse", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Eclipse", ""));
      tiroir.add(new Card("intellij", Category.SOFTWARE, "Quel est la fonction de ce logiciel : IntelliJ", ""));
      tiroir.add(new Card("jenkins", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Jenkins", ""));
      tiroir.add(new Card("sonarlint", Category.SOFTWARE, "Quel est la fonction de ce logiciel : Sonarlint", ""));
      tiroir.add(new Card("sonarqube", Category.SOFTWARE, "Quel est la fonction de ce logiciel : SonarQube", ""));
      tiroir.add(new Card("postman", Category.SOFTWARE, "Quel est la fonction de ce logiciel : POST Man", ""));
      tiroir.add(new Card("hibernate", Category.SOFTWARE, "Qu'est-ce que le logiciel Hibernate ?", "Hibernate est un framework open source gérant la persistance des objets en base de données relationnelle. C'est un ORM développé par Red Hat. V1 23 mai 2011."));

      tiroir.add(new Card("Java", Category.LANGAGE, "Citez moi trois particularités de ce langage : Java", ""));
      tiroir.add(new Card("Javascript", Category.LANGAGE, "Citez moi trois particularités de ce langage : Javascript", ""));

      tiroir.add(new Card("Angular", Category.FRAMEWORK, "Quels sont les particularités de ce framework : Angular", ""));
      tiroir.add(new Card("React", Category.FRAMEWORK, "Quels sont les particularités de ce framework : React", ""));
      tiroir.add(new Card("Spring", Category.FRAMEWORK, "Quels sont les particularités de ce framework : Spring", ""));
      tiroir.add(new Card("Symfony", Category.FRAMEWORK, "Quels sont les particularités de ce framework : Symfony", ""));
    }
}
