/* -- INSERTAR EN BCE_DB  */
/* -- USUARIO   */

INSERT INTO bce_db.ASIGNAR_IFIN_USR
(IFINUSR_ID, CTA_ID, INSFIN_IDENTIFICACION, USR_IDENTIFICACION, IFINUSR_NUMEROCUENTA, IFINUSR_MONTO, IFINUSR_ESTADO)
VALUES(1, 1, 7, '1716497320', '3001106613', 1000.0000, 1);
INSERT INTO bce_db.ASIGNAR_IFIN_USR
(IFINUSR_ID, CTA_ID, INSFIN_IDENTIFICACION, USR_IDENTIFICACION, IFINUSR_NUMEROCUENTA, IFINUSR_MONTO, IFINUSR_ESTADO)
VALUES(2, 2, 7, '1716497325', '3001095881', 2008.0000, 1);
INSERT INTO bce_db.ASIGNAR_IFIN_USR
(IFINUSR_ID, CTA_ID, INSFIN_IDENTIFICACION, USR_IDENTIFICACION, IFINUSR_NUMEROCUENTA, IFINUSR_MONTO, IFINUSR_ESTADO)
VALUES(3, 1, 7, '1716497393', '3001108163', 1510.0000, 1);
INSERT INTO bce_db.ASIGNAR_IFIN_USR
(IFINUSR_ID, CTA_ID, INSFIN_IDENTIFICACION, USR_IDENTIFICACION, IFINUSR_NUMEROCUENTA, IFINUSR_MONTO, IFINUSR_ESTADO)
VALUES(4, 1, 1, '1716497397', '3001108593', 3000.0000, 1);


/*		*/

INSERT INTO bce_db.ASIGNAR_TRANSACCION
(ASITRA_ID, USR_IDENTIFICACION, TRA_ID, IFINUSR_ID, ASITRA_IDENTIFICADOR, ASITRA_FECHAUSO, ASITRA_MONTO, ASITRA_ESTADO)
VALUES(1, '1716497320', 1, 1, 'A', '2018-12-15 00:00:00.000', 1000.0000, 1);
INSERT INTO bce_db.ASIGNAR_TRANSACCION
(ASITRA_ID, USR_IDENTIFICACION, TRA_ID, IFINUSR_ID, ASITRA_IDENTIFICADOR, ASITRA_FECHAUSO, ASITRA_MONTO, ASITRA_ESTADO)
VALUES(2, '1716497325', 1, 2, 'A', '2018-12-15 00:00:00.000', 2000.0000, 1);
INSERT INTO bce_db.ASIGNAR_TRANSACCION
(ASITRA_ID, USR_IDENTIFICACION, TRA_ID, IFINUSR_ID, ASITRA_IDENTIFICADOR, ASITRA_FECHAUSO, ASITRA_MONTO, ASITRA_ESTADO)
VALUES(3, '1716497393', 1, 3, 'A', '2018-12-15 00:00:00.000', 1500.0000, 1);
INSERT INTO bce_db.ASIGNAR_TRANSACCION
(ASITRA_ID, USR_IDENTIFICACION, TRA_ID, IFINUSR_ID, ASITRA_IDENTIFICADOR, ASITRA_FECHAUSO, ASITRA_MONTO, ASITRA_ESTADO)
VALUES(4, '1716497397', 1, 4, 'A', '2018-12-15 00:00:00.000', 3000.0000, 1);
INSERT INTO bce_db.ASIGNAR_TRANSACCION
(ASITRA_ID, USR_IDENTIFICACION, TRA_ID, IFINUSR_ID, ASITRA_IDENTIFICADOR, ASITRA_FECHAUSO, ASITRA_MONTO, ASITRA_ESTADO)
VALUES(5, '1716497325', 2, 2, 'D', '2018-12-26 04:43:29.000', 1.0000, 1);
INSERT INTO bce_db.ASIGNAR_TRANSACCION
(ASITRA_ID, USR_IDENTIFICACION, TRA_ID, IFINUSR_ID, ASITRA_IDENTIFICADOR, ASITRA_FECHAUSO, ASITRA_MONTO, ASITRA_ESTADO)
VALUES(7, '1716497393', 2, 3, 'D', '2018-12-26 14:02:30.000', 10.0000, 1);
INSERT INTO bce_db.ASIGNAR_TRANSACCION
(ASITRA_ID, USR_IDENTIFICACION, TRA_ID, IFINUSR_ID, ASITRA_IDENTIFICADOR, ASITRA_FECHAUSO, ASITRA_MONTO, ASITRA_ESTADO)
VALUES(8, '1716497325', 3, 2, 'R', '2018-12-26 16:55:34.000', 1.0000, 1);
INSERT INTO bce_db.ASIGNAR_TRANSACCION
(ASITRA_ID, USR_IDENTIFICACION, TRA_ID, IFINUSR_ID, ASITRA_IDENTIFICADOR, ASITRA_FECHAUSO, ASITRA_MONTO, ASITRA_ESTADO)
VALUES(9, '1716497325', 2, 2, 'D', '2018-12-26 17:04:36.000', 9.0000, 1);
INSERT INTO bce_db.ASIGNAR_TRANSACCION
(ASITRA_ID, USR_IDENTIFICACION, TRA_ID, IFINUSR_ID, ASITRA_IDENTIFICADOR, ASITRA_FECHAUSO, ASITRA_MONTO, ASITRA_ESTADO)
VALUES(10, '1716497325', 3, 2, 'R', '2018-12-26 17:16:33.000', 1.0000, 1);


