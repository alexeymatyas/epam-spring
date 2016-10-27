CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    birthday DATE,
    roles VARCHAR(255) DEFAULT 'ROLE_REGISTERED_USER'
);

CREATE TABLE user_account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    balance DECIMAL(10, 2)
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
    seats_number INT,
    vip_seats VARCHAR(255)
);

CREATE TABLE event (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT NOT NULL,
    auditorium_id INT NOT NULL,
    scheduled_time TIMESTAMP
);

CREATE TABLE booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    event_id INT NOT NULL,
    seat_number INT NOT NULL,
    price DECIMAL(10, 2),
    booking_time TIMESTAMP
);