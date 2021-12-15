INSERT INTO users(firstname, middlename, lastname, gender, address, contact_no, email_address, password)
VALUES ('admin', 'admin', 'admin', 'MALE', 'Nepal', '9801111111', 'admin@gmail.com', 'admin');

INSERT INTO book_details(author, title, isbn, published_date)
VALUES ('J.K Rowling', 'Harry Potter', '123123123', '2021-09-11');

insert into books(book_detail_id)
values (1);
insert into books(book_detail_id)
values (1);

INSERT INTO book_histories(book_id, user_id, book_taken_date, book_returned_date)
VALUES (1, 1, '2021-09-16', '2021-09-19');

INSERT INTO courses(title,description,duration) VALUES('Bachelor In Information Technology', 'This is to make students life hell', '4 years');
INSERT INTO subjects(title,description,credit_hours) VALUES('Java', 'Fun', 8);

INSERT INTO programs(year,month,course_id) VALUES (2021,07,1);
insert into attendances(program_id,user_id,state) values(1,1,'PRESENT');

INSERT INTO course_subjects(course_id,subject_id) VALUES (1,1);

INSERT INTO roles(name) VALUES('SUPER_ADMIN'),('ADMIN'),('STAFF'),('INSTRUCTOR'),('LIBRARIAN'),('STUDENT');

INSERT INTO authorities(name) VALUES ('ADD_USER'),('VIEW_USER'),('UPDATE_USER'),('DELETE_USER');

INSERT INTO role_authorities(role_id, authority_id) VALUES(1, 1),(1, 2),(1, 3),(1, 4);
