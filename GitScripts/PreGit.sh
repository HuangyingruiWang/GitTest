#!/bin/sh
branchName=$1
echo "branchName is $branchName"
filePath=$2
echo "$filePath"
message=$3
echo "Check GitScripts"
git checkout -b "$branchName"
git push --set-upstream origin "$branchName"
git branch
git fetch origin
git merge origin/"$branchName"
git status
echo "This is pre git script"

# Remove all *.yaml files
echo "The path is $filePath"
rm "$filePath"/*.txt

touch "$filePath"/abc.abc
# Rename all *.tstt to *.yaml
for f in "$filePath"/*; do
  mv -- "$f" "${f%.abc}.txt"
done

git status
git add --all -f "$filePath"/*.txt
git commit -m "$message"

git status
git push -f origin

git status
echo "This is after git push"
#GITHUB_TOKEN=$SSH GITHUB_HOST=github.pie.apple.com hub pull-request -b filecomp -h Data_Fix -m "test_hub"

git checkout filecomp
git status
git branch -D "$branchName"