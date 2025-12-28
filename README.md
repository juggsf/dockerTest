完成了一个最小的 Spring Boot + Vue3 示例，含登录页与用户信息页，并提供前端 Nginx 静态部署与后端独立容器的 Docker 配置。前端通过 /api 代理到后端，登录账号固定为 demo/password。

变更点（文件位置与用途）

后端接口与配置：UserController.java、LoginRequest.java、LoginResponse.java、UserInfo.java、WebConfig.java
后端入口与配置：DockerDemoApplication.java、application.properties、pom.xml
前端页面与逻辑：LoginView.vue、ProfileView.vue、api.js、router.js、App.vue、main.js、style.css、index.html
Docker 部署：backend/Dockerfile、frontend/Dockerfile、nginx.conf、docker-compose.yml
可选下一步

用 Docker 启动：在根目录执行 docker compose up --build，访问 http://localhost:8088
本地开发：后端 mvn spring-boot:run，前端 npm install 后 npm run dev
