INSERT INTO students (name, last_name)
VALUES ('John', 'Doe'),
       ('Jane', 'Smith'),
       ('Alice', 'Johnson');

INSERT INTO books (title, author, student_id)
VALUES
    ('Java Basics', 'Author A', 1),
    ('Spring Boot Guide', 'Author B', 1),
    ('Hibernate in Action', 'Author C', 2);

INSERT INTO teachers (name, last_name)
VALUES ('Mr.', 'Anderson'),
       ('Ms.', 'Brown');

INSERT INTO student_group (teacher_id, student_id)
VALUES(1, 1),
      (1, 2),
      (2, 2),
      (2, 3);