/**/

INSERT INTO bce_db.INSTITUCION_FINANCIERA
(INSFIN_IDENTIFICACION, INSFIN_NOMBRE, INSFIN_CODIGO, INSFIN_TIPO, INSFIN_RAZONSOCIAL, INSFIN_DIRECCION, INSFIN_TELEFONO, INSFIN_FECHAREGISTRO, INSFIN_ESTADO)
VALUES(1, 'Banco Amazonas S.A', '0790221806001', 'Bancos privados', 'Banco Amazonas S.A', 'Quito', '02374859', '2016-12-16 00:00:00.000', 2);
INSERT INTO bce_db.INSTITUCION_FINANCIERA
(INSFIN_IDENTIFICACION, INSFIN_NOMBRE, INSFIN_CODIGO, INSFIN_TIPO, INSFIN_RAZONSOCIAL, INSFIN_DIRECCION, INSFIN_TELEFONO, INSFIN_FECHAREGISTRO, INSFIN_ESTADO)
VALUES(2, 'Banco Bolivariano S.A. ', '0990379017001', 'Bancos privados', 'Banco Bolivariano S.A. ', 'Quito', '02374859', '2016-12-16 00:00:00.000', 4);
INSERT INTO bce_db.INSTITUCION_FINANCIERA
(INSFIN_IDENTIFICACION, INSFIN_NOMBRE, INSFIN_CODIGO, INSFIN_TIPO, INSFIN_RAZONSOCIAL, INSFIN_DIRECCION, INSFIN_TELEFONO, INSFIN_FECHAREGISTRO, INSFIN_ESTADO)
VALUES(3, 'Citibank N.A. Sucursal Ecuador', '1790033295001', 'Bancos privados', 'Citibank N.A. Sucursal Ecuador', 'Quito', '02374859', '2016-12-16 00:00:00.000', 2);
INSERT INTO bce_db.INSTITUCION_FINANCIERA
(INSFIN_IDENTIFICACION, INSFIN_NOMBRE, INSFIN_CODIGO, INSFIN_TIPO, INSFIN_RAZONSOCIAL, INSFIN_DIRECCION, INSFIN_TELEFONO, INSFIN_FECHAREGISTRO, INSFIN_ESTADO)
VALUES(4, 'Banco Comercial de Manabí S.A. ', '1390067506001', 'Bancos privados', 'Banco Comercial de Manabí S.A. ', 'Quito', '02374859', '2016-12-16 00:00:00.000', 4);
INSERT INTO bce_db.INSTITUCION_FINANCIERA
(INSFIN_IDENTIFICACION, INSFIN_NOMBRE, INSFIN_CODIGO, INSFIN_TIPO, INSFIN_RAZONSOCIAL, INSFIN_DIRECCION, INSFIN_TELEFONO, INSFIN_FECHAREGISTRO, INSFIN_ESTADO)
VALUES(5, 'Banco D-Miro S.A. ', '0992701374001 ', 'Bancos privados', 'Banco D-Miro S.A. ', 'Guayaquil', '02374859', '2016-12-16 00:00:00.000', 4);
INSERT INTO bce_db.INSTITUCION_FINANCIERA
(INSFIN_IDENTIFICACION, INSFIN_NOMBRE, INSFIN_CODIGO, INSFIN_TIPO, INSFIN_RAZONSOCIAL, INSFIN_DIRECCION, INSFIN_TELEFONO, INSFIN_FECHAREGISTRO, INSFIN_ESTADO)
VALUES(6, 'Banco del Austro S.A. ', '0992701374001 ', 'Bancos privados', 'Banco del Austro S.A. ', 'Cuenca', '02374859', '2016-12-16 00:00:00.000', 2);
INSERT INTO bce_db.INSTITUCION_FINANCIERA
(INSFIN_IDENTIFICACION, INSFIN_NOMBRE, INSFIN_CODIGO, INSFIN_TIPO, INSFIN_RAZONSOCIAL, INSFIN_DIRECCION, INSFIN_TELEFONO, INSFIN_FECHAREGISTRO, INSFIN_ESTADO)
VALUES(7, 'Banco BanEcuador S.A.', '0160016780001', 'Bancos públicos', 'Banco BanEcuador S.A.', 'Quito', '02374859', '2016-12-16 00:00:00.000', 2);


