insert into user (username, password, enabled, role) values ('user', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_USER');
insert into user (username, password, enabled, role) values ('admin', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_ADMIN');

insert into transaction(title,change,user_id,creation_date) values('Penny',-4000,1,CURRENT_TIMESTAMP());
insert into transaction(title,change,user_id,creation_date) values('Bills',-10000,1,CURRENT_TIMESTAMP());
insert into transaction(title,change,user_id,creation_date) values('Salary',100000,1,CURRENT_TIMESTAMP());
insert into transaction(title,change,user_id,creation_date) values('Transport',-3500,1,CURRENT_TIMESTAMP());

