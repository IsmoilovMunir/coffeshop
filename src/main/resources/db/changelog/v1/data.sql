INSERT INTO role(name) VALUES ('ROLE_USER');
INSERT INTO role(name) VALUES ('ROLE_ADMIN');

INSERT INTO users(role_id, username, password, first_name, last_name, email, phone_number)
VALUES ((select id from role where name = 'ROLE_ADMIN'), 'admin', '$2a$10$Hf4NrDcWuDmNzPvoNpE2SenmtB0CLMZLOSqiq92iICj/XAATOqBg2', 'админ', 'админ', 'admin@mail.ru', '123123');

INSERT INTO users(role_id, username, password, first_name, last_name, email, phone_number)
VALUES ((select id from role where name = 'ROLE_USER'), 'demo', '$2a$10$dZ0vkWYA7gZtlsbOA1f2pOHR.pYziJifFbW2.EJkZyv8Fe4HIqH1K', 'demo', 'demo', 'demo@mail.ru', '123123');