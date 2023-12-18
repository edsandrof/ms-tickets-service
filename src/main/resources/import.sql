INSERT INTO tickets.movie (id, director, title) VALUES(1, 'Lana Wachowski', 'The Matrix');
INSERT INTO tickets.movie (id, director, title) VALUES(3, 'John Carpenter', 'The Thing');

INSERT INTO tickets.showtime (id, movie_id, start_at) VALUES(1, 1, '2023-12-25 20:00:00');
INSERT INTO tickets.showtime (id, movie_id, start_at) VALUES(2, 3, '2023-12-25 20:00:00');

INSERT INTO tickets.seat (`number`, reserved, id, showtime_id) VALUES(1, 0, 1, 1);
INSERT INTO tickets.seat (`number`, reserved, id, showtime_id) VALUES(2, 0, 2, 1);
INSERT INTO tickets.seat (`number`, reserved, id, showtime_id) VALUES(3, 0, 3, 1);
INSERT INTO tickets.seat (`number`, reserved, id, showtime_id) VALUES(4, 0, 4, 1);
INSERT INTO tickets.seat (`number`, reserved, id, showtime_id) VALUES(5, 0, 5, 1);
INSERT INTO tickets.seat (`number`, reserved, id, showtime_id) VALUES(1, 0, 6, 2);
INSERT INTO tickets.seat (`number`, reserved, id, showtime_id) VALUES(2, 1, 7, 2);
INSERT INTO tickets.seat (`number`, reserved, id, showtime_id) VALUES(3, 1, 8, 2);
INSERT INTO tickets.seat (`number`, reserved, id, showtime_id) VALUES(4, 1, 9, 2);
INSERT INTO tickets.seat (`number`, reserved, id, showtime_id) VALUES(5, 0, 10, 2);

