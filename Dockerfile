FROM rsunix/yourkit-openjdk17

ADD target/flash-cards.jar flash-cards.jar
ENTRYPOINT ["java", "-jar", "flash-cards.jar"]
EXPOSE 8080
