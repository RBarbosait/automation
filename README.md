# automation
El código se encuentra en el branch > master
Este repositorio corresponde a un script de test automatizado para las funcionalidades> login, crear tablero y crear lista de trello.
Se utilizó Maven, Selenium, Java y TestNG. Este último fue útil para crear un screenshot en caso de que el resultado del test sea FAILURE.
Las screenshots se guardan en > /SeleniumPOMSample/Screenshots

Para ejecutar los test se debe correr como junit el archivo >
/SeleniumPOMSample/src/test/java/Tests/BoardTests.java

Importante >

Se incluye el driver de Chrome > 105.0.5195.52
El driver de Chrome debe ser compatible con la versión de Chrome que se disponga. El mismo se encuentra en >
/SeleniumPOMSample/src/test/resources/driver/chromedriver.exe
En caso de no ser compatible, descargar el driver correspondiente de > https://chromedriver.chromium.org/downloads y remplazar
el archivo actual.

Pasos >

Descargar el repositorio
Verificar el driver con la versión de el navegador Chrome
Correr /SeleniumPOMSample/src/test/java/Tests/BoardTests.java


