#!/bin/sh

START=8190;
END=8200;

for ((i=$START; i<=$END; i++))
do
    python transfermarkt.py -i $i;
    sleep 2;
done
