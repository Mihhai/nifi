JAR_NAME=target/c2-mockserver-2.7.0-SNAPSHOT.jar
DOCKER_IMAGE_NAME=c2-mockserver

.DEFAULT_GOAL := compile

.PHONY: run docker docker-run clean

$(JAR_NAME):
	mvn clean package

compile: $(JAR_NAME)

clean:
	rm -f $(JAR_NAME)
	# mvn clean
	# docker image rm -f $(DOCKER_IMAGE_NAME)

run: $(JAR_NAME)
	java -jar $(JAR_NAME)

docker: $(JAR_NAME)
	docker build -t $(DOCKER_IMAGE_NAME) .

docker-run: docker
	docker run -p 8080:8080 $(DOCKER_IMAGE_NAME)

docker-compose: docker
	docker compose build

up:
	docker compose up -d

down:
	docker compose down
