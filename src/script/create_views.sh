#!/bin/bash
# A bash script for creating and publishing couchbase views for webtelco.
# 
# $1 is for username
# $2 is for password
# $3 is for hostname
# $4 is for bucket
# Example: ./create_views username password localhost

URL="http://$1:$2@$3:8092/$4/_design"

echo $URL

if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ] || [ -z "$4" ]; then
echo "Please specify the right parameters: username password hostname bucket"
exit 0
fi

for file in *.ddoc
do
 currentFile=`echo $file| cut -d'.' -f 1`
 echo $currentFile
 curl -X PUT -H 'Content-Type: application/json' "$URL/$currentFile" -d @$file
 curl -X PUT -H 'Content-Type: application/json' "$URL/dev_$currentFile" -d @$file
done
