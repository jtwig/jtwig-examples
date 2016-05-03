#!/bin/bash

for i in `ls | grep "gradle-"`
do
    cd $i
    gradle compileJava
    cd ..
done

for i in `ls | grep "maven-"`
do
    cd $i
    mvn compile
    cd ..
done