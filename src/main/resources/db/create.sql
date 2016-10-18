CREATE TABLE user (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE rating (
    id BIGINT PRIMARY KEY,
    code VARCHAR(255)
);

CREATE TABLE movie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rating_id INT NOT NULL,
    title VARCHAR(255),
    base_price DECIMAL(10, 2)
);

CREATE TABLE auditorium (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    capacity INT
);

CREATE TABLE event (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT NOT NULL,
    auditorium_id INT NOT NULL,
    scheduled_time TIMESTAMP
);