#How to create and publish the Kubernetes
Run scripts

    $ start.sh
    $ portForward.sh <pod NAME>
   
or run the commands manually:

    $ kubectl apply -f ./interview-assignment.yaml
    $ kubectl get deployment
    $ kubectl get rs
    $ kubectl get pods --all-namespaces
    $ kubectl get svc

*(Above: The first command runs/applies the config file, the other commands just gets information pertaining to the pod, service, etc)*

 and then
 
    $ kubectl get pods <pod NAME> --template='{{(index (index .spec.containers 0).ports 0).containerPort}}{{"\n"}}'
    $ kubectl port-forward <pod NAME> 8090:8090

(Above: The first command confirms the port to be `8090` and the second command does a port-forward)