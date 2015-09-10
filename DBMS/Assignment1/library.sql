USE Library_Management;
    -- to select all the columns of table members
SELECT 
    *
FROM
    members;
        
    -- to display member id,member name,category of table members
SELECT 
    member_id, member_nm, category
FROM
    members;
        
    -- find the member id,member name,category of table members whose category = "f"
SELECT 
    member_id, member_nm, category
FROM
    members
WHERE
    category = 'f';
        
    -- to find distinct category of table members
SELECT DISTINCT
    (category)
FROM
    members;
        
    -- to find the member id,member name of table members order by desc
SELECT 
    member_id, member_nm
FROM
    members
ORDER BY member_nm DESC;
    
    -- to find the title name,publisher name, subject id of table
SELECT 
    title_nm, e.publisher_nm, subject_id
FROM
    Titles t,
    Publishers e
WHERE
    t.publisher_id = e.publisher_id;
        
    -- to find the count of members of category
SELECT 
    category, COUNT(*)
From
    members
GROUP BY category;
    
    -- to find name of members to which priyamvada belongs
SELECT 
    m1.member_nm
FROM
    members AS m1
        JOIN
    members AS m2 ON m1.category = m2.category
WHERE
    m2.member_nm = 'Priyamvada';
   
   -- to find the status of return book and if returned  then place blank
SELECT 
    issue_dt,
    member_Id,
    e.accession_No,
    IF(status = 0, return_dt, ' ') as Book_Returned
FROM
    Books e,
    Book_Return f
WHERE
    e.accession_No = f.accession_No;
