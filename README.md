注意：
1.依赖说明：
```
<dependency>
    <groupId>com.bx</groupId>
    <artifactId>qrcode</artifactId>
    <version>2.0</version>
</dependency>

<dependency>
    <groupId>com.bx</groupId>
    <artifactId>qrcode-jp</artifactId>
    <version>2.0</version>
</dependency>
```
以上两个依赖在http://bql.mynatapp.cc/repository/maven-public/中拉取

可以在pom文件中增加repository
```
<repository>
      <id>central</id>
      <url>http://bql.mynatapp.cc/repository/maven-public/</url>
      <releases><enabled>true</enabled></releases>
      <snapshots><enabled>true</enabled></snapshots>
</repository>
```
2.系统入口：
系统部署在本机后，访问:locahost:port
