#!/bin/bash

currentVersion=`gradle dependencies | grep jtwig-core | sed 's/.*-> *//g' | tail -n 1`
echo "Current version $currentVersion"

for i in `ls | grep "gradle-"`
do
    cd $i
    gradle compileJava
    if [ $? -ne 0 ]; then exit 1; fi
    cd ..
done

for i in `ls | grep "maven-"`
do
    cd $i
    mv pom.xml pom.xml.bak
    cat pom.xml.bak | sed 's/<jtwig.version>.*<\/jtwig.version>/<jtwig.version>'$currentVersion'<\/jtwig.version>/g' > pom.xml
    mvn compile
    if [ $? -ne 0 ]; then exit 1; fi
    cd ..
done