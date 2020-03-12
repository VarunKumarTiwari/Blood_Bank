CREATE DATABASE IF NOT EXISTS Blood_Bank;
USE Blood_Bank;

DROP TABLE IF EXISTS donor;
DROP TABLE IF EXISTS doctor;

CREATE TABLE donor (
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	fName VARCHAR(15) NOT NULL,
    bgroup VARCHAR (9) NOT NULL,
	gender VARCHAR(9) NOT NULL,
    age INTEGER NOT NULL);
CREATE TABLE doctor (
	Docid INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	id INTEGER NOT NULL ,
	DocName VARCHAR(20) NOT NULL,
     FOREIGN KEY (id)
        REFERENCES donor (id));
SELECT 'INSERTING DATA INTO DATABASE' as 'INFO';

INSERT INTO donor VALUES ( null, 'Varun Tiwari', 'B+', 'Male', 21);
INSERT INTO donor VALUES ( null, 'Natasha Sh', 'AB-', 'Female', 22);

INSERT INTO doctor VALUES ( null,1, 'Varun Kumar Tiwari');
INSERT INTO doctor VALUES ( null,4, 'Varun Kumar Tiwari');

select * from donor;
select * from doctor;

SELECT donor.id,donor.fName,donor.bgroup,doctor.Docid , doctor.DocName FROM donor Inner JOIN doctor
    ON donor.id = doctor.id;


