INSERT INTO users (EMAIL, NAME, PASSWORD, REGISTERED)
VALUES ('user@mail.ru',  'Mike', 'password', '2022-02-26'),
       ('admin@test.org', 'Jonny Favorite', 'admin', '2022-02-26'),
       ('joe@yahoo.com', 'Joe Doe', 'pass123', '2022-02-26'),
       ('bred@mail.com', 'Bred', 'pass456', '2022-02-26'),
       ('steve@google.com', 'Steve', 'pass555', '2022-02-26'),
       ('victor@google.com', 'Victor', 'avoid', '2022-02-26');

INSERT INTO QUOTE (content, rating, REGISTERED, USER_ID)
VALUES ('1st Article', 3, '2023-02-27', 1),
       ('2nd Article', 5, '2023-02-27', 2),
       ('3rd Article', 2, '2023-02-28', 1),
       ('4th Article', 4, '2023-02-28', 4),
       ('5th Article', 2, '2023-03-01', 4),
       ('6th Article', 5, '2023-03-02', 2),
       ('7th Article', 3, '2023-03-02', 2),
       ('8th Article', 0, '2023-03-03', 5),
       ('9th Article', 3, '2023-03-03', 1),
       ('10 Article', 0, '2023-03-04', 3),
       ('11 Article', 0, '2023-03-04', 4),
       ('12 Article', 1, '2023-03-05', 2),
       ('13 Article', 0, '2023-03-06', 6),
       ('14 Article', 0, '2023-03-06', 1),
       ('15 Article', 0, '2023-03-06', 1),
       ('16 Article', 0, '2023-03-06', 1);

INSERT INTO VOTE (STATUS, QUOTE_ID, REGISTERED, USER_ID)
VALUES (TRUE, 1, '2023-02-21', 1),
       (TRUE, 2, '2023-02-21', 1),
       (TRUE, 2, '2023-02-22', 3),
       (TRUE, 2, '2023-02-22', 4),
       (TRUE, 2, '2023-02-22', 5),
       (TRUE, 2, '2023-02-23', 6),
       (FALSE, 1, '2023-02-23', 2),
       (TRUE, 1, '2023-02-24', 3),
       (TRUE, 1, '2023-02-24', 4),
       (TRUE, 1, '2023-02-25', 5),
       (TRUE, 3, '2023-02-25', 3),
       (FALSE, 3, '2023-02-26', 2),
       (TRUE, 3, '2023-02-27', 4),
       (TRUE, 3, '2023-02-28', 5);