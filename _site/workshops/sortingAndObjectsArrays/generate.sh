#!/bin/bash

mv questions.tex $1.tex
mv solutions.tex $1solutions.tex

pdflatex $1
pdflatex $1solutions

rm -f *.aux
rm -f *.log
rm -f *.out

mv $1.tex questions.tex
mv $1solutions.tex solutions.tex
