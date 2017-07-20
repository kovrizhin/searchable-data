#Searchable-data: Project provide ability for search data

**Overview**
This project provide several pattern for search
-Search by words words, if you write to words they handle as & and result will be more concrete
-Remove words from search result

**Setup**
Project is gradle base application with spring boot, in this case everithing is ease just import project as gradle project

**Start**
It is two way to start the project
1)
cd $home_project_dir
gradle clean build
java -jar build/libs/searchable-data-1.0-SNAPSHOT.jar
2)
gradle clean bootRun

go to http://localhost:8080


**Examples**
Input: 
Sun Microsystems

Output:
Name: Java
Type: Compiled, Curly-bracket, Imperative, Object-oriented class-based, Procedural, Reflective
Designed by: James Gosling, Sun Microsystems

Name: DASL
Type: Object-oriented class-based, Curly-bracket, Procedural
Designed by: Sun Microsystems Laboratories

Input: 
Sun Microsystems -Dasl

Output:
Name: Java
Type: Compiled, Curly-bracket, Imperative, Object-oriented class-based, Procedural, Reflective
Designed by: James Gosling, Sun Microsystems

Input: 
Sun Microsystems Java

Output:
Name: Java
Type: Compiled, Curly-bracket, Imperative, Object-oriented class-based, Procedural, Reflective
Designed by: James Gosling, Sun Microsystems

**Future**
Integrate different datasources, currently it is only allowed load data from file which include in project
Improve UI
Improvments search engine:
    - Add ability to use | between words
    - Make relevante search engine
    - Additioal feature for search engine   



 
 