FROM rsunix/yourkit-openjdk17

ADD target/FlashCards.jar FlashCards.jar
ENTRYPOINT ["java", "-jar", "FlashCards.jar"]
EXPOSE 8080
