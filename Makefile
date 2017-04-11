.PHONY: build

PACKAGES = $(shell go list ./... | grep -v /vendor/)
VERSION=$(shell git describe --match 'v[0-9]*' --dirty --always)
GO_LDFLAGS=-ldflags "-X table2class/pkg/version.VersionDev=$(VERSION)"

all: build

test:
	go test -cover $(PACKAGES)

# build the release files
build: table2class

table2class:
	go build ${GO_LDFLAGS} table2class

build_cross:
	GOOS=linux   GOARCH=amd64 CGO_ENABLED=0 go build -o release/linux/amd64/table2class       ${GO_LDFLAGS} table2class
	GOOS=linux   GOARCH=386   CGO_ENABLED=0 go build -o release/linux/386/table2class         ${GO_LDFLAGS} table2class
	GOOS=windows GOARCH=amd64 CGO_ENABLED=0 go build -o release/windows/amd64/table2class.exe ${GO_LDFLAGS} table2class
	GOOS=windows GOARCH=386   CGO_ENABLED=0 go build -o release/windows/386/table2class.exe   ${GO_LDFLAGS} table2class
	GOOS=darwin  GOARCH=amd64 CGO_ENABLED=0 go build -o release/darwin/amd64/table2class      ${GO_LDFLAGS} table2class

build_tar:
	tar -cvzf release/linux/amd64/table2class.tar.gz   -C release/linux/amd64   table2class
	tar -cvzf release/linux/386/table2class.tar.gz     -C release/linux/386     table2class
	tar -cvzf release/windows/amd64/table2class.tar.gz -C release/windows/amd64 table2class.exe
	tar -cvzf release/windows/386/table2class.tar.gz   -C release/windows/386   table2class.exe
	tar -cvzf release/darwin/amd64/table2class.tar.gz  -C release/darwin/amd64  table2class

build_all: build_static build_cross build_tar

rebuild: clean build

clean:
	rm -f ./table2class
