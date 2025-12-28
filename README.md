完成了一个最小的 Spring Boot + Vue3 示例，含登录页与用户信息页，并提供前端 Nginx 静态部署与后端独立容器的 Docker 配置。前端通过 /api 代理到后端，登录账号固定为 demo/password。

变更点（文件位置与用途）

后端接口与配置：UserController.java、LoginRequest.java、LoginResponse.java、UserInfo.java、WebConfig.java
后端入口与配置：DockerDemoApplication.java、application.properties、pom.xml
前端页面与逻辑：LoginView.vue、ProfileView.vue、api.js、router.js、App.vue、main.js、style.css、index.html
Docker 部署：backend/Dockerfile、frontend/Dockerfile、nginx.conf、docker-compose.yml
可选下一步

用 Docker 启动：在根目录执行 docker compose up --build，访问 http://localhost:8088
本地开发：后端 mvn spring-boot:run，前端 npm install 后 npm run dev

Docker 部署流程（前端 nginx + 后端独立容器）

确保已安装并启动 Docker（Windows 需要 Docker Desktop）

在项目根目录执行构建并启动

docker compose up --build
访问
前端：http://localhost:8088
后端接口：http://localhost:8080/api/login
停止
docker compose down
说明

前端容器用 nginx 静态部署，/api 会反向代理到后端容器
账号 demo / 密码 password
如果要在局域网访问，把 localhost 换成宿主机 IP（如 http://192.168.x.x:8088），并确保防火墙放行 8088 端口。
