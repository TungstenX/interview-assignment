# How to create and publish the Docker container

## Build minimal java 8 image

This image is based on [AlpineLinux](http://alpinelinux.org/) to keep the size down, yet smaller images do exist.  For more information, please visit :https://github.com/anapsix/docker-alpine-java

	$ cd minimal-java
	$ sudo docker build -t interview-assignment/minimal-java .

## Build interview-assignment	

	$ cd ../interview-assignment
	$ sudo docker build -t interview-assignment/interview-assignment:latest .

## To test the interview-assignment

Run:

	$ sudo docker run -p 8090:8090 -t --name interview-assignment --rm interview-assignment/interview-assignment:latest
Got to http://localhost:8090/

Then to stop:

    $ sudo docker stop interview-assignment

## To publish/push interview-assignment

    $ sudo docker tag interview-assignment/interview-assignment:latest localhost:5000/interview-assignment
    
For local registry:

    $ sudo docker push localhost:5000/interview-assignment
    
For public hub.docker.com:

    $ sudo docker login
    $ sudo docker push tungstenx/interview-assignment

