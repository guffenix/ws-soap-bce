/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     11/12/2018 12:51:02                          */
/*==============================================================*/


drop table if exists ASIGNAR_IFIN_USR;

drop table if exists ASIGNAR_TRANSACCION;

drop table if exists INSTITUCION_FINANCIERA;

drop table if exists TIPO_CUENTA;

drop table if exists TIPO_TRANSACCION;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: ASIGNAR_IFIN_USR                                      */
/*==============================================================*/
create table ASIGNAR_IFIN_USR
(
   IFINUSR_ID           int not null AUTO_INCREMENT,
   CTA_ID               int,
   INSFIN_IDENTIFICACION int,
   USR_IDENTIFICACION   varchar(10),
   IFINUSR_NUMEROCUENTA varchar(32),
   IFINUSR_MONTO        decimal(10,4),
   IFINUSR_ESTADO       int,
   primary key (IFINUSR_ID)
);

/*==============================================================*/
/* Table: ASIGNAR_TRANSACCION                                   */
/*==============================================================*/
create table ASIGNAR_TRANSACCION
(
   ASITRA_ID            int not null AUTO_INCREMENT,
   USR_IDENTIFICACION   varchar(10),
   TRA_ID               int,
   IFINUSR_ID           int,
   ASITRA_IDENTIFICADOR varchar(128),
   ASITRA_FECHAUSO      datetime,
   ASITRA_MONTO         decimal(10,4),
   ASITRA_ESTADO        int,
   primary key (ASITRA_ID)
);

/*==============================================================*/
/* Table: INSTITUCION_FINANCIERA                                */
/*==============================================================*/
create table INSTITUCION_FINANCIERA
(
   INSFIN_IDENTIFICACION int not null AUTO_INCREMENT,
   INSFIN_NOMBRE        varchar(64),
   INSFIN_CODIGO        varchar(15),
   INSFIN_TIPO          varchar(32),
   INSFIN_RAZONSOCIAL   varchar(256),
   INSFIN_DIRECCION     varchar(256),
   INSFIN_TELEFONO      varchar(15),
   INSFIN_FECHAREGISTRO datetime,
   INSFIN_ESTADO        int,
   primary key (INSFIN_IDENTIFICACION)
);

/*==============================================================*/
/* Table: TIPO_CUENTA                                           */
/*==============================================================*/
create table TIPO_CUENTA
(
   CTA_ID               int not null AUTO_INCREMENT,
   CTA_TIPO             varchar(8),
   primary key (CTA_ID)
);

/*==============================================================*/
/* Table: TIPO_TRANSACCION                                      */
/*==============================================================*/
create table TIPO_TRANSACCION
(
   TRA_ID               int not null AUTO_INCREMENT,
   TRA_TIPO             varchar(32),
   primary key (TRA_ID)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   USR_IDENTIFICACION   varchar(10) not null,
   USR_NOMBRE           varchar(64),
   USR_APELLIDO         varchar(64),
   USR_TELEFONO         varchar(15),
   USR_EMAIL            varchar(128),
   USR_LUGARNACIMIENTO  varchar(256),
   USR_FECHANACIMIENTO  date,
   USR_NACIONALIDAD     varchar(64),
   USR_GENERO           varchar(8),
   USR_ESTADOCIVIL      varchar(16),
   USR_ESTADO           varchar(64),
   primary key (USR_IDENTIFICACION)
);

alter table ASIGNAR_IFIN_USR add constraint FK_ASIGNAR_IU_TIPOCUENTA foreign key (CTA_ID)
      references TIPO_CUENTA (CTA_ID) on delete restrict on update restrict;

alter table ASIGNAR_IFIN_USR add constraint FK_ASIGNAR_IU_IF foreign key (INSFIN_IDENTIFICACION)
      references INSTITUCION_FINANCIERA (INSFIN_IDENTIFICACION) on delete restrict on update restrict;

alter table ASIGNAR_IFIN_USR add constraint FK_ASIGNAR_IU_USR foreign key (USR_IDENTIFICACION)
      references USUARIO (USR_IDENTIFICACION) on delete restrict on update restrict;

alter table ASIGNAR_TRANSACCION add constraint FK_ASGINAR_TRA_USR foreign key (USR_IDENTIFICACION)
      references USUARIO (USR_IDENTIFICACION) on delete restrict on update restrict;

alter table ASIGNAR_TRANSACCION add constraint FK_ASGINAR_TRA_TIPOTRA foreign key (TRA_ID)
      references TIPO_TRANSACCION (TRA_ID) on delete restrict on update restrict;

alter table ASIGNAR_TRANSACCION add constraint FK_ASGINAR_TRA_CTA foreign key (IFINUSR_ID)
      references ASIGNAR_IFIN_USR (IFINUSR_ID) on delete restrict on update restrict;
