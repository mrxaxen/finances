insert into user (username, password, enabled, role) values ('user', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_USER');
insert into user (username, password, enabled, role) values ('admin', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_ADMIN');

insert into transaction(title,change,user_id,creation_date) values('Penny',-4000,1,CURRENT_TIMESTAMP());
insert into transaction(title,change,user_id,creation_date) values('Electricity Bill',-10000,1,CURRENT_TIMESTAMP());
insert into transaction(title,change,user_id,creation_date) values('Salary',100000,1,CURRENT_TIMESTAMP());
insert into transaction(title,change,user_id,creation_date) values('Transport',-3500,1,CURRENT_TIMESTAMP());
insert into transaction(title,change,user_id,creation_date) values('Phone Bill',-3500,1,'2019-02-13 11:11:11');
insert into transaction(title,change,user_id,creation_date) values('Company salary',35000,1,'2019-06-13 11:11:11');
insert into transaction(title,change,user_id,creation_date) values('Ebay shopping',-5000,1,'2018-02-13 11:11:11');

