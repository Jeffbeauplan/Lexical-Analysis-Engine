#!/usr/bin/env bash

if cat 7-ex-input.txt | ../bin/pr01 7-ex-program.ns >7-ex-output.txt 2>7-ex-error.txt
then
    rm 7-ex-error.txt
else
    cat 7-ex-output.txt >>7-ex-error.txt
    echo "lexing failure" >7-ex-output.txt
fi
