#!/bin/bash

cd c:\\workspace\\cleaning-schedule-database || exit
git stash
git checkout master
git pull

cd c:\\workspace\\cleaning-schedule-backup-sync || exit
git pull
./gradlew run

cd c:\\workspace\\cleaning-schedule-database || exit
git add .
today=$(date +"%Y/%m/%d")
git commit -m "meetings synced $today"
git push
