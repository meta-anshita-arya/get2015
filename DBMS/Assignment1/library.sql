/* created database*/
CREATE DATABASE Library_Management;
USE Library_Management;

/* created table named members*/
CREATE TABLE members(
member_id INT PRIMARY KEY AUTO_INCREMENT,
member_nm VARCHAR(20),
addressline1 VARCHAR(20),
addressline2 VARCHAR(20),
category CHAR);

/* created table named authors*/
CREATE TABLE authors(
author_id INT PRIMARY KEY AUTO_INCREMENT,
author_nm VARCHAR(20));

/* created table named publishers*/
CREATE TABLE publishers(
publisher_id INT PRIMARY KEY AUTO_INCREMENT,
publisher_nm VARCHAR(20));

/* created table named subjects*/
CREATE TABLE subjects(
subject_id INT PRIMARY KEY AUTO_INCREMENT,
subject_nm VARCHAR(20));

/* created table named titles*/
CREATE TABLE titles(
title_id INT PRIMARY KEY AUTO_INCREMENT,
title_nm VARCHAR(20),
subject_id INT,
publisher_id INT,
FOREIGN KEY(subject_id) REFERENCES subjects(subject_id),
CONSTRAINT publisher_id_first
FOREIGN KEY(publisher_id)REFERENCES publishers(publisher_id)
ON DELETE CASCADE
);

/* created table named title_author*/
CREATE TABLE title_author(
title_id INT,
author_id INT,
PRIMARY KEY(title_id,author_id),
FOREIGN KEY(title_id) REFERENCES titles(title_id),
FOREIGN KEY(author_id) REFERENCES authors(author_id));

/* created table named book*/
CREATE TABLE books(
accession_no INT PRIMARY KEY AUTO_INCREMENT,
title_id INT,
purchase_dt DATE,
price INT,
status INT,
FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE
);

/* created table named book_issue*/
CREATE TABLE book_issue(
issue_dt DATE,
accession_no INT,
member_id INT,
due_dt DATE,
PRIMARY KEY(issue_dt,accession_no,member_id),
FOREIGN KEY(accession_no) REFERENCES books(accession_no),
CONSTRAINT member_id_first
FOREIGN KEY(member_id) REFERENCES members(member_id)
ON DELETE CASCADE
);

/* created table named book_return*/
CREATE TABLE book_return(
return_dt DATE,
issue_dt DATE,
accession_no INT,
member_id INT,
PRIMARY KEY(return_dt,accession_no,member_id),
FOREIGN KEY(accession_no) REFERENCES books(accession_no),
CONSTRAINT member_id_second
FOREIGN KEY(member_id) REFERENCES members(member_id)
ON DELETE CASCADE
);

/* altering table named book_issue*/
ALTER TABLE book_issue
MODIFY COLUMN issue_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP();

/*created trigger with name book*/
CREATE TRIGGER book
BEFORE
INSERT 
ON book_issue  
FOR EACH ROW 
SET NEW.due_dt = NOW() + INTERVAL 15 day;

/*display table*/
SHOW CREATE TABLE book_issue;

/* altering table named book_issue*/
ALTER TABLE book_issue
DROP FOREIGN KEY member_id_first;

/* altering table named book_return*/
ALTER TABLE book_return
DROP FOREIGN KEY member_id_second;

/*drop member table*/
DROP TABLE members;

/*create member table*/
CREATE TABLE members(
member_id INT PRIMARY KEY AUTO_INCREMENT,
member_nm VARCHAR(20),
addressline1 VARCHAR(20),
addressline2 VARCHAR(20),
category CHAR);

/* altering table named book_issue*/
ALTER TABLE book_issue
ADD CONSTRAINT member_id_first
FOREIGN KEY (member_id)
REFERENCES members(member_id);

/* altering table named book_return*/
ALTER TABLE book_return
ADD CONSTRAINT member_id_second
FOREIGN KEY (member_id)
REFERENCES members(member_id);
