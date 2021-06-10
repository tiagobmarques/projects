FROM amazoncorretto:11

RUN mkdir /opt/apps

WORKDIR /opt/apps

COPY build/libs/invoice.jar ./

EXPOSE 8080

CMD java -jar -Dspring.profiles.active=prod invoice.jar
