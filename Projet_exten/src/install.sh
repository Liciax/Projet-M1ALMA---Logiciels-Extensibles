#!/bin/sh

PROJECT_PATH=`pwd`
VERSION=1.7
THE_CLASSPATH=
PROGRAM_NAME=plateforme/Plateforme.java
#PROGRAM_NAME="${PROJECT_PATH}/plateforme/Plateforme.java"

jar cf appli.jar appli/*
jar cf plateforme.jar plateforme/* proxyHandler/*
jar cf extension.jar actuateur/* afficheur/* donnees/* 

for i in `ls ./*.jar`
  do
  THE_CLASSPATH=${THE_CLASSPATH}:${i}
  echo $THE_CLASSPATH
done

#find . -name *.java | xargs javac -classpath ".:${THE_CLASSPATH}"

javac -source ${VERSION} -classpath ".:${THE_CLASSPATH}" donnees/*.java
javac -source ${VERSION} -classpath ".:${THE_CLASSPATH}" appli/*.java
javac -source ${VERSION} -classpath ".:${THE_CLASSPATH}" afficheur/*.java
javac -source ${VERSION} -classpath ".:${THE_CLASSPATH}" actuateur/*.java
javac -source ${VERSION} -classpath ".:${THE_CLASSPATH}" $PROGRAM_NAME
javac -source ${VERSION} -classpath ".:${THE_CLASSPATH}" proxyHandler/*.java

if [ $? -eq 0 ]
then
  echo "compilation reussie !"
fi

