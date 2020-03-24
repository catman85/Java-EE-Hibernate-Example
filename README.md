# Setup
- Install JDK 11 (Modify the PATH and JAVA_HOME variable)
- Install maven (add the bin folder to the PATH variable)

test with:
 ```shell script
mvn -version
javac -version
```

## Docker Setup (debian)
cd to the project's directory:
```shell script
sudo apt-get install docker.io docker-compose

service docker start && sudo docker-compose up
``` 
You can test everything works fine by accessing the db
from an explorer like dbeaver or the mysql client, and typing something like:
```shell script
mysql -h 192.168.1.8 -P 3308 -u user -p db
````
If you run docker from a linux VirtualBox machine,
make sure to use a **BridgedAdapter** from your network settings.

## DB Setup
If you want to change the database configuration, you will need to modify the 
docker-compose.yml file and the hibernate.cfg.xml file

## IntelliJ Setup
File -> Settings -> Plugins -> Search and install Lombok

File -> Project structure -> Project -> Project SDK -> 11.

File -> Project structure -> Project -> Project language level -> 11. 
## Execute
Go to the project's directory and run:
```shell script
mvn -e -X install exec:java
```
or hit shift + F10 from IntelliJ. 😎
