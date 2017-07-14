.PHONY: build

PACKAGES = $(shell go list ./... | grep -v /vendor/)
VERSION=$(shell git describe --match 'v[0-9]*' --dirty --always)
GO_LDFLAGS=-ldflags "-X javaPlugin/pkg/version.VersionDev=$(VERSION)"

all: build

test:
	go test -cover $(PACKAGES)

# build the release files
build: javaPlugin

javaPlugin:
	go build ${GO_LDFLAGS} javaPlugin

build_cross:
	GOOS=linux   GOARCH=amd64 CGO_ENABLED=0 go build -o release/linux/amd64/javaPlugin       ${GO_LDFLAGS} javaPlugin
	GOOS=linux   GOARCH=386   CGO_ENABLED=0 go build -o release/linux/386/javaPlugin         ${GO_LDFLAGS} javaPlugin
	GOOS=windows GOARCH=amd64 CGO_ENABLED=0 go build -o release/windows/amd64/javaPlugin.exe ${GO_LDFLAGS} javaPlugin
	GOOS=windows GOARCH=386   CGO_ENABLED=0 go build -o release/windows/386/javaPlugin.exe   ${GO_LDFLAGS} javaPlugin
	GOOS=darwin  GOARCH=amd64 CGO_ENABLED=0 go build -o release/darwin/amd64/javaPlugin      ${GO_LDFLAGS} javaPlugin

build_tar:
	tar -cvzf release/linux/amd64/javaPlugin.tar.gz   -C release/linux/amd64   javaPlugin
	tar -cvzf release/linux/386/javaPlugin.tar.gz     -C release/linux/386     javaPlugin
	tar -cvzf release/windows/amd64/javaPlugin.tar.gz -C release/windows/amd64 javaPlugin.exe
	tar -cvzf release/windows/386/javaPlugin.tar.gz   -C release/windows/386   javaPlugin.exe
	tar -cvzf release/darwin/amd64/javaPlugin.tar.gz  -C release/darwin/amd64  javaPlugin

build_all: build_static build_cross build_tar

rebuild: clean build

clean:
	rm -f ./javaPlugin
