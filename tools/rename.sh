#!/bin/bash
PNGFOLDER=$1
OUTPATH=$2
FIND=$3
REPLACE=$4

for f in $1/*${FIND}*.png; do
NAME=$(echo $f | rev | cut -d "/" -f1 | rev | sed "s/${FIND}/${REPLACE}/g")
cp $f "$OUTPATH/$NAME"
done
