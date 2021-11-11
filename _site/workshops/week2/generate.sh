#!/bin/bash

echo "\\documentclass{exam} " > $1.tex
echo "\\def\\workshopTitle{Workshop - $2} " >> $1.tex
cat data.tex >> $1.tex

echo "\\documentclass{exam} " > $1\_solutions.tex
echo "\\printanswers " >> $1\_solutions.tex
echo "\\def\\workshopTitle{Workshop - $2} " >> $1\_solutions.tex
cat data.tex >> $1\_solutions.tex
#mv solutionsPartial.tex $1solutionsPartial.tex

pdflatex $1
pdflatex $1\_solutions
#pdflatex $1solutionsPartial

rm -f *.aux
rm -f *.log
rm -f *.out
rm -f $1*.tex

# mv $1.tex questions.tex
# mv $1solutions.tex solutions.tex
#mv $1solutionsPartial.tex solutionsPartial.tex
