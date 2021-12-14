INSERT INTO users(firstname, middlename, lastname, gender, address, contact_no, email_address, password)
VALUES ('admin', 'admin', 'admin', 'MALE', 'Nepal', '980XXXXXXX', 'admin@gmail.com', 'adminadmin');

INSERT INTO book_details(author, title, isbn, published_date)
VALUES ('J.K Rowling', 'Harry Potter', '123123123', '2021-09-11');

INSERT INTO  Programs(YEAR ,MONTH ,COURSE_ID) VALUES (2021,07,1002);
insert into attendances(program_id) values(1);
insert into attendances(user_id) values(1)

insert into books(book_detail_id)
values (1);
insert into books(book_detail_id)
values (1);

INSERT INTO book_histories(book_id, user_id, book_taken_date, book_returned_date)
VALUES (1, 1, '2021-09-16', '2021-09-19');
