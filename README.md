# cassandra spring implementation

This project inspired from: https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-data-cassandra


Difference is, that project is not working properly on docker image of cassandra.

### use following commands

        docker pull cassandra
        
**then** 

        docker run -p 9042:9042 --rm --name cassandra -d cassandra
        
**this command runs cassandra if you got any error, please check your docker.**

            
        docker run -it --link cassandra:cassandra --rm cassandra cqlsh cassandra
        
**this command opens cqlsh in docker cassandra image**


  
    

### configure cassandra

        CREATE KEYSPACE mykeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

**this creates 'mykeyspace' keyspace which is referenced in application.properties(change is needed if you want to use different keyspace name)**

        CREATE TABLE mykeyspace.customer (id UUID PRIMARY KEY, firstname text, lastname text);
        CREATE INDEX mykeyspace.customerfistnameindex ON customer (firstname);
        CREATE INDEX mykeyspace.customersecondnameindex ON customer (lastname);
        
**this creates table and indexes to use our repository properly(table name is relevant, must be same with domain class name)**

## run the project

Simply run the project after database configurations, it just takes your input, saves into db and shows back to you.

This projects aim is just testing cassandra database connection, getting and setting data properly.