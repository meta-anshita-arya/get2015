USE library_management;
        
        -- to display information of books issued for more than two months
SELECT 
    m.member_nm,
    m.member_id,
    t.title_nm,
    b.accession_no,
    bi.issue_dt,
    bi.due_dt,
    (TIMESTAMPDIFF(MONTH,
        br.issue_dt,
        br.return_dt)>2) AS months_duration
FROM
    members m,
    titles t,
    book_return br,
    books b,
    book_issue bi
WHERE
    m.member_id = bi.member_id && bi.accession_no = b.accession_no && b.title_id = t.title_id && m.member_id = br.member_id && b.status = 0 ;
            
         --  to display member name of maximum length and length  
SELECT 
    member_nm, LENGTH(member_nm) AS Length
FROM
    members
WHERE
    LENGTH(member_nm) = (SELECT 
        MAX(LENGTH(member_nm))
    FROM
        members);
                
                
             -- to diplay count of books issued till now   
SELECT 
    COUNT(DISTINCT accession_no)
FROM
    books;
