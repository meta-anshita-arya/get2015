USE LIBRARY_MANAGEMENT;
/*inserting detail into member table*/
INSERT INTO members (member_nm,addressline1,addressline2,category )
VALUES( "priyamvada","420","neemuch",'f');
INSERT INTO members (member_nm,addressline1,addressline2,category )
VALUES( "arushi","21","jaipur",'f');
INSERT INTO members (member_nm,addressline1,addressline2,category )
VALUES( "sumitra","34","chittor",'f');
INSERT INTO members (member_nm,addressline1,addressline2,category )
VALUES( "deepali","47","neemuch",'f');
INSERT INTO members (member_nm,addressline1,addressline2,category )
VALUES( "manju","75","neemuch",'f');

/*inserting detail into subjects table*/
INSERT INTO subjects (subject_nm)
VALUES("Fiction");
INSERT INTO subjects (subject_nm)
VALUES("Non-Fiction Novel");
INSERT INTO subjects (subject_nm)
VALUES("Management");
INSERT INTO subjects (subject_nm)
VALUES("Communication");
INSERT INTO subjects (subject_nm)
VALUES("Technology");

/*inserting detail into publishers table*/
INSERT INTO publishers (publisher_nm)
VALUES("New Moon Books");
INSERT INTO publishers (publisher_nm)
VALUES("Genius");
INSERT INTO publishers (publisher_nm)
VALUES("Aashirwaad Books");
INSERT INTO publishers (publisher_nm)
VALUES("Macgrew");
INSERT INTO publishers (publisher_nm)
VALUES("Five Publishing");

/*inserting detail into authors table*/
INSERT INTO authors (author_nm)
VALUES("White Johnson");
INSERT INTO authors (author_nm)
VALUES("Donald");
INSERT INTO authors (author_nm)
VALUES("Groon Marjorie");
INSERT INTO authors (author_nm)
VALUES("Branath Abraham");
INSERT INTO authors (author_nm)
VALUES("Smith Meander");

/*inserting detail into titles table*/
INSERT INTO titles (title_nm,subject_id,publisher_id)
VALUES("Operating System",(SELECT subject_id FROM subjects where subject_nm='Technology'),
(SELECT publisher_id FROM publishers where publisher_nm='Aashirwaad Books'));

INSERT INTO titles (title_nm,subject_id,publisher_id)
VALUES(" Control System",(SELECT subject_id FROM subjects where subject_nm='Technology'),
(SELECT publisher_id FROM publishers where publisher_nm='Macgrew'));

INSERT INTO titles (title_nm,subject_id,publisher_id)
VALUES("Ansi C",(SELECT subject_id FROM subjects where subject_nm='Communication'),
(SELECT publisher_id FROM publishers where publisher_nm='Genius'));

INSERT INTO titles (title_nm,subject_id,publisher_id)
VALUES("The PRESENT",(SELECT subject_id FROM subjects where subject_nm='Management'),
(SELECT publisher_id FROM publishers where publisher_nm='New Moon Books'));

INSERT INTO titles (title_nm,subject_id,publisher_id)
VALUES("PAPER TOWN",(SELECT subject_id FROM subjects where subject_nm='Fiction'),
(SELECT publisher_id FROM publishers where publisher_nm='Five Publishing'));

/*inserting detail into book table*/
INSERT INTO books (title_id,purchase_dt,price,status)
VALUES((SELECT title_id FROM titles where title_nm='Ansi C'),NOW(),2000,1);

INSERT INTO books (title_id,purchase_dt,price,status)
VALUES((SELECT title_id FROM titles where title_nm='Operating System'),NOW(),4000,0);

INSERT INTO books (title_id,purchase_dt,price,status)
VALUES((SELECT title_id FROM titles where title_nm='The PRESENT'),NOW(),8000,1);

INSERT INTO books (title_id,purchase_dt,price,status)
VALUES((SELECT title_id FROM titles where title_nm='PAPER TOWN'),NOW(),900,0);

INSERT INTO books (title_id,purchase_dt,price,status)
VALUES((SELECT title_id FROM titles where title_nm='Control System'),NOW(),3000,0);

/*inserting detail into title_author table*/
INSERT INTO title_author (title_id,author_id)
VALUES((SELECT title_id FROM titles where title_nm='Ansi C'),(SELECT author_id FROM authors where author_nm='Donald'));

/*inserting detail into book_issue table*/
INSERT INTO book_issue (accession_no,member_id)
VALUES((SELECT accession_no FROM books where title_id=ALL(SELECT title_id FROM titles where title_nm='Ansi C')),
(SELECT member_id FROM members where member_nm='priyamvada'));

/*inserting detail into book_return table*/
INSERT INTO book_return(return_dt,issue_dt,accession_no,member_id)
VALUES((SELECT due_dt from book_issue where member_id =1),
(SELECT issue_dt from book_issue where member_id=1),
(SELECT accession_no FROM book_issue where member_id=1),1);

/*setting address*/
SET SQL_SAFE_UPDATES=0;
UPDATE members SET addressline2='Jaipur' where member_id=member_id ;

UPDATE members SET addressline1='EPIP, Sitapura' where category='f' ;

/*altering title table*/
ALTER TABLE titles
DROP FOREIGN KEY publisher_id_first;

/*deleting*/
Delete from publishers;

/*setting names in publishers*/
SET @name= 'New Moon Books';
INSERT INTO publishers (publisher_nm)
VALUES(@name);

SET @name= 'Genius';
INSERT INTO publishers (publisher_nm)
VALUES(@name);

SET @name= 'Aashirwaad Books';
INSERT INTO publishers (publisher_nm)
VALUES(@name);

/*deleting*/
DELETE FROM titles where publisher_id=1;
