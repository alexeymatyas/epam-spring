-- Password for test users is qwe123 encrypted with bcrypt
INSERT INTO user (name, password, email, birthday)
VALUES ('Aleksei Matias', '$2a$04$qPyfi.tN3Ldq/LVktl43BuoSAnD7MCHwjjUPfA/bvaoBPbY2re9W2', 'matias.alexey@gmail.com', '1988-01-14');
INSERT INTO user (name, password, email, birthday, roles)
VALUES ('Manager 1', '$2a$04$qPyfi.tN3Ldq/LVktl43BuoSAnD7MCHwjjUPfA/bvaoBPbY2re9W2', 'manager1@gmail.com', '1988-01-14', 'ROLE_REGISTERED_USER, ROLE_BOOKING_MANAGER');
INSERT INTO user (name, password, email, birthday, roles)
VALUES ('Manager 2', '$2a$04$qPyfi.tN3Ldq/LVktl43BuoSAnD7MCHwjjUPfA/bvaoBPbY2re9W2', 'manager2@gmail.com', '1988-01-14', 'ROLE_REGISTERED_USER, ROLE_BOOKING_MANAGER');

INSERT INTO movie (rating_id, title, base_price) VALUES (2, 'Forrest Gump', 500);

INSERT INTO event (movie_id, auditorium_id, scheduled_time) VALUES (1, 1, '2016-01-01 17:00:00');

INSERT INTO booking (user_id, event_id, seat_number, price, booking_time)
VALUES (1, 1, 1, 100, '2016-01-01 17:00:00');