USE library_management;

-- To display name of those members who belong to the category as to which member “Keshav Sharma” belongs
SELECT 
    member_nm
FROM
    members
WHERE
    person_type = (SELECT 
        person_type
    FROM
        members
    WHERE
        member_nm LIKE 'Keshav Sharma');

--  To display information on the books that have not been returned till date
SELECT 
    bi.issue_dt, bi.due_dt, m.member_nm, t.title_nm
from
    book_issue bi
        inner join
    books b ON bi.accession_no = b.accession_no
        inner join
    titles t ON b.title_id = t.title_id
        inner join
    members m ON bi.member_id = m.member_id
where
    bi.accession_no = (SELECT 
        bi1.accession_no
    from
        book_issue bi1
    where
        bi1.accession_no = bi.accession_no AND bi1.accession_no NOT IN (SELECT 
            br.accession_no
        from
            book_return br));
   
-- To display information on the books that have been returned after their due dates
SELECT 
    bi.Issue_dt, t.Title_nm, m.Member_nm, bi.Due_dt
FROM
    book_Issue bi
        INNER JOIN
    books b ON b.Accession_no = bi.Accession_no
        INNER JOIN
    titles t ON t.Title_id = b.title_id
        INNER JOIN
    Members m ON m.Member_id = bi.Member_id
WHERE
    EXISTS( SELECT 
        br.member_id, br.issue_dt, br.accession_no
    FROM
        book_return br
    WHERE
        br.issue_dt = DATE(bi.issue_dt) AND br.member_id = bi.member_id AND br.accession_no = bi.accession_no AND br.Return_dt > bi.Due_Dt);

-- To display information of those books whose price is equal to the most expensive book purchase so far
SELECT 
    title_nm
FROM
    titles t,
    books b1
WHERE
    t.title_id = b1.title_id && b1.price = (SELECT 
        MAX(b.price)
    FROM
        books b);
        
-- To display the second maximum price of a book
SELECT 
    price
FROM
    books
WHERE
    price = (SELECT 
        MAX(price)
    FROM
        books
    WHERE
        price < (SELECT 
            MAX(price)
        FROM
            books));
        

--  To create a View which can be used to display member name and all issue details of the member using a simple SELECT command
CREATE VIEW member_issue
AS
SELECT m.member_nm, bi.member_id, bi.issue_dt, bi.accession_no, bi.due_dt
FROM  book_issue bi,members m
WHERE m.member_id=bi.member_id;

SELECT 
    *
FROM
    member_issue;
    

-- To create a View which contains three columns, member name, member id and full description of category, i.e., Faculty, Students and Others instead of F,S and O.
CREATE VIEW member_description
AS
SELECT member_nm, member_id, IF (person_type='P','faculty',(IF(person_type='S','student','other'))) AS full_description
FROM  members;

SELECT 
    *
FROM
    member_description;

-- To create a View which contains the information – subject name, title, member name, category, issue date, due date and return date
CREATE VIEW returnDetailsOfBooks AS SELECT s.subject_nm,t.title_id,m.member_nm,
m.category,bi.issue_dt,bi.due_dt,br.return_dt
FROM  book_return br RIGHT OUTER JOIN
book_issue bi ON br.member_id=bi.member_id
INNER JOIN members m ON bi.member_id=m.member_id 
INNER JOIN books b ON b.accession_no=bi.accession_no 
INNER JOIN titles t ON b.title_id=t.title_id 
INNER JOIN subjects s ON s.subject_id=t.subject_id ;

SELECT 
    *
FROM
    returnDetailsOfBooks;
