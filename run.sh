#!/bin/bash

sed -i '' "s/\<mainClass\>[A-Za-z0-9]*\<\/mainClass\>/\<mainClass\>__PLACEHOLDER__\<\/mainClass\>/g" pom.xml
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
if [ "$1" == "SumQuery2D" ];
then
 if [ -z "$2" ] || [ -z "$3" ] || [ -z "$4" ] || [ -z "$5" ] || [ -z "$6" ];
 then
   echo "Please provide 5 arguments"
   exit 1
 else
   extra="-Dexec.args=\"$2 $3 $4 $5 $6\"" 
 fi
fi
command="mvn clean install exec:java $extra"
eval $command


