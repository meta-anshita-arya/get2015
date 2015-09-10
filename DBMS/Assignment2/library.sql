USE Library_Management;

-- Query to  display results in ascending order of issue date and within issue date in ascending order of members name.
SELECT 
    f.issue_dt,
    f.member_Id,
    f.accession_No,
    IF(e.status = 0, return_dt, ' ') as Book_Returned
from
    Books e,
    Book_Return f,
    Members m
WHERE
    ((e.accession_No = f.accession_No) && (f.member_Id = m.member_Id))
ORDER BY issue_dt asc ,member_nm asc;
