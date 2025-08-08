CREATE TABLE IF NOT EXISTS patient
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    address         VARCHAR(255)        NOT NULL,
    birth_date  DATE                NOT NULL,
    registered_date DATE                NOT NULL
);

INSERT INTO patient (id, name, email, address, birth_date, registered_date) VALUES ('123e4567-e89b-12d3-a456-426614174001', 'Nguyen Van A', 'nguyenvana@example.com', '123 Le Loi, Hanoi', '1990-05-10', '2023-01-01');
INSERT INTO patient (id, name, email, address, birth_date, registered_date) VALUES ('123e4567-e89b-12d3-a456-426614174002', 'Tran Thi B', 'tranthib@example.com', '456 Tran Phu, HCMC', '1985-11-23', '2022-12-15');
INSERT INTO patient (id, name, email, address, birth_date, registered_date) VALUES ('123e4567-e89b-12d3-a456-426614174003', 'Le Van C', 'levanc@example.com', '789 Nguyen Trai, Da Nang', '1992-08-05', '2023-04-20');