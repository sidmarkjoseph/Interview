#!/bin/bash

sed -i '' "s/\<mainClass\>[A-Za-z]*\<\/mainClass\>/\<mainClass\>__PLACEHOLDER__\<\/mainClass\>/g" pom.xml
sed -i '' "s/__PLACEHOLDER__/$1/g" pom.xml
extra=""
if [ "$1" == "LongestCommonSubstring" ];
then
  shift
  if [ -z "$1" ] || [ -z "$2" ];
  then
    echo "Please enter two arguments"
    exit 1
  else 
    extra="-Dexec.args=\"'$1' '$2'\""
  fi
fi
command="mvn clean install exec:java $extra"
eval $command


