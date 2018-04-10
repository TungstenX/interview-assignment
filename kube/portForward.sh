#!/bin/bash
if [ -z "$1" ]
  then
    echo "No pod supplied"
    exit 0
fi
kubectl get pods $1 --template='{{(index (index .spec.containers 0).ports 0).containerPort}}{{"\n"}}'
kubectl port-forward $1 8090:8090
