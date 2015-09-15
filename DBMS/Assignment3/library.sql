USE database_management;
     
 -- to display number of types of members in library management system
SELECT 
    COUNT(if(person_type = 'P', person_type, null)) AS NO_OF_PROFESSORS,
    COUNT(if(person_type = 'S', person_type, null)) AS NO_OF_STUDENTS,
    COUNT(if(person_type = 'O', person_type, null)) AS NO_OF_OTHERS
FROM
    members;

--  to display information of those titles issued for 2 or more than 2 times
SELECT 
    t.title_id, t.title_nm, t.subject_id, t.publisher_id
FROM
    titles t,
    books b,
    book_issue bi
WHERE
    (bi.accession_no = b.accession_no AND b.title_id = t.title_id)
GROUP BY bi.accession_no
HAVING (count(bi.accession_no) >= 2);

--  to display books issued to members other than type faculty
SELECT 
    b.accession_no as accession_no,
    b.title_id as title_id,
    b.purchase_dt as purchase_date,
    b.price as price
FROM
    books b,
    members m,
    book_issue bi
WHERE
    bi.member_id = m.member_id AND m.person_type != 'P' AND bi.accession_no = b.accession_no AND b.status = 1;

--  to display information of those authors whose book has been purchased at least
SELECT 
    b.accession_no as accession_no,
    a.author_nm as author_nm,
    t.title_nm as title_nm
FROM
    books b,
    title_author ta,
    authors a,
    titles t
WHERE
    a.author_id = ta.author_id AND ta.title_id = b.title_id AND b.title_id = t.title_id;
