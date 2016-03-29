#!/bin/sh

THE_CLASSPATH=
PROGRAM_NAME=plateforme/Plateforme.java
cd src
for i in `ls ./*.jar`
  do
  THE_CLASSPATH=${THE_CLASSPATH}:${i}
  echo $THE_CLASSPATH
done

javac -classpath ".:${THE_CLASSPATH}" donnees/*.java
javac -classpath ".:${THE_CLASSPATH}" appli/*.java
javac -classpath ".:${THE_CLASSPATH}" afficheur/*.java
javac -classpath ".:${THE_CLASSPATH}" actuateur/*.java
javac -classpath ".:${THE_CLASSPATH}" $PROGRAM_NAME
javac -classpath ".:${THE_CLASSPATH}" proxyHandler/*.java

if [ $? -eq 0 ]
then
  echo "compile worked!"
fi

