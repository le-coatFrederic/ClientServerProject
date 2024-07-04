# ClientServerProject

Pour démarrer le projet, il faut ouvrir 3 terminaux et aller dans : 
/Client
/magasin
/magasin-central

pour le terminal de /client, faire :
mvn clean package;java -jar .\target\client-1.0-SNAPSHOT.jar

pour /magasin :
mvn clean package;java -jar .\target\heptathlon-1.0-SNAPSHOT.jar

et pour /magasin-central :
mvn clean package;java -jar .\target\magasin-central-1.0-SNAPSHOT.jar
