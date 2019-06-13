#!/bin/bash
set -xe

cd ..
./gradlew clean assemble
cp -f build/libs/zqplayer-0.0.1-SNAPSHOT.jar dockersrc/zqplayer-0.0.1-SNAPSHOT.jar

containId=`docker ps -a |grep -i zqplayer_service_zqplayer|awk '{print $1}'`
echo "容器ID = "$containId
containArray=($(docker ps -a |grep -i zqplayer_service_zqplayer|awk '{print $1}'))
echo ${containArray[0]}
containNum=${#containArray[@]}
for ((i=0;i<containNum;i++)){
  echo "停止容器"${containArray[i]}
  docker stop ${containArray[i]}
  echo "移除容器"${containArray[i]}
  docker container rm ${containArray[i]}
}

imageId=`docker images|grep -i ziq358/zqplayer|awk '{print $3}'`
echo "镜像ID = "$imageId
imageArray=($(docker images|grep -i ziq358/zqplayer|awk '{print $3}'))
echo ${imageArray[0]}
imageNum=${#imageArray[@]}
for ((i=0;i<imageNum;i++)){
  echo "删除旧镜像"${imageArray[i]}
  docker rmi -f ${imageArray[i]}
}

cd dockersrc
docker build -t ziq358/zqplayer:v1 .
#zqplayer_service   + docker-compose.yml中的 zqplayer 为服务名
docker service rm zqplayer_service_zqplayer || echo "No such service"
docker stack deploy -c docker-compose.yml zqplayer_service
