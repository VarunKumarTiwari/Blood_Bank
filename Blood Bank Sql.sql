CREATE DATABASE IF NOT EXISTS Blood_Bank;
USE Blood_Bank;

DROP TABLE IF EXISTS donor;


CREATE TABLE donor (
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	fName VARCHAR(15) NOT NULL,
    bgroup VARCHAR (9) NOT NULL,
	gender VARCHAR(9) NOT NULL,
    age INTEGER NOT NULL);

SELECT 'INSERTING DATA INTO DATABASE' as 'INFO';

INSERT INTO donor VALUES ( null, 'Varun Tiwari', 'B+', 'Male', 21);
INSERT INTO donor VALUES ( null, 'Natasha Sh', 'AB-', 'Female', 22);



select * from donor;

