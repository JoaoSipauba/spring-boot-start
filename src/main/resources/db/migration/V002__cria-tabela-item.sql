create table if not exists item  (
 id SERIAL PRIMARY KEY,
 nome varchar(60) NOT NULL,
 preco float NOT NULL
);