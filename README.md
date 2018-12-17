# mattsrepository
matts coding repository


Barista Coding Challenge


Overview
For this project I decided to code the solution using the Spring Boot framework. I have used this framework recently, but haven’t done much in terms of developing from scratch, so at minimum I decided this would be a good chance to better understand the framework and some of its functionalities as well as how to use it with the command line interface. I specifically decided to try to leverage the JPA repository queries. I felt this helped reduce some redundant methods that pull the same data.  
Development Tool: Spring Tool Suite Version: 3.9.1.RELEASE
Setup Instructions: 
Source code  https://github.com/mreed08/mattsrepository

How to run code:
Download the code from github link above (download zip) and extract the file.
 
From a command prompt,  go to the demo folder from downloaded file
 
Run Maven Junits and build .jar file - type “mvn package install”
Run source Code - go to “target” folder and run “java -jar barista-0.0.1-SNAPSHOT.jar”

Improvement opportunities
Spring Boot allows loading of data on boot using a schema.sql and data.sql files. I had some issues getting this to work correctly so instead of spending an abundant amount of time on this, I hard coded the saves into the application startup.  Due to this, I believe that is why my junit tests were not able to work to load the data while running ‘mvn tests’.  My assumption is that it is probably a configuration that is easily fixed but didn’t’ want to again spend more time before returning this to you. (Although I will keep looking for why it won’t work because it is driving me crazy!)
I chose to use only 2 domains instead of adding a “DrinkRecipe” domain which would combine the two domains, but this solution worked and should allow for scaling out new drinks and ingredients without any coding changes.

