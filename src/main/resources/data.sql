INSERT INTO USERS(username,password,enabled) VALUES('user','pass',true);
INSERT INTO USERS(username,password,enabled) VALUES('admin','pass',true);
INSERT INTO USERS(username,password,enabled) VALUES('white','white',true);

INSERT INTO AUTHORITIES(username,authority) VALUES('user','ROLE_USER');
INSERT INTO AUTHORITIES(username,authority) VALUES('admin','ROLE_ADMIN');


INSERT INTO DNA (id,sequence, creation_date, created_by) VALUES (1,'5-GTATTACCCTAGTAATAGCGCCCGCTATGTACCACCTCTG-3', now(), 'americano2021');
INSERT INTO DNA (id,sequence, creation_date, created_by) VALUES (2,'5-CTAGTAATACCCTAGTACTATGTAAATAGCGCTATGGTAA-3', now(), 'benjamin');
INSERT INTO DNA (id,sequence, creation_date, created_by) VALUES (3,'5-CCGCTATACCCTTTACCCGTACCGTAAAGTAATGCGCT-3', now(), 'white' ); 

INSERT INTO PRIMER (id, name, sequence, creation_date, created_by) VALUES (1,'TRAV2 F1','5-CCGCTATACCCTTTACCCGTACCGTAAAGTAATGCGCT-3', now(), 'white' ); 
INSERT INTO PRIMER (id, name, sequence, creation_date, created_by) VALUES (2,'TRAV2 R1','5-TCACTTTTGCCACCTGCTTC-3', now(), 'mercy25');
INSERT INTO PRIMER (id, name, sequence, creation_date, created_by) VALUES (3,'TRAV11 F1','5-TGGCTGTACTTCCTGAGAGTC-3', now(), 'mercy25');
INSERT INTO PRIMER (id, name, sequence, creation_date, created_by) VALUES (4,'TRAV11 R1','5-ATAATGCAGCCACAAGACCAC-3', now(), 'mercy25' );
INSERT INTO PRIMER (id, name, sequence, creation_date, created_by) VALUES (5,'TRAV14 F1','5-AGCTGAGGTGCCTGTGAAGT-3', now(), 'white' );
INSERT INTO PRIMER (id, name, sequence, creation_date, created_by) VALUES (6,'TRAV14 R1','5-ACTCACCAGCTAGGTGAAGG-3', now(), 'white' );
INSERT INTO PRIMER (id, name, sequence, creation_date, created_by) VALUES (7,'TRAV15D-1 F1','5-AAGTAAGAGGCTGTGGTAAGCTCT-3', now(), 'americano2021');
INSERT INTO PRIMER (id, name, sequence, creation_date, created_by) VALUES (8,'TRAV15D-1 R1','5-TCTAAGTGCCTGCCACGTGT-3', now(), 'white' );
INSERT INTO PRIMER (id, name, sequence, creation_date, created_by) VALUES (9,'TRAV15D-2 F1','5-ATGCACACTGCCTGTCTCTC-3', now(), 'americano2021' );

