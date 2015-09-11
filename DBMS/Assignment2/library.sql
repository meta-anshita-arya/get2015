USE library_management;
        
        -- to display subject wise information on number of books purchased
SELECT 
    COUNT(s.subject_id) AS TOTAL_BOOKS,
    s.subject_id,
    s.subject_nm
FROM
    books b
        INNER JOIN
    titles t
        INNER JOIN
    subjects s
WHERE
    ((b.title_id = t.title_id) AND (t.subject_id = s.subject_id))
GROUP BY s.subject_id ;
        
        
        -- to display number of books returned after 2 months
SELECT 
    *
FROM
    book_issue bi
WHERE
    (TIMESTAMPDIFF(MONTH,
        bi.due_dt,
        bi.issue_dt)) > 2;
        
        -- to display books having price greater than minimum price
SELECT 
    title_nm
FROM
    titles t,
    books b1
WHERE
    t.title_id = b1.title_id && b1.price > (SELECT 
        MIN(b.price)
    FROM
        books b);
