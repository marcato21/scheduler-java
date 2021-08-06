CREATE OR REPLACE FUNCTION update_attendance()
RETURNS INTEGER
LANGUAGE plpgsql
AS
$$
BEGIN 

UPDATE person_attendance pa
SET real_att = attendance
FROM (
	SELECT pa.person_id, COUNT(pad2.attendance_date) AS attendance, pa."month", pa."year" 
	FROM person_attendance pa
	JOIN person_attendance_detail pad2
		ON pa.person_id = pad2.person_id 
	WHERE pa.person_id = pad2.person_id 
		AND pa."month" = DATE_PART('month', pad2.attendance_date)
		AND pa."year" = DATE_PART('year', pad2.attendance_date)
	GROUP BY pa.person_id, pa."month", pa."year"
) AS a
WHERE a.person_id = pa.person_id
	AND a."year" = pa."year" 
	AND a."month" = pa."month";

RETURN 1;

END
$$
;