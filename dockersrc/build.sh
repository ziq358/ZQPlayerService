#!/bin/bash
set -xe

cd ..
./gradlew clean assemble
cp -f build/libs/zqplayer-0.0.1-SNAPSHOT.jar dockersrc/zqplayer-0.0.1-SNAPSHOT.jar

imageId=`docker images|grep -i ziq358/zqplayer|awk '{print $3}'`
echo "镜像ID = "$imageId
containId=`docker ps -a |grep -i zqplayer_service_v1|awk '{print $1}'`
echo "容器ID = "$containId
#字符串非空
if [ -n "$containId" ];then
  echo "停止容器"
  docker stop $containId
  echo "移除容器"
  docker container rm $containId
fi
if [ -n "$imageId" ];then
  echo "旧镜像将要被删除"
  docker rmi -f $imageId
  echo "成功删除旧镜像"
fi

cd dockersrc
docker build -t ziq358/zqplayer:v1 .
#docker run -d -p 1234:6666 \
#    --restart=always \
#    --name=zqplayer_service_v1 \
#    ziq358/zqplayer:v1
#zqplayer_service   + docker-compose.yml中的 zqplayer 为服务名
docker service rm zqplayer_service_zqplayer || echo "No such service"
docker stack deploy -c docker-compose.yml zqplayer_service
