INSERT INTO roles(name, created_date)
VALUES ('SUPER_ADMIN', NOW()),
       ('ADMIN', NOW()),
       ('STAFF', NOW()),
       ('INSTRUCTOR', NOW()),
       ('LIBRARIAN', NOW()),
       ('STUDENT', NOW());

INSERT INTO users(firstname, middlename, lastname, gender, address, contact_no, email_address, password, role_id,
                  created_by, created_date)
VALUES ('Manjit', NULL, 'Shakya', 'MALE', 'KTM', '9808546851', 'manjit@gmail.com', 'password', 1, null, NOW()),
       ('Anita', NULL, 'Joshi', 'FEMALE', 'KTM', '9808546852', 'anita@gmail.com', 'password', 1, 1, NOW()),
       ('Nawaraj', NULL, 'Shrestha', 'MALE', 'KTM', '9808546853', 'nawaraj@gmail.com', 'password', 1, 1, NOW()),
       ('Sapana', NULL, 'Rimal', 'FEMALE', 'KTM', '9808546854', 'sapana@gmail.com', 'password', 1, 1, NOW()),
       ('Nabin', NULL, 'Shrestha', 'MALE', 'KTM', '9808546855', 'nabin@gmail.com', 'password', 1, 1, NOW());

INSERT INTO book_details(author, title, isbn, published_date, created_date, created_by)
VALUES ('J.K Rowling', 'Harry Potter', '123123123', NOW(), NOW(), 1);

insert into books(book_detail_id, created_by, created_date)
values (1, 1, NOW()),
       (1, 1, NOW());

-- INSERT INTO book_histories(book_id, user_id, book_taken_date, book_returned_date, created_by, created_date)
-- VALUES (1, 1, NOW(), NOW(), 1, NOW());

INSERT INTO courses(title, description, duration, duration_type, created_date, created_by)
VALUES ('Bachelor In Information Technology', '<p>Bachelor of Information Technology(BIT) is one of the demanding and popular courses. The course will equip students with the technical skills and knowledge to succeed in&nbsp;this expanding and diverse industry. Students will get exposed to practical experience in the field of information technology that can&nbsp;apply technical skills to solve problems, support innovation, and improve communication between people. Bachelor of Information Technology is offered by two Universities in Nepal - Tribhuvan University and Purbanchal University.</p>
<p><a href="https://edusanjal.com/course/bachelor-information-technology-bit-tribhuvan-university/" style="font-size: 21px;">Bachelor''s in Information Technology (BIT) -&nbsp;Tribhuvan University</a><br></p>
<p>This program was started by Tribhuvan University in 2076 B.S. Bachelors in Information Technology (BIT) program of Tribhuvan University is designed by closely following the courses practiced in accredited international universities, subject to the condition that the intake students are twelve years of schooling in any stream or equivalent from any recognized board. Currently, only seven constituent colleges run the program under TU.</p>
<p>In addition to the foundation and core Information Technology courses, Bachelors in Information Technology (BIT) offers several elective courses to meet the undergraduate academic program requirement and to fulfill the demand for the development and implementation of new technology.&nbsp;</p>
<p><strong>Objective:&nbsp;</strong></p>
<p>The main objective of the BIT program of Tribhuvan University is to provide students intensive knowledge and skill to design. develop, and use information technology in different areas. It is envisaged that graduates of this program will be equipped with the necessary knowledge of Information Technology to compete in this global world.&nbsp;</p>
<h4><a href="https://edusanjal.com/course/bachelor-of-information-technology-bit-purbanchal-university/">Bachelor&nbsp;of Information Technology(BIT) - Purbanchal University</a></h4>
<p>The Bachelor of Information Technology is an academic program of Purbanchal University comprising of the core unit and advanced unit. The core unit of Bachelor of Information Technology (BIT) covers the fundamentals of information technology that provide students with knowledge and skills in programming, systems design, computer networks, and communication. The advanced unit enables students to exercise, develop and apply their knowledge and skills in the areas of Multimedia, Artificial Intelligence, Mobile communication, the Internet, and the World Wide Web.<br></p>
<p>Bachelor of Information Technology(BIT) is a four-year, eight semesters academic program at Purbanchal University. The course offers scientific and technical depth along with study in areas such as management, communications, and aspects of human behavior, all of which are vital to the success of an IT professional.</p>
<p><a href="https://edusanjal.com/course/bachelor-of-information-technology-bit-purbanchal-university/">Click here</a>&nbsp;to view details about the Bachelor of Information Technology(BIT) course- Purbanchal University<br></p>
<p><strong>The objective of the Information Technology Program(BIT)</strong></p>
<p>Bachelor of Information Technology will prepare students for a career in regard to&nbsp;computers and information where one can apply technical skills to solve problems,&nbsp;&nbsp;support innovation, and improve communication between people.</p>
<ul><li>Train students to analyze, design, and implement computer-based systems related to recent developments like internet technology, multimedia, web-based applications, and mobile communications.</li><li>Impart knowledge to appreciate the rapidity of technological changes and develop an understanding of the field of study, relevant to integrative design.</li><li>Build the ability to use communication technology and enable to apply these skills in the various communication media.</li><li>Develop the abilities and interpersonal skills important for effective participation and leadership in the industry.</li></ul>
<p><span style="font-size: 13px;"></span></p>', '4', 'YEAR', NOW(), 1);

INSERT INTO subjects(title, description, credit_hours, created_date, created_by)
VALUES ('Java', 'Java is nice', 8, NOW(), 1);

INSERT INTO programs(year, month, course_id, created_date, created_by)
VALUES (2021, 07, 1, NOW(), 1);

insert into attendances(program_id, user_id, state, created_date, created_by)
values (1, 1, 'PRESENT', NOW(), 1);

INSERT INTO course_subjects(course_id, subject_id, created_date, created_by)
VALUES (1, 1, NOW(), 1);

INSERT INTO authorities(name, created_date)
VALUES ('ADD_USER', NOW()),
       ('VIEW_USER', NOW()),
       ('UPDATE_USER', NOW()),
       ('DELETE_USER', NOW());

INSERT INTO role_authorities(role_id, authority_id, created_date)
VALUES (1, 1, NOW()),
       (1, 2, NOW()),
       (1, 3, NOW()),
       (1, 4, NOW());


