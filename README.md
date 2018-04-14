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

#系统改进计划
##后端
###分多模块
###引入jpa+hibernate+mysql
整理二维码工具包
增加名片模板管理模块

##前端 前后端分离
前端用Vue+bootstrap
用户使用微信扫码登录，
用户在录入名片时，界面和用户所选择的名片模板相同，头像默认和微信头像相同

