-- Active: 1665826483095@@127.0.0.1@3306@WebServlet
CREATE DATABASE WebServlet;

USE WebServlet;
CREATE TABLE User (
    u_id INT PRIMARY KEY AUTO_INCREMENT,
    u_name NVARCHAR(50) NOT NULL,
    u_pass VARCHAR(16) NOT NULL,
    u_mail VARCHAR(20) NOT NULL
);
CREATE TABLE U_Fav (
    u_id_fav INT PRIMARY KEY AUTO_INCREMENT,
    fav_listenMusic BIT NULL,
    fav_watchFilm BIT NULL,
    fav_playGame BIT NULL,
    fav_readBook BIT NULL
);

ALTER TABLE `User`
ADD Foreign Key (u_id) REFERENCES U_Fav(u_id_fav);

ALTER TABLE `U_Fav` ADD Foreign Key (u_id_fav) REFERENCES User(u_id);
