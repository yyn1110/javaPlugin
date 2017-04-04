#!/bin/bash
function if_error
{
    if [ $1 -ne 0 ]
    then 
        echo -e "\033[31mfailed!error code:$1\033[0m"
        exit $1
    else
        echo -e "\033[32msuccess!\033[0m"
    fi
}

echo "git pull..."
git pull origin master
if_error $?

echo "Building Linux 64bit version ..."
CGO_ENABLED=0 GOOS=linux GOARCH=amd64 go build
if_error $?
echo "Remane file"
rm -f ./table2class-linux
cp ./table2class table2class-linux
if_error $?

echo "Building Windows 64bit version ..."
CGO_ENABLED=0 GOOS=windows GOARCH=amd64 go build
if_error $?
echo "Remane file"
rm -f ./table2class-win64.exe
cp ./table2class.exe table2class-win64.exe
if_error $?
 
echo "Building MacOS version ..."
CGO_ENABLED=0 GOOS=darwin GOARCH=amd64 go build
if_error $?
echo "Remane file"
rm -f ./table2class-macos
cp ./table2class table2class-macos
if_error $?

echo "git add..."
git add ./table2class-*
if_error $?

echo "git commit..."
git commit -m "Update binaries"
if_error $?

echo "git push..."
git push origin master
if_error $?





 
