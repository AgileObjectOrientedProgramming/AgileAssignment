# Agile Assignment 
## Group 6 <img src="https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif" width="30px">

Welcome to our repository! 
We will use this repository for our Agile project.

## BDD Assignment
In this assignment we only inluded user stories related to `Clients management`. 
You can find our user stories [here](https://github.com/AgileObjectOrientedProgramming/AgileAssignment/projects/1).

### Our Team
- [Dario Cannistra](https://github.com/dariofornaro)
- [Diana Podoroghin](https://github.com/Diana1907)
- [Dusana Milinkovic](https://github.com/DusanaM)
- [Emma Andreea Chirlomez](https://github.com/emmachirlomez)
- [Paulo Lima](https://github.com/Paulo9608)
- [Renjue Sun](https://github.com/Renjue823)

## Usage

The web server is located in the [WebApp](WebApp/) folder. To run it, you need to have `maven` installed (IDEs like vscode install it automatically).

The unit tests are located [here](WebApp/src/test/java/ForYouShipment).
For running a full test-coverage of the project, open a terminal in the project's folder and use the following command:\
` $ mvnw clean jacoco:prepare-agent install jacoco:report`\
This will generate a corevage file, which can be viewed using extensions such as `Coverage Gutters` for vscode.\
More details about the test coverage can be seen [here](https://medium.com/@clarkjasonngo/junit-test-with-maven-in-vscode-7546eabd50f7).
