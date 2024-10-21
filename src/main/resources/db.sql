CREATE DATABASE student_management;

USE student_management;

CREATE TABLE student
(
    id    BINARY(16)   NOT NULL,
    name  VARCHAR(255) NULL,
    score DOUBLE       NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);

-- Trigger để tạo UUID cho student nếu null
DELIMITER $$
CREATE TRIGGER before_insert_student
    BEFORE INSERT
    ON student
    FOR EACH ROW
BEGIN
    IF NEW.id IS NULL THEN
        SET NEW.id = UUID();
    END IF;
END$$
DELIMITER ;

insert into clazz (id, name) values (1, 'Lớp A'), (2, 'Lớp B');
-- Chèn dữ liệu vào bảng student
INSERT INTO student (id, name, score, clazz_id)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Nguyễn Văn A', 85.5, 1),
       (UNHEX(REPLACE(UUID(), '-', '')), 'Trần Thị B', 90.0, 1),
       (UNHEX(REPLACE(UUID(), '-', '')), 'Lê Văn C', 78.0, 1),
       (UNHEX(REPLACE(UUID(), '-', '')), 'Phạm Thị D', 88.0, 2),
       (UNHEX(REPLACE(UUID(), '-', '')), 'Đỗ Văn E', 92.5, 2);


INSERT INTO student(id, name, score)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Nguyễn Văn A', 9.6)

select student0_.id as id1_0_, student0_.name as name2_0_, student0_.score as score3_0_ from Student student0_ where student0_.name like concat('%', ?, '%')