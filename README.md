# UniversityPortal
[![Java CI with Maven](https://github.com/mnzit/UniversityPortal/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/mnzit/UniversityPortal/actions/workflows/maven.yml)

## Prerequisite
* Core Java
* Spring Core
* Spring MVC
* Database: MySQL

## FYI
* Class Name - PascalCase
* Normal Variable Name - CamelCase
* Table Name - UpperSnakeCase
* Final Variable Name - UpperSnakeCase

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
2. Student can view their grade based on subjects
### AttendanceMgmt
1. Will contain EmailFeature for each attendance done or missed
2. Will generate Attendance report
3. Will have features to take leaves.
### UserMgmt
1. Email to User after account creation
### NoticeMgmt
1. Will have functionality to post any notice (Holiday, Assignment)

### Entities

* [User](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/User.java)
* [Role](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Role.java)
* [Authority](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Authority.java)
* [RoleAuthority](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/RoleAuthority.java)
* [BookDetail](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/BookDetail.java)
* [Book](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Book.java)
* [BookHistory](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/BookHistory.java)
* [Course](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Course.java)
* [Subject](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Subject.java)
* [CourseSubject](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/CourseSubject.java)
* [Program](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Program.java)
* [Attendance](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Attendance.java)
* [Holiday](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Holiday.java)
* [Post](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Post.java)
* [CourseSubject](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/CourseSubject.java)
* [PostComment](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/PostComments.java)
* [File](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/File.java)

### Tables

* [Users](https://user-images.githubusercontent.com/21164124/145244710-6509de01-f3bf-4337-90c5-5e0f90d4d449.png)
* [BookDetails](https://user-images.githubusercontent.com/21164124/145244331-9ab7f7e1-02bb-4c75-9941-176d7ceae7ca.png)
* [Books](https://user-images.githubusercontent.com/21164124/145244460-8502f0ac-fa30-4785-9503-3a284e0bd654.png)
* [Subject](https://user-images.githubusercontent.com/21164124/146192661-041b2dae-3c0e-4f9a-a262-915b6eecf2b3.png)




