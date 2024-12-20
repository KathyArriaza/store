Create database db_store;
Create database db_payment;


Use db_store;
-- Insert Clients into db_store;
INSERT INTO clients (id, name, email) VALUES
(1, 'Rodrigo Pérez', 'rodrigo.perez@gmail.com'),
(2, 'Juan Márquez', 'juan.marquez@yahoo.com'),
(3, 'Erika Martínez', 'erika.martinez@hotmail.com'),
(4, 'Camila Gómez', 'camila.gomez@outlook.com'),
(5, 'Santiago López', 'santiago.lopez@gmail.com');
