CREATE TABLE student
(
    id    BINARY(16)   NOT NULL,
    name  VARCHAR(255) NULL,
    score DOUBLE       NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);