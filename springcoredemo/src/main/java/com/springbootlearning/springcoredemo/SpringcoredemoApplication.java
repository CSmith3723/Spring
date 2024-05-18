package com.springbootlearning.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }

}


/*
* @SpringBootApplication is a combination of 3 different annotations: 
        @EnableAutoConfiguration: auto config support
        @ComponentScan: scans current and subpackages for components
        @Configuration: register extra beans with @Bean or import config classes

        Component scanning starts from the same package as the main application
        No need to explicitly reference the base package name

        If you create a separate package from the one your main is in, you can 
        tell the pmain application to scanBasePackages(...)



        Bean Scope: 

        Default scope: Singleton -- one instance of a bean by default, cached in 
        memory, all dependencies injected for the bean, and will refer to the SAME
        bean

        The scope can be explicitly specified and changed in the class for the bean

        Prototype scope: new bean for each request. Protoype scope can be good for 
        real-time systems that don't want to cache specific values. If you need a
        stateful instance, that is, an instance that contains specific information
        about something, then prototype is good. Stateful is generally not a great 
        way to manage information, because it's not fault tolerant and not scalable
                        Stateless means the state is stored in a central system outside
                            of the server. 
        Prototype beans are not handled all the way to the end of the lifecycle. Therefore,
        the destruction methods won't be called. And prototype beans are Lazy by default

        request scope: for http web request, only for web apps

        session scope: for http web session, only for web apps

        application scope: scoped to web app ServletContext, only for web apps

        websocket scope: scoped to a web socket, only for web apps




Bean Lifecyle: 

Container Started --> Bean Instantiated --> Dependencies Injected --> Internal
    Spring Processing --> Custom Init method --- when ready for stop --> custom stop

During Init: call custom business logic methods, handle resources

During bean destruction: custom business logic, resource cleanup



Hibernate: framework for persisting or saving Java objects into a database. It handles
the low level SQL code, minimizing the JDBC code you have to develop. 

Uses ORM(Object-to-Relational Mapping) to define mapping between the Java class and the db
table. 

JPA: Jakarta Persistence API
    Standard API for ORM

It's a specification: Defines a set of interfaces and requires an implementation to
be usable.

Hibernate is an implementation of the JPA Spec



 */
