#!/bin/bash

cd ..
ROOT_DIR=`pwd`

for project in `ls | grep "gradle-"`
do
    mavenReplica=`echo $project | sed 's/gradle/maven/g'`
    if [ ! -d $mavenReplica ]; then
        echo "Generating project $mavenReplica"
        cp -r $project $mavenReplica
        mv $mavenReplica/build.gradle $mavenReplica/build.gradle.bak
        cat generate-maven/dependencies.gradle > $mavenReplica/build.gradle
        echo "" >> $mavenReplica/build.gradle
        cat $mavenReplica/build.gradle.bak >> $mavenReplica/build.gradle
        rm $mavenReplica/build.gradle.bak
        cd $mavenReplica
        ./gradlew generatePomFileForMavenProjectPublication projectPom
        rm build.gradle
        rm settings.gradle
        rm -f gradlew
        rm -f gradlew.bat
        rm -rf gradle
        rm -rf .gradle
        rm -f *.iml
        if [ -d build ]; then
            rm -rf build
        fi
        cd $ROOT_DIR

        git add $mavenReplica
    fi
done