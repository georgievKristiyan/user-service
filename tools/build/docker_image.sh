#!/bin/bash

echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
docker build -t kristiyang/hackconf:user-service-$TRAVIS_BUILD_NUMBER ./server
docker push kristiyang/hackconf:user-service-$TRAVIS_BUILD_NUMBER
docker tag kristiyang/hackconf:user-service-$TRAVIS_BUILD_NUMBER kristiyang/hackconf:user-service-latest
docker push kristiyang/hackconf:user-service-latest