

FROM openjdk:latest
# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da aplicação Spring Boot para o contêiner
COPY target/*.jar /app

# Exponha a porta que a aplicação Spring Boot está ouvindo
EXPOSE 8123

# Comando para iniciar a aplicação Spring Boot quando o contêiner for iniciado
CMD ["java", "-jar", "crudDemo-0.0.1-SNAPSHOT.jar"]