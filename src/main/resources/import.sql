
/* populate userdao */
INSERT INTO users (uuid, last_name, name, email) VALUES('6fb6f014-be9e-11e9-9cb5-2a2ae2dbcce4', 'Guzmán', 'pedro', 'pedro@guzman.com');
INSERT INTO users (uuid, last_name, name, email) VALUES('6fb6f29e-be9e-11e9-9cb5-2a2ae2dbcce4', 'carrillo', 'carlos', 'carlos@carrillo.com');
INSERT INTO users (uuid, last_name, name, email) VALUES('6fb6f424-be9e-11e9-9cb5-2a2ae2dbcce4', 'chaker', 'ana', 'ana@chaker.com');
INSERT INTO users (uuid, last_name, name, email) VALUES('6fb6f578-be9e-11e9-9cb5-2a2ae2dbcce4', 'lopez', 'felipe', 'felipe@lopez.com');
INSERT INTO users (uuid, last_name, name, email) VALUES('6fb6f578-be9e-11e9-9cb5-2a2ae2dbcce5', 'sarmiento', 'luis', 'luis@sarmiento.com');


/* populate billdao */
INSERT INTO bills (additional, date_of_billing, total, bill_id) VALUES('tesssst', now(), '12345', '1');
INSERT INTO bills (additional, date_of_billing, total, bill_id) VALUES('test2', now(), '99999', '1');
INSERT INTO bills (additional, date_of_billing, total, bill_id) VALUES('test3', now(), '8595', '1');
INSERT INTO bills (additional, date_of_billing, total, bill_id) VALUES('test4', now(), '456789', '2');
INSERT INTO bills (additional, date_of_billing, total, bill_id) VALUES('test5', now(), '12345', '3');
INSERT INTO bills (additional, date_of_billing, total, bill_id) VALUES('test6', now(), '123213', '2');

/* populate login and roles */
INSERT INTO logins (account_not_expired, account_not_locked, credentials_not_expired, enabled, password, username) VALUES (true, true, true, true, '$2a$10$lalrK9FuMNQTa4I3/hKovuizWbVjVmTxajtH.vW2/fH3Wq67PkvZC', 'carloscarrillo')
INSERT INTO logins (account_not_expired, account_not_locked, credentials_not_expired, enabled, password, username) VALUES (true, true, true, true, '$2a$10$3MOObdDl/pAp28I4ANp/fe65aO9rPyQQqz6ww/Uk3aclgJctZ14YK', 'anachaker')
INSERT INTO logins (account_not_expired, account_not_locked, credentials_not_expired, enabled, password, username) VALUES (true, true, true, true, '$2a$10$3MOObdDl/pAp28I4ANp/fe65aO9rPyQQqz6ww/Uk3aclgJctZ14YK', 'santiagocollazos')
INSERT INTO logins (account_not_expired, account_not_locked, credentials_not_expired, enabled, password, username) VALUES (true, true, true, true, '$2a$10$3MOObdDl/pAp28I4ANp/fe65aO9rPyQQqz6ww/Uk3aclgJctZ14YK', 'felipelopez')

INSERT INTO roles (name) VALUES ('ROLE_ADMIN')
INSERT INTO roles (name) VALUES ('ROLE_USER')

INSERT INTO login_roles (login_id, role_id) VALUES (1,1)
INSERT INTO login_roles (login_id, role_id) VALUES (2,2)
INSERT INTO login_roles (login_id, role_id) VALUES (3,2)
INSERT INTO login_roles (login_id, role_id) VALUES (4,2)



