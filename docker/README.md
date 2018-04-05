Build minimal java 8 image in

cd minimal-java
docker build -t interview-assignment/minimal-java .

cd interview-assignment
docker build -t interview-assignment/interview-assignment:latest .

docker run -p 8090:8090 -t --name interview-assignment --rm interview-assignment/interview-assignment:latest
docker stop interview-assignment

docker login
docker push interview-assignment/interview-assignment

