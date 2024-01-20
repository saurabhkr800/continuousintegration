FORM openjdk
WORKDIR usr/lib
ENV MONGO_DETABASE=customerdb
ENV MONGO_URL=mongodb://localhost:27017/customerdb
ADD ./traget/product-controllerTest-0.0.1-SNAPSHOT.jar /usr/lib/product-controllerTest-0.0.1-SNAPSHORT.jar
ENTRYPOINT ["java","-jar","product-controllerTest-0.0.1-SNAPSHORT.jar"]