FROM amazoncorretto:8

RUN mkdir /opt/apps

WORKDIR /opt/apps

COPY server-discovery/build/libs/server-discovery.jar ./

EXPOSE 8080

CMD java -jar -Dspring.profiles.active=prod server-discovery.jar
