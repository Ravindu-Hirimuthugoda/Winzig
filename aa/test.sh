#!/bin/bash

# colors
red=$(tput setaf 1)
green=$(tput setaf 2)
reset=$(tput sgr0)

for i in {1..15}
do  
    if [[ $i -lt 10 ]];
    then 
        java winzigc -ast winzig_test_programs/winzig_0$i>tree.0$i
        output= diff tree.0$i winzig_test_programs/winzig_0$i.tree
    else
        java winzigc -ast winzig_test_programs/winzig_$i>tree.$i
        output= diff tree.$i winzig_test_programs/winzig_$i.tree
    fi
    if [ $? -eq 0 ]; then
      echo "test ${i}: ${green}Passed${reset}"
    else
      echo "test ${i}: ${red}Failed${reset}"
      ERR=$((ERR + 1))
    fi
done