/**/

INSERT INTO bce_db.TIPO_CUENTA
(CTA_ID, CTA_TIPO)
VALUES(1, 'CC');
INSERT INTO bce_db.TIPO_CUENTA
(CTA_ID, CTA_TIPO)
VALUES(2, 'CA');


/**/

INSERT INTO bce_db.TIPO_TRANSACCION
(TRA_ID, TRA_TIPO)
VALUES(1, 'APERTURA');
INSERT INTO bce_db.TIPO_TRANSACCION
(TRA_ID, TRA_TIPO)
VALUES(2, 'DEPOSITAR');
INSERT INTO bce_db.TIPO_TRANSACCION
(TRA_ID, TRA_TIPO)
VALUES(3, 'RETIRAR');


/**/

INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497100', 'María ', 'Santiago', '0987209133', 'joacocordero@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497101', 'Carmen', 'Benítez', '0987209133', 'pepacordero@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497102', 'Josefa', 'Mora', '0987209133', 'valehh@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497103', 'Ana', 'Vicente', '0987209133', 'annabeck_@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497104', 'María', 'Vargas', '0987209133', 'japacortes@yahoo.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497105', 'Isabel', 'Arias', '0987209133', 'juanocortes@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497106', 'María', 'Carmona', '0987209133', 'pili_diami_angol@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497107', 'Pilar', 'Crespo', '0987209133', 'tallerlaquilla@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497320', 'María Carmen', 'García', '0987209133', 'iabarcae@yahoo.es', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', 'MORA');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497321', 'María ', 'González', '0987209133', 'maeillanes@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497322', 'Carmen ', 'Rodríguez', '0987209133', 'osabarca@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497323', 'Josefa ', 'Fernández', '0987209133', 'cabrigo@garmendia.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497324', 'LUIS', 'USHIÑA', '0987209133', 'LFUSHINA@ESPE.EDU.EC', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497325', 'Isabel ', 'Martínez', '0987209133', 'afull@live.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497326', 'María Pilar ', 'Sánchez', '0987209133', 'carlosaguileram@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497327', 'María Dolores ', 'Pérez', '0987209133', 'ikis_rojo@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497328', 'Laura ', 'Gómez', '0987209133', 'daniela_aguilera_m500@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497329', 'María Teresa ', 'Martin', '0987209133', 'vizkala@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497330', 'Antonio ', 'Jiménez', '0987209133', 'alexus3@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497331', 'José ', 'Ruiz', '0987209133', 'capitanaguilera@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497332', 'Manuel ', 'Hernández', '0987209133', 'apalamosg@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497333', 'Francisco ', 'Diaz', '0987209133', 'niikhox__@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497334', 'David ', 'Moreno', '0987209133', 'luuuuuuci@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497335', 'Juan ', 'Muñoz', '0987209133', 'kristian_siempre_azul@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497336', 'José Antonio ', 'Álvarez', '0987209133', 'mapuchin@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497337', 'Javier ', 'Romero', '0987209133', 'arahuetes@manquehue.net', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497338', 'José Luis ', 'Alonso', '0987209133', 'arancibia@grange.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497339', 'Daniel ', 'Gutiérrez', '0987209133', 'martacam2002@yahoo.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497340', 'Lucía ', 'Navarro', '0987209133', 'geoplanet@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497341', 'Martina ', 'Torres', '0987209133', 'faraya1910@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497342', 'María ', 'Domínguez', '0987209133', 'faraya@sprint.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497343', 'Sofía ', 'Vázquez', '0987209133', 'araya@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497344', 'Paula ', 'Ramos', '0987209133', 'paulifran@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497345', 'Daniela ', 'Gil', '0987209133', 'girl.-@hotmail.es', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497346', 'Valeria ', 'Ramírez', '0987209133', 'aargomedo@hecsa.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497347', 'Alba ', 'Serrano', '0987209133', 'aargomedo@hecsa.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497348', 'Julia ', 'Blanco', '0987209133', 'elizabetharmstrong39@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497349', 'Noa ', 'Molina', '0987209133', 'c_arnes@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497350', 'Hugo ', 'Morales', '0987209133', 'aarriagada@petrok.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497351', 'Daniel ', 'Suarez', '0987209133', 'joy_pao_@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497352', 'Martín ', 'Ortega', '0987209133', 'pef@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497353', 'Pablo ', 'Delgado', '0987209133', 'arquitectoasenjo@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497354', 'Alejandro ', 'Castro', '0987209133', 'masenjog@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497355', 'Lucas ', 'Ortiz', '0987209133', 'Aspe@adretail.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497356', 'Álvaro ', 'Rubio', '0987209133', 'caspe@canal13.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497357', 'Adrián ', 'Marín', '0987209133', 'bantomaui@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497358', 'Mateo ', 'Sanz', '0987209133', 'mfbanto@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497359', 'David ', 'Núñez', '0987209133', 'banto@Uvavins.ch', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497360', 'María Carmen', 'Iglesias', '0987209133', 'jbarrera05@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497361', 'María ', 'Medina', '0987209133', 'claudiabergez@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497362', 'Carmen ', 'Garrido', '0987209133', 'michelebk@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497363', 'Josefa ', 'Cortes', '0987209133', 'angelicabergez@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497364', 'Ana María ', 'Castillo', '0987209133', 'solbk26@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497365', 'Isabel ', 'Santos', '0987209133', 'cibravohuerta@yahoo.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497366', 'María Pilar ', 'Lozano', '0987209133', 'sebastianatila@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497367', 'María Dolores ', 'Guerrero', '0987209133', 'jabravot@yahoo.es', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497368', 'Laura ', 'Cano', '0987209133', 'pbg@endesa.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497369', 'María Teresa ', 'Prieto', '0987209133', 'brito@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497370', 'Antonio ', 'Méndez', '0987209133', 'anibalito___@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497371', 'José ', 'Cruz', '0987209133', 'rcabbada@vtr.net', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497372', 'Manuel ', 'Calvo', '0987209133', 'superjp_coco@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497373', 'Francisco ', 'Gallego', '0987209133', 'cabbada@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497374', 'David ', 'Vidal', '0987209133', 'nina_cabbada@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497375', 'Juan ', 'León', '0987209133', 'yaz_antu@yahoo.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497376', 'José Antonio ', 'Márquez', '0987209133', 'consuelo_caceres@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497377', 'Javier ', 'Herrera', '0987209133', 'dantekol@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497378', 'José Luis ', 'Peña', '0987209133', 'lukalcagno@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497379', 'Daniel ', 'Flores', '0987209133', 'ruliandro@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497380', 'Lucía ', 'Cabrera', '0987209133', 'icalderon@tecval.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497381', 'Martina ', 'Campos', '0987209133', 'cadiz@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497382', 'María ', 'Vega', '0987209133', 'allicamposv@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497383', 'Sofía ', 'Fuentes', '0987209133', 'onfray@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497384', 'Paula ', 'Carrasco', '0987209133', 'campos@impromac.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497385', 'Daniela ', 'Diez', '0987209133', 'raulcd02ster@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497386', 'Valeria ', 'Caballero', '0987209133', 'carmona@gendarmeria.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497387', 'Alba ', 'Reyes', '0987209133', 'tantitamivida@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497388', 'Julia ', 'Nieto', '0987209133', 'casajuan@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497389', 'Noa ', 'Aguilar', '0987209133', 'jaimecasajuana@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497390', 'Hugo ', 'Pascual', '0987209133', 'javi_javis_3@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497391', 'Daniel ', 'Santana', '0987209133', 'casajuana_@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497392', 'Martín ', 'Herrero', '0987209133', 'hugocastanedav@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497393', 'Pablo ', 'Lorenzo', '0987209133', 'acastanon@vectorchile.cl', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497394', 'Alejandro ', 'Montero', '0987209133', 'claudiocastanonmigeot@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497395', 'Lucas ', 'Hidalgo', '0987209133', 'analuz@yahoo.es', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497396', 'Álvaro ', 'Giménez', '0987209133', 'claudiocastanonmigeot@gmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497397', 'Adrián ', 'Ibáñez', '0987209133', 'tango_negro@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497398', 'Mateo ', 'Ferrer', '0987209133', 'pato_one@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
INSERT INTO bce_db.USUARIO
(USR_IDENTIFICACION, USR_NOMBRE, USR_APELLIDO, USR_TELEFONO, USR_EMAIL, USR_LUGARNACIMIENTO, USR_FECHANACIMIENTO, USR_NACIONALIDAD, USR_GENERO, USR_ESTADOCIVIL, USR_ESTADO)
VALUES('1716497399', 'David ', 'Duran', '0987209133', 'javier_celedon@hotmail.com', 'PICHINCHA, RUMIÑAHUI, SANGOLQUI', '1987-06-13', 'ECUATORIANO', 'H', 'SOL', '1');
