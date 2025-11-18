# Practicing CI/CD & SCRUM WorkFlow With a Comments Section

## Purpose

The purpose of this project is to get some practice with CI/CD, Scrum, Data Structures, & Algorithms. I'm going to be setting up a Linux development environment with a CI/CD pipeline in place, and I'll be using this pipeline to create a comments section in Java.

## Establishing a CI/CD Pipeline

The first thing I need to do is establish a CI/CD pipeline. There are some elements common to every CI/CD pipeline that I'm going to need to put in place:

1. Version Control
2. Build Tool
3. Automated Testing Kit
4. Release/Deployment Tool
5. Operation & Monitoring

In addition to all of this, it will be important to have a versioning strategy and some way to make repo artifacts. Let's dig in.

Before I start setting up the pipeline, I need to create a development environment. VSCode has a development container extension that makes it very easy to create and manage Linux containers. I've configured the container with the necessary tools (for the pipeline) and mounts (for private repo SSH). I'll be versioning using Semantic Versioning (MAJOR, MINOR, PATCH), and I'll create repo artifacts using Docker. I'll only be creating repo artifacts when I perform major updates to my code.

1. Version Control:
   I don't need to make any decisions here. Git is the industry-wide standard for code versioning, and I'll be using it.
2. Build Tool:
   I'll be using Gradle since I'm writing my code in Java. I should note that I generated the project skeleton using Spring Boot v 3.5.7, with Java 21 and Gradle Kotlin, packaged as JAR.
3. Automated Testing Kit:
   I'll be using JUnit to create my tests, and I'll be using Jenkins to automate the tests during staging.
4. Release/Deployment Tool:
   Again, I'll be using Jenkins to automate the staging and building of my code. Once the code is released, it will be deployed via rolling updates using Docker.
5. Operation and Monitoring:
   I'm going to have a single instance of this code and near-zero traffic so I'm not going to have to worry too much about operation. I plan to monitor the little traffic I get (my own traffic) using DataDog.

### The CI Server

I can run my Jenkins server locally, and run my integration and deployment pipeline from there. For simplicity, this is a public server, so I don't have to configure any ssh certs in the server. During integration with the remote repository, I run my tests using shell scripts and only push my changes if all tests pass. This ensures that code in the remote repository is always functional.

### Deployment

The Jenkins pipeline is useful in that I can integrate and deploy all at once with the click of a button. Once the code has been successfully commited to the remote repository, the pipeline runs the build script, **which for now pushes the output to the build folder.**

## Spring Boot

### Reference Documentation

For further reference, please consider the following sections:

- [Official Gradle documentation](https://docs.gradle.org)
- [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.7/gradle-plugin)
- [Create an OCI image](https://docs.spring.io/spring-boot/3.5.7/gradle-plugin/packaging-oci-image.html)
- [Spring Web](https://docs.spring.io/spring-boot/3.5.7/reference/web/servlet.html)

### Guides

The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links

These additional references should also help you:

- [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
