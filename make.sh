#!/bin/bash

find -name *.java > sources.txt
javac -sourcepath . @sources.txt
cd avaj-launcher/src/
echo "$(tput setaf 2)All Classes have been created!"
echo "$(tput setaf 1)"
java Simulator.Simulator scenario.txt

  echo $(tput setaf 2)
  cat simulation.txt;
cd ..

