drop table GAME cascade CONSTRAINTS;
drop table BOARD_GAME cascade CONSTRAINTS;
drop table VIDEO_GAME_DISK cascade CONSTRAINTS;
drop table VIDEO_GAME_DIGITAL cascade CONSTRAINTS;
drop table COUPON cascade CONSTRAINTS;
drop table CONSOLE cascade CONSTRAINTS;
drop table COMPUTER cascade CONSTRAINTS;


CREATE TABLE GAME (
    gameID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title varchar2(20),
    price number(7,2),
    rating VARCHAR2(4)
);

CREATE TABLE BOARD_GAME(

    boardGameID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title varchar2(20),
    price number(5,2),
    rating VARCHAR2(4),
    pieces number (6,0)
);

CREATE TABLE VIDEO_GAME_DISK(
    gameDiskID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title varchar2(20),
    price number(5,2),
    rating VARCHAR2(4),
    platform varchar2(20),
    publisher varchar2(20)
);
CREATE TABLE VIDEO_GAME_DIGITAL(
    digitalGameID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title varchar2(20),
    price number(5,2),
    rating VARCHAR2(4),
    platform varchar2(20),
    game_size number(6,3)
);

CREATE TABLE COUPON (
    couponType VARCHAR2(10);
    couponID  NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product VARCHAR2(20),
    amount number(4,2),
    type varchar2(20)
);

CREATE TABLE CONSOLE(
    consoleType VARCHAR2(10);
    consoleID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    deviceName varchar2(20),
    price number(5,2)
);

CREATE TABLE COMPUTER(
    computerType VARCHAR2(10);
    computerID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    deviceName varchar2(20),
    storage number(8,2),
    RAM number (4,0),
    price number(7,2)
);

INSERT INTO GAME(title, price, rating) VALUES('UNO', 13.99, '6+');
INSERT INTO BOARD_GAME(title, price, rating, pieces) VALUES('board', 'Chess', 33.85, '8+', 32);
INSERT INTO VIDEO_GAME_DISK(title, price, rating, platform, publisher) VALUES('disk', 'God of War', 63.85, '16+', 'PS5', 'PEOPLE');
INSERT INTO VIDEO_GAME_DIGITAL(title, price, rating, platform, game_size) VALUES('digital', 'Terraria', 23.85, '10+', 'PC', 3.5);

INSERT INTO computer(deviceName, storage, RAM, price) VALUES('pc','ASUS Desktop-01', 1.8, 16, 999.99);
INSERT INTO console(deviceName, price) VALUES('console', 'Nintendo Switch', 700);
INSERT INTO console(deviceName, price) VALUES('console', 'Playstation 5', 900);


INSERT INTO COUPON(amount, type) VALUES('discount', 20, 'Discount');

COMMIT;
