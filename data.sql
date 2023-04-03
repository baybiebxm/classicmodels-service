drop table if exists subject;
create table subject (
    subject_code varchar(10) primary key,
    title varchar(50) not null,
    credit int not null

);

drop table if exists student;
create table student (
    student_id int primary key,
    name varchar(100) not null
);

drop table if exists course;
create table course (
    course_id int primary key,
    subject_code varchar(10) not null
--     foreign key (subject_code) references subject(subject_code)
);
drop table if exists course_student;
create table course_student (
    id int primary key,
    course_id int not null,
    student_id int not null,
    grade int not null
--     FOREIGN KEY (course_id) REFERENCES course(course_id),
);

insert into subject (subject_code, title, credit) values ('INT101', 'Computer Programming I', 1);
insert into subject (subject_code, title, credit) values ('INT102', 'Computer Programming 2', 2);
insert into subject (subject_code, title, credit) values ('INT103', 'Computer Programming 3', 3);
insert into subject (subject_code, title, credit) values ('INT104', 'Computer Programming 4', 4);
insert into subject (subject_code, title, credit) values ('INT105', 'Computer Programming 5', 5);
insert into course (course_id, subject_code) values (1, 'INT101');
insert into course (course_id, subject_code) values (2, 'INT102');
insert into course (course_id, subject_code) values (3, 'INT103');
insert into course (course_id, subject_code) values (4, 'INT104');
insert into course (course_id, subject_code) values (5, 'INT105');
insert into student (student_id,name) values (101, 'Somchai');
insert into student (student_id,name) values (102, 'Apichart');
insert into student (student_id,name) values (103, 'Preeda');
insert into student (student_id,name) values (104, 'Kitichai');
insert into student (student_id,name) values (105, 'Satiya');
insert into student (student_id,name) values (106, 'Meechai');
insert into student (student_id,name) values (107, 'Srisupa');
insert into student (student_id,name) values (108, 'Daranee');
insert into student (student_id,name) values (109, 'Nittaya');
insert into course_student (id, course_id, student_id, grade) values(1, 1, 101, 3.5);
insert into course_student (id, course_id, student_id, grade) values(2, 1, 103, 2.5);
insert into course_student (id, course_id, student_id, grade) values(3, 1, 104, 4);
insert into course_student (id, course_id, student_id, grade) values(4, 2, 102, 2.5);
insert into course_student (id, course_id, student_id, grade) values(5, 2, 105, 2.0);
insert into course_student (id, course_id, student_id, grade) values(6, 3, 106, 2.5);
insert into course_student (id, course_id, student_id, grade) values(7, 3, 107, 3.5);
insert into course_student (id, course_id, student_id, grade) values(8, 3, 108, 1.5);
insert into course_student (id, course_id, student_id, grade) values(9, 3, 109, 2.0);
insert into course_student (id, course_id, student_id, grade) values(10, 4, 106, 2.5);
insert into course_student (id, course_id, student_id, grade) values(11, 4, 107, 3.5);
insert into course_student (id, course_id, student_id, grade) values(12, 5, 108, 1.5);
insert into course_student (id, course_id, student_id, grade) values(13, 5, 109, 2.0);

