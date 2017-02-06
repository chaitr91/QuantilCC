#!/bin/bash
javac Generate.java
java Generate
cat out* > final.txt
rm -f *.class
