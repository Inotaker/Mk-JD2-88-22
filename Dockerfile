FROM tomcat:8.5-jre11-temurin
COPY target/Mk-JD2-88-22-0.0.0.war usr/local/tomcat/webapps
CMD ["catalina.sh", "run "]