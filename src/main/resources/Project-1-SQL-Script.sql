DROP SCHEMA IF EXISTS project_1 CASCADE;
DROP TABLE IF EXISTS project_1.ers_reimbursement_status CASCADE;
DROP TABLE IF EXISTS project_1.ers_reimbursement_type CASCADE;
DROP TABLE IF EXISTS project_1.ers_user_roles CASCADE;
DROP TABLE IF EXISTS project_1.ers_reimbursement CASCADE;
DROP TABLE IF EXISTS project_1.ers_user CASCADE;

CREATE SCHEMA project_1; 

CREATE TABLE project_1.ers_reimbursement_status(
	reimb_status_id SERIAL PRIMARY KEY,
	reimb_status VARCHAR (10)
);

CREATE TABLE project_1.ers_reimbursement_type(
	reimb_type_id SERIAL PRIMARY KEY,
	reimb_type VARCHAR (10)
);

CREATE TABLE project_1.ers_user_roles(
	ers_user_role_id SERIAL PRIMARY KEY,
	user_role VARCHAR (10)
);

	
CREATE TABLE project_1.ers_user(
	ers_user_id SERIAL PRIMARY KEY,
	ers_username VARCHAR (50),
	ers_password VARCHAR (50),
	user_first_name VARCHAR (100),
	user_last_name VARCHAR (100),
	user_email VARCHAR (150),
	user_role_id INTEGER REFERENCES project_1.ers_user_roles (ers_user_role_id)
);

CREATE TABLE project_1.ers_reimbursement(
	reimb_id SERIAL PRIMARY KEY,
	reimb_amount INTEGER,
	reimb_submitted TIMESTAMP,
	reimb_resolved TIMESTAMP,
	reimb_description VARCHAR (250),
	reimb_receipt BYTEA,
	reimb_author INTEGER REFERENCES project_1.ers_user (ers_user_id),
	reimb_resolver INTEGER REFERENCES project_1.ers_user (ers_user_id),
	reimb_status_id INTEGER REFERENCES project_1.ers_reimbursement_status (reimb_status_id),
	reimb_type_id INTEGER REFERENCES project_1.ers_reimbursement_type (reimb_type_id)
	);

INSERT INTO project_1.ers_user_roles (user_role) VALUES ('Manager'), ('Employee');
INSERT INTO project_1.ers_reimbursement_status (reimb_status) VALUES ('Pending'), ('Approved'), ('Denied');
INSERT INTO project_1.ers_reimbursement_type (reimb_type) VALUES ('Food'), ('Travel'), ('Lodging'), ('Other');

INSERT INTO project_1.ers_user (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)  
VALUES 
	('manager', '1234', 'Stef','Angel','sangel@revature.net', 1),
	('employee', '4321', 'Jim','Carey','jcarey@revature.net', 2);

	SELECT * from ERS_USER EU where ERS_USER_ID = ?

INSERT INTO project_1.ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, 
	reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES 
	(100, '12/20/2019 11:23:12', null, 'Flight to Austin', null, 2, 1, 1, 2),
	(50, '12/22/2019 09:02:42', '12/23/2019 09:55:02', 'Annual Conference Dinner', null, 2, 1, 2, 1),
	(822, '12/31/2019 02:01:17', '1/02/2020 09:22:20', 'A very fancy hotel', null, 2, 1, 3, 3);
