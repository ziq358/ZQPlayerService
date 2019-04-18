set -xe
imageId=`sudo docker images|grep -i openjdk/zqplayer|awk '{print $3}'`
echo "镜像ID = "$imageId
containId=`sudo docker ps -a |grep -i zqplayer_service_v1|awk '{print $1}'`
echo "容器ID = "$containId
#字符串非空
if [ -n "$containId" ];then
  echo "停止容器"
  docker stop containId
fi
if [ -n "$imageId" ];then
  echo "旧镜像将要被删除"
  docker rmi -f $imageId
  echo "成功删除旧镜像"
fi


docker build -t openjdk/zqplayer:v1 .
docker run -it -p 1234:6666 \
    --restart=always \
    --name=zqplayer_service_v1 \
    openjdk/zqplayer:v1

