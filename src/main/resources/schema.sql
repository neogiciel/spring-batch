DROP TABLE IF EXISTS EXECUTIONJOB;

CREATE TABLE EXECUTIONJOB(
    IDEXECUTIONJOB INT AUTO_INCREMENT PRIMARY KEY,
    NOM VARCHAR(80) NOT NULL,
    MESSAGE VARCHAR(255) NOT NULL,
    DTCREATION  date
);

DROP TABLE IF EXISTS PROCESSUS;

CREATE TABLE PROCESSUS(
    IDPROCESSUS INT AUTO_INCREMENT PRIMARY KEY,
    ACTIF VARCHAR(4) NOT NULL
);
