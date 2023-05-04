default: Driver.java AdventureMap.java Room.java Dog.java
	javac Driver.java AdventureMap.java Room.java 

run: Driver.class AdventureMap.class Room.class Dog.class
	java Driver

clean:
	rm -f *.class