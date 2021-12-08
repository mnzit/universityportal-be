# UniversityPortal

## Stack
1. Java (Spring Boot)
2. JavaScript (Angular)
5. MySQL - Local
6. PostGres - Production
7. Minio
8. Tomcat Server
10. Heroku

## Plan
1. LibraryMgmt
2. CourseMgmt
3. GradeMgmt
4. AttendanceMgmt
5. UserMgmt
6. StudentPerformanceMetrics
7. NoticeMgmt


### LibraryMgmt
1. Book History Mgmt
### CourseMgmt
1. Course and Subject
### GradeMgmt
1. Managed by teachers
2. Student can viwe their grade based on subjects
### AttendanceMgmt
1. Will contain EmailFeature for each attendance done or missed
2. Will generate Attendance report
3. Will have features to take leaves.
### UserMgmt
1. Email to User after account creation
### NoticeMgmt
1. Will have functionality to post any notice (Holiday, Assignment)

### Entities

1. [User](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/User.java)
3. Role
4. Authority
5. [BookDetail](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/BookDetail.java)
6. [Book](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Book.java)
7. BookHistory
8. [Course](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Course.java)
9. [Subject](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Subject.java)
10. CourseSubject
11. Program
12. Attendance
13. Holiday
14. Post
15. Comment
16. PostComment
17. File

### Tables

1. Users
![image](https://user-images.githubusercontent.com/21164124/145242624-b399cf94-bb6a-4bb3-b2f9-c0d4c643ce0f.png)

3. Roles
4. Authorities
5. BookDetails
6. Books
7. BookHistories
8. Courses
9. Subjects
10. CourseSubjects
11. Programs
12. Attendances
13. Holidays
14. Posts
15. Comments
16. PostComments
17. Files
