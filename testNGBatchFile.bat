set projectLocation=C:\POMGit\POMNewJuly
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java -cp org.testng.TestNG %projectLocation%\src\test\resources\testng.xml
pause