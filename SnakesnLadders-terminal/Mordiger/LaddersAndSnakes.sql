DROP TABLE IF EXISTS shortcut CASCADE;

CREATE TABLE shortcut
(
	from1 INTEGER PRIMARY KEY,
	to1 INTEGER,
	type1 BOOLEAN
	
);

INSERT INTO shortcut
	(from1, to1, type1)
VALUES
	(16, 4, false),
	(49, 11, false),
	(62, 18, false),
	(87, 24, false),
	(47, 26, false),
	(56, 53, false),
	(64, 60, false),
	(92, 71, false),
	(95, 75, false),
	(98, 78, false),
	(2, 38, true),
	(4, 14, true),
	(8, 31, true),
	(21, 42, true),
	(28, 84, true),
	(36, 44, true),
	(51, 67, true),
	(71, 91, true),
	(80, 100, true);
	
