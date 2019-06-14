#!/bin/bash
set -xe

cd ..
./gradlew clean assemble
cp -f build/libs/zqplayer-1.0.0-SNAPSHOT.jar dockersrc/zqplayer-1.0.0-SNAPSHOT.jar

serviceArray=($(docker service ls |grep -i zqplayer_service|awk '{print $1}'))
serviceNum=${#serviceArray[@]}
for ((i=0;i<serviceNum;i++)){
  echo "移除服务"${serviceArray[i]}
  docker service rm ${serviceArray[i]}
}

containId=`docker ps -a |grep -i zqplayer_service|awk '{print $1}'`
echo "容器ID = "$containId
containArray=($(docker ps -a |grep -i zqplayer_service|awk '{print $1}'))
echo ${containArray[0]}
containNum=${#containArray[@]}
for ((i=0;i<containNum;i++)){
  echo "停止容器"${containArray[i]}
  docker stop ${containArray[i]}
  echo "移除容器"${containArray[i]}
  docker container rm ${containArray[i]}
}

imageId=`docker images|grep -i zqplayer|awk '{print $3}'`
echo "镜像ID = "$imageId
imageArray=($(docker images|grep -i zqplayer|awk '{print $3}'))
echo ${imageArray[0]}
imageNum=${#imageArray[@]}
for ((i=0;i<imageNum;i++)){
  echo "删除旧镜像"${imageArray[i]}
  docker rmi -f ${imageArray[i]}
}

cd dockersrc
docker build -t docker.io/zqplayer:v1 .
docker run -d -p 1234:6666 \
    --restart=always \
    --name=zqplayer_service_v1 \
    docker.io/zqplayer:v1
#docker stack deploy -c docker-compose.yml zqplayer_service
