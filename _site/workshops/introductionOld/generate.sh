#!/bin/bash

mv questions.tex $1.tex
mv solutions.tex $1solutions.tex
#mv solutionsPartial.tex $1solutionsPartial.tex

pdflatex $1
pdflatex $1solutions
#pdflatex $1solutionsPartial

rm -f *.aux
rm -f *.log
rm -f *.out

mv $1.tex questions.tex
mv $1solutions.tex solutions.tex
#mv $1solutionsPartial.tex solutionsPartial.tex
