cd C:\POMGit\POMNewJuly
set ProjectPath=C:\POMGit\POMNewJuly
echo %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*
echo %classpath%
java org.testng.TestNG %ProjectPath%\testng.xml