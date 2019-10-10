#!/bin/bash

helm upgrade --set-string image.tag=user-service-$TRAVIS_BUILD_NUMBER users ./k8s/user-service/