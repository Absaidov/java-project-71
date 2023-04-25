.DEFAULT_GOAL := build-run
run-dist:
	./build/install/app/bin/app

run:
	./gradlew run

build:
	./gradlew clean build
clean:
	./gradlew clean
test:
	./gradlew test
lint:
	./gradlew checkstyleMain checkstyleTest

build-run: build run

.PHONY: build