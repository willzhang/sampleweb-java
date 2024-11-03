## sampleweb-java

介绍：基于httpserver实现简单的web服务器

## 快速入门

运行容器

```
docker run -d --name sampleweb-java -p 8080:8080 registry.cn-shenzhen.aliyuncs.com/cnmirror/java-sampleweb:v1.0
```

浏览器访问

```
http://localhost:8080
```

## 构建示例

```
git clone https://github.com/willzhang/sampleweb-java.git
cd sampleweb-java
docker build -t registry.cn-shenzhen.aliyuncs.com/cnmirror/java-sampleweb:v1.0 .
```

