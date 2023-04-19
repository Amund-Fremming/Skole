DROP TABLE IF EXISTS rentaloffice CASCADE;
DROP TABLE IF EXISTS address CASCADE;
DROP TABLE IF EXISTS userr CASCADE;
DROP TABLE IF EXISTS car CASCADE;
DROP TABLE IF EXISTS rental CASCADE;


CREATE TABLE address
(
	addressid SERIAL PRIMARY KEY,
	streetadr VARCHAR,
	postalcode VARCHAR,
	region VARCHAR
);

CREATE TABLE rentaloffice
(
	officeid SERIAL PRIMARY KEY,
	name VARCHAR,
	mobile VARCHAR,
	addressid INTEGER NOT NULL,
	FOREIGN KEY (addressid) REFERENCES address(addressid)
);

CREATE TABLE userr
(
	mobile VARCHAR PRIMARY KEY,
	fname VARCHAR,
	lname VARCHAR,
	addressid INTEGER NOT NULL,
	password VARCHAR,
	FOREIGN KEY (addressid) REFERENCES address(addressid)
);

CREATE TABLE car
(
	regnr VARCHAR PRIMARY KEY,
	brand VARCHAR,
	model VARCHAR,
	color VARCHAR,
	sizegroup VARCHAR(1),
	available BOOLEAN,
	img VARCHAR,
	officeid INTEGER,
	FOREIGN KEY (officeid) REFERENCES rentaloffice(officeid)
);

CREATE TABLE rental
(
	rentalid SERIAL PRIMARY KEY,
	mobile VARCHAR,
	regnr VARCHAR,
	creditcard VARCHAR,
	km_start VARCHAR,
	dt_start VARCHAR,
	km_end VARCHAR,
	dt_end VARCHAR,
	FOREIGN KEY (mobile) REFERENCES userr(mobile),
	FOREIGN KEY (regnr) REFERENCES car(regnr)
);





	
