# Build
mvn clean package && docker build -t com.testjavaee/testapp .

# RUN

docker rm -f testapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name testapp com.testjavaee/testapp 