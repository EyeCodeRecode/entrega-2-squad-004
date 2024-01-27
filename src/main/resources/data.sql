CREATE DATABASE eyecode;

use eyecode;

CREATE TABLE user

(
id BIGINT auto_increment PRIMARY KEY,
email VARCHAR(35),
name VARCHAR(20),
password VARCHAR(45),
deficiency VARCHAR(20)
);
