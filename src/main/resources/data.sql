CREATE DATABASE eyecode;

use eyecode;

CREATE TABLE usuario

(
id BIGINT auto_increment PRIMARY KEY,
email VARCHAR(35),
nome VARCHAR(20),
senha VARCHAR(45),
deficiencia VARCHAR(20)
);
