@echo off

set ip=%1
set mainClass=%2

IF %1.==. GOTO NoIp
IF %2.==. GOTO NoMainClass

set lejos=%LEJOS_HOME%
if lejos.==. GOTO NoLejos

set lejosJava=%LEJOS_EV3_JAVA_HOME%
if lejos.==. GOTO NoLejosJavaHome

echo Building Project
del /s /f /q out
"%lejosJava%\bin\javac" -classpath "%lejos%\lib\ev3\ev3classes.jar" src/main/java/*.java -d out -target 1.7 -source 1.7
mkdir META-INF
echo Main-Class: %mainClass% >META-INF\MANIFEST.TXT
echo Class-Path: /home/root/lejos/lib/ev3classes.jar /home/root/lejos/lib/opencv-2411.jar /home/root/lejos/lib/dbusjava.jar /home/root/lejos/libjna/usr/share/java/jna.jar >>META-INF\MANIFEST.TXT
pushd out
del /s /f /q META-INF
"%lejosJava%\bin\jar" cfm ..\bin\program.jar ..\META-INF\MANIFEST.TXT *
popd
del /s /f /q META-INF
echo Uploading program to %ip%
"%lejos%\bin\ev3scpupload.bat" -n %ip% -r bin\program.jar /home/lejos/programs/program.jar
GOTO End

:NoIp
echo please enter an ip
GOTO End

:NoMainClass
echo please enter a main class
GOTO End

:NoLejos
echo please set a LEJOS_HOME environment variable
GOTO End

:NoLejosJavaHome
echo please set a LEJOS_EV3_JAVA_HOME environment variable
GOTO End

:End
