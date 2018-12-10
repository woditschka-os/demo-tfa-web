FROM quay.io/woditschka/openjdk:11

LABEL quay.expires-after="28d"

WORKDIR /opt

ENV JAVA_OPTS=""
ENV JAVA_PARAMS=""

RUN yum update -y && \
    yum clean all && \
    rm -rf /var/cache/yum && \
    mkdir -p /opt/config && \
    mkdir -p /opt/logs && \
    chmod 777 -R /opt

COPY target/tfa-web-0.0.5-SNAPSHOT.jar /opt/tfa-web.jar

USER 1000

EXPOSE 8080
EXPOSE 8081
CMD /usr/bin/java $JAVA_OPTS -XX:+UnlockExperimentalVMOptions -Djava.security.egd=file:/dev/./urandom -jar /opt/tfa-web.jar $JAVA_PARAMS