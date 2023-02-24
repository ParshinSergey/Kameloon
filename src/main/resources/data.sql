INSERT INTO users (EMAIL, NAME, PASSWORD, REGISTERED)
VALUES ('user@mail.ru',  'Mike', 'password', '2022-02-26'),
       ('admin@test.org', 'Jonny Favorite', 'admin', '2022-02-26'),
       ('joe@yahoo.com', 'Joe Doe', 'pass123', '2022-02-26'),
       ('bred@mail.com', 'Bred', 'pass456', '2022-02-26'),
       ('steve@google.com', 'Steve', 'pass555', '2022-03-26'),
       ('victor@google.com', 'Victor', 'pass666', '2022-03-26'),
       ('visitor@google.com', 'Visitor', 'avoid', '2022-03-26'),
       ('ivan@google.com', 'Ivan', 'vanvan', '2022-03-26');

INSERT INTO QUOTE (content, rating, REGISTERED, USER_ID)
VALUES ('1st Article', 5, '2023-02-13', 1),
       ('2nd Article', 3, '2016-02-14', 2),
       ('3rd Article', 2, '2016-02-15', 1),
       ('4th Article', 11, '2016-02-16', 4),
       ('5th Article', 7, '2016-02-16', 4),
       ('6th Article', 14, '2016-02-17', 2),
       ('7th Article', 3, '2016-02-17', 2),
       ('8th Article', 0, '2016-02-18', 5),
       ('9th Article', 3, '2016-02-18', 1),
       ('10 Article', 0, '2016-02-19', 3),
       ('11 Article', 0, '2016-02-20', 4),
       ('12 Article', 0, '2016-02-20', 2),
       ('13 Article', 0, '2016-02-21', 6),
       ('14 Article', 0, '2016-02-21', 1),
       ('15 Article', 0, '2016-02-21', 7),
       ('16 Article', 0, '2016-02-22', 8);

INSERT INTO VOTE (STATUS, QUOTE_ID, REGISTERED,  USER_ID)
VALUES (TRUE, 1, '2023-02-14', 1),
       (FALSE, 2, '2023-02-14', 3),
       (TRUE, 2, '2023-02-15', 1);