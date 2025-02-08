# 1. Base image 선택
FROM openjdk:20-jdk

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 빌드된 JAR 파일을 Docker 이미지로 복사
COPY ./build/libs/boardCrud-1.0-SNAPSHOT.jar /app/boardCrud-1.0-SNAPSHOT.jar

# 4. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "boardCrud-1.0-SNAPSHOT.jar"]

# 5. 포트 설정 (애플리케이션이 사용하는 포트)
EXPOSE 8080