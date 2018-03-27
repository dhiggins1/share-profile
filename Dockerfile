FROM ubuntu:16.04

WORKDIR /root

SHELL ["/bin/bash", "-c"]
RUN apt-get clean
RUN apt-get -qq update
RUN sh -c '/bin/echo -e "y" | apt-get upgrade'
RUN apt-get install -qq -y software-properties-common
RUN apt-get install -qq -y wget
RUN wget https://www.python.org/ftp/python/2.7.6/Python-2.7.6.tgz
RUN tar -xvf Python-2.7.6.tgz
RUN apt-get install -qq -y dos2unix

RUN apt-get -y install vim
RUN apt-get -y install screen
RUN apt-get -y install links

RUN apt-get -y install openjdk-8-jdk openjdk-8-jre-headless

EXPOSE 8090

ENV NAME World
