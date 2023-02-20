INSERT INTO users (EMAIL, NAME, PASSWORD, REGISTERED)
VALUES ('user@mail.ru',  'Mike', 'password', '2016-03-26'),
       ('admin@mail.ru', 'Jonny Favorite', 'admin', '2016-03-26'),
       ('vasya@google.com', 'Вася', 'vasya', '2016-03-26');

INSERT INTO QUOTE (content, rating, REGISTERED, USER_ID)
VALUES ('1st Article', 5, '2023-02-13', 1),
       ('2nd Article', 0, '2016-02-14', 3),
       ('3rd Article', 2, '2016-02-15', 1);

INSERT INTO VOTE (STATUS, QUOTE_ID, REGISTERED,  USER_ID)
VALUES (TRUE, 1, '2023-02-14', 1),
       (FALSE, 2, '2023-02-14', 3),
       (TRUE, 2, '2023-02-15', 1);