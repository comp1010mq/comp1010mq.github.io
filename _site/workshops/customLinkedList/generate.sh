#!/bin/bash

cp questions.tex $1.tex
cp solutions.tex $1solutions.tex

pdflatex $1
pdflatex $1solutions

rm -f *.aux
rm -f *.log
rm -f *.out

rm -rf $1.tex
rm -rf $1solutions.tex
