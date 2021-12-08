# UniversityPortal
[![Java CI with Maven](https://github.com/mnzit/UniversityPortal/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/mnzit/UniversityPortal/actions/workflows/maven.yml)
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
* Role
* Authority
* [BookDetail](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/BookDetail.java)
* [Book](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Book.java)
* BookHistory
* [Course](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Course.java)
* [Subject](https://github.com/mnzit/UniversityPortal/blob/master/src/main/java/com/nepalaya/up/model/Subject.java)
* CourseSubject
* Program
* Attendance
* Holiday
* Post
* Comment
* PostComment
* File

### Tables

* [Users](https://user-images.githubusercontent.com/21164124/145244710-6509de01-f3bf-4337-90c5-5e0f90d4d449.png)
* [BookDetails](https://user-images.githubusercontent.com/21164124/145244331-9ab7f7e1-02bb-4c75-9941-176d7ceae7ca.png)
* [Books](https://user-images.githubusercontent.com/21164124/145244460-8502f0ac-fa30-4785-9503-3a284e0bd654.png)



