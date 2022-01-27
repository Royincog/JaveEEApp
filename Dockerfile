FROM airhacks/glassfish
COPY ./target/testapp.war ${DEPLOYMENT_DIR}
