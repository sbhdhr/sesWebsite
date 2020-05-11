select max(id) from incoming_alert;



SELECT * FROM information_schema.sequences;
truncate table incoming_alert ;
ALTER SEQUENCE incoming_alert_id_seq RESTART WITH 1;


INSERT INTO public.alert_type (description) VALUES 
('Biodegradable bin is full !!')
,('Non-Biodegradable bin is full !!')
,('Biodegradable bin lock malfunction !!')
,('Non-Biodegradable lock malfunction !!');

-- drop table alert_type;
-- drop table incoming_alert;