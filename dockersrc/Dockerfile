#Dockfile是一个用于编写docker镜像生成过程的文件
#Dockerfile文件的第一条指令必须是FROM，其后可以是各种镜像的操作指令，最后是CMD或ENTRYPOINT指定容器启动时执行的命令。

#基础镜像信息
FROM openjdk:8-jdk-alpine
#每条 RUN 指令将在当前镜像基础上执行指定命令，并提交为新的镜像
#set命令对后面的命令起效
  #-x 　执行指令后，会先显示该指令及所下的参数
  #-e 　若指令传回值不等于0，则立即退出shell
RUN set -xe \
#解决Docker部署无字体空指针
&& apk --no-cache add ttf-dejavu fontconfig

#/etc/localtime是用来描述本机时间，而 /etc/timezone是用来描述本机所属的时区
#链接 它的功能是为某一个文件在另外一个位置建立一个同步的链接
#修改本机时间
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
#把文本写进文件，文件不存在会自动创建
#修改本机时区
RUN echo 'Asia/Shanghai' >/etc/timezone

#创建一个可以从本地主机或其他容器挂载的挂载点
VOLUME /tmp
#复制本地主机的 <src>（为 Dockerfile 所在目录的相对路径）到容器中的 <dest>
COPY zqplayer-1.0.0-SNAPSHOT.jar zqplayer-1.0.0-SNAPSHOT.jar
#配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zqplayer-0.0.1-SNAPSHOT.jar"]


