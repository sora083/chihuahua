CREATE DATABASE IF NOT EXISTS chihuahua;

CREATE USER 'mao'@'%' IDENTIFIED BY 'mao';
-- CREATE USER 'mao'@'localhost' IDENTIFIED BY 'mao';

GRANT ALL ON `chihuahua`.* TO 'mao'@'%';