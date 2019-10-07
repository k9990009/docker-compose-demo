#### 简介
使用docker compose快速部署web服务，将 nginx 、mysql、springboot容器化，统一配置管理。利用[docker-maven-plugin](https://github.com/spotify/docker-maven-plugin)在maven打包时使用Dockerfile构建镜像并上传至阿里云私服。结合[wait-for-it.sh](https://docs.docker.com/compose/startup-order/)控制服务启动顺序。

#### 依赖环境
- java8
- maven
- docker 
- git

#### 使用
```
git clone https://github.com/k9990009/docker-compose-demo.git
cd docker-compose-demo/docker-demo/
mvn clean package  -DskipDockerPush -DdockerImageTags=test
cd ..
docker-compose up --scale web=2 -d
curl -w "\n"  127.0.0.1
docker-compose down
```
#### tips

- DskipDockerBuild to skip image build
- DskipDockerTag to skip image tag
- DskipDockerPush to skip image push
- DskipDocker to skip any Docker goals

指定自定义tag
```
mvn clean package -DdockerImageTags=test
mvn clean package -DdockerImageTags=dev,test
```

移除所有未打tag的镜像
```
docker rmi $(docker images -f "dangling=true" -q)
```
在同一docker网络下,可通过service_id访问服务
```
proxy_pass http://web:8080;
spring.datasource.url=jdbc:mysql://mysql:3306/test
```
修改docker-compose 配置文件，无需关闭所有服务，直接重启即可，只会重启修改了的service
```
docker-compose up -d
```
docker-compose 中的某个镜像更新了，重启单个服务
```
docker-compose stop service_id
docker-compose up -d --build service_id
```
开发测试中，不想重构镜像而修改容器文件，可查容器在宿主机中的路径以方便修改（不推荐）
```
docker inspect --format='{{.GraphDriver.Data.MergedDir}}' container_id
```