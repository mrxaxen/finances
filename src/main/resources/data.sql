insert into user (username, password, enabled, role) values ('user', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_USER');

insert into transaction(title,change,user_id,creation_date) values('Penny',-2000,1,CURRENT_TIMESTAMP());
insert into transaction(title,change,user_id,creation_date) values('Bills',-20000,1,CURRENT_TIMESTAMP());
insert into transaction(title,change,user_id,creation_date) values('Salary',100000,1,CURRENT_TIMESTAMP());