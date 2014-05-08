create table establishment (
establishment_id int GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
baseentity_id int,
name VARCHAR(30),
address VARCHAR(50),
telephone VARCHAR(20),
PRIMARY KEY (establishment_id),
FOREIGN KEY (baseentity_id) REFERENCES baseentity(baseentity_id))