#!/bin/bash

helm repo update
helm dependency update ./k8s/user-service/

helm upgrade \
--set postgresql.postgresqlDatabase=users-db \
--set postgresql.postgresqlUsername=db-user \
--set postgresql.postgresqlPassword=$USER_SERVICE_DB_PASSWORD \
--set-string image.tag=user-service-$TRAVIS_BUILD_NUMBER \
users \
./k8s/user-service/