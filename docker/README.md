Build minimal java 8 image in
(https://github.com/anapsix/docker-alpine-java)
cd minimal-java
sudo docker build -t interview-assignment/minimal-java .

cd interview-assignment
sudo docker build -t interview-assignment/interview-assignment:latest .

sudo docker run -p 8090:8090 -t --name interview-assignment --rm interview-assignment/interview-assignment:latest
sudo docker stop interview-assignment


sudo docker tag interview-assignment/interview-assignment:latest localhost:5000/interview-assignment
sudo docker push localhost:5000/interview-assignment

sudo docker login
sudo docker push interview-assignment/interview-assignment

