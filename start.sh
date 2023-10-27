./mvnw clean package
docker stop chat-app-1 || true
docker rm chat-app-1 || true
docker rmi  my-chat:latest || true
docker image  build -t my-chat:latest .
cd chat
docker compose up