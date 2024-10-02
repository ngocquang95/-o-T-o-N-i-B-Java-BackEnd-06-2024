CREATE DATABASE student_management;

USE student_management;

CREATE TABLE student (
                         id CHAR(36) PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         score DOUBLE NOT NULL
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

-- Chèn dữ liệu vào bảng student
INSERT INTO student (id, name, score)
VALUES (UUID(), 'Nguyễn Văn A', 85.5),
       (UUID(), 'Trần Thị B', 90.0),
       (UUID(), 'Lê Văn C', 78.0),
       (UUID(), 'Phạm Thị D', 88.0),
       (UUID(), 'Đỗ Văn E', 92.5);