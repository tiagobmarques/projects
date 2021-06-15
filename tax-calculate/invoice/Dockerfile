FROM amazoncorretto:11

ARG ACCESS_KEY=A
ARG SECRET_KEY=B

ENV AWS_ACCESS_KEY=$ACCESS_KEY
ENV AWS_SECRET_KEY=$SECRET_KEY

RUN mkdir /opt/apps

WORKDIR /opt/apps

COPY build/libs/invoice.jar ./

EXPOSE 8080

CMD java -jar -Dspring.profiles.active=prod invoice.jar
