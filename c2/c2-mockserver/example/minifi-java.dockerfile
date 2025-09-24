FROM apache/nifi-minifi:latest

RUN echo "c2.enable=true" >> /opt/minifi/minifi-current/conf/bootstrap.conf && \
    echo "c2.rest.path.base=http://c2-mockserver:8080/" >> /opt/minifi/minifi-current/conf/bootstrap.conf && \
    echo "c2.rest.path.heartbeat=http://c2-mockserver:8080/heartbeat" >> /opt/minifi/minifi-current/conf/bootstrap.conf && \
    echo "c2.rest.path.acknowledge=http://c2-mockserver:8080/acknowledge" >> /opt/minifi/minifi-current/conf/bootstrap.conf && \
    echo "c2.agent.class=my_class_java" >> /opt/minifi/minifi-current/conf/bootstrap.conf && \
    echo "c2.agent.identifier=my_id_java" >> /opt/minifi/minifi-current/conf/bootstrap.conf

RUN sed -i 's/flow.json.gz/flow.json.raw/' /opt/minifi/minifi-current/conf/bootstrap.conf