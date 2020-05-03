CREATE TABLE "public"."dictionary_cut_services"
(
    "id"           bigint       NOT NULL,
    "title"        varchar(64)  NOT NULL,
    "description"  varchar(256) NULL,
    "duration_min" integer      NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."dictionary_gender"
(
    "id"     bigint      NOT NULL,
    "gender" varchar(64) NOT NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_content"
(
    "id"            bigint                   NOT NULL,
    "content"       varchar(100000)          NOT NULL,
    "extension"     varchar(16)              NULL,
    "created_date"  timestamp with time zone NOT NULL,
    "deleted_date"  timestamp with time zone NULL,
    "modified_date" timestamp with time zone NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."dictionary_specialization"
(
    "id"          bigint       NOT NULL,
    "title"       varchar(64)  NOT NULL,
    "description" varchar(512) NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."dictionary_email_template"
(
    "id"       bigint         NOT NULL,
    "title"    varchar(64)    NULL,
    "template" varchar(10000) NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_address"
(
    "id"          bigint       NOT NULL,
    "coordinates" varchar(64)  NULL,
    "country"     varchar(128) NOT NULL,
    "region"      varchar(128) NULL,
    "city"        varchar(128) NULL,
    "street"      varchar(256) NULL,
    "house"       varchar(32)  NULL,
    "apartment"   varchar(32)  NULL,
    PRIMARY KEY ("id")
);



CREATE TABLE "public"."db_cutter"
(
    "id"            bigint                   NOT NULL,
    "email"         varchar(255)             NULL,
    "phone"         varchar(64)              NOT NULL,
    "first_name"    varchar(64)              NULL,
    "last_name"     varchar(64)              NOT NULL,
    "id_address"    bigint                   NULL,
    "password"      varchar(64)              NOT NULL,
    "salt"          varchar(64)              NOT NULL,
    "created_date"  timestamp with time zone NULL,
    "deleted_date"  timestamp with time zone NULL,
    "modified_date" timestamp with time zone NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_cutter_session"
(
    "id"            bigint                   NOT NULL,
    "id_cutter"     bigint                   NOT NULL,
    "created_date"  timestamp with time zone NULL,
    "deleted_date"  timestamp with time zone NULL,
    "modified_date" timestamp with time zone NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_cutter_services"
(
    "id"          bigint NOT NULL,
    "id_cutter"   bigint NOT NULL,
    "id_services" bigint NOT NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_customer"
(
    "id"            bigint                   NOT NULL,
    "email"         varchar(255)             NULL,
    "phone"         varchar(64)              NOT NULL,
    "first_name"    varchar(64)              NOT NULL,
    "last_name"     varchar(64)              NOT NULL,
    "id_address"    bigint                   NULL,
    "password"      varchar(64)              NOT NULL,
    "salt"          varchar(64)              NOT NULL,
    "created_date"  timestamp with time zone NULL,
    "deleted_date"  timestamp with time zone NULL,
    "modified_date" timestamp with time zone NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_comment"
(
    "id"            bigint                   NOT NULL,
    "id_customer"   bigint                   NOT NULL,
    "id_cutter"     bigint                   NOT NULL,
    "is_anonym"     boolean                  NOT NULL,
    "grade"         integer                  NOT NULL,
    "text"          varchar(256)             NULL,
    "created_date"  timestamp with time zone NOT NULL,
    "deleted_date"  timestamp with time zone NULL,
    "modified_date" timestamp with time zone NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_chat"
(
    "id"            bigint                   NOT NULL,
    "id_customer"   bigint                   NOT NULL,
    "id_cutter"     bigint                   NOT NULL,
    "created_date"  timestamp with time zone NOT NULL,
    "deleted_date"  timestamp with time zone NULL,
    "modified_date" timestamp with time zone NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_customer_session"
(
    "id"            bigint                   NOT NULL,
    "id_customer"   bigint                   NOT NULL,
    "created_date"  timestamp with time zone NULL,
    "deleted_date"  timestamp with time zone NULL,
    "modified_date" timestamp with time zone NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_appointment"
(
    "id"            bigint                   NOT NULL,
    "id_customer"   bigint                   NOT NULL,
    "id_cutter"     bigint                   NOT NULL,
    "id_address"    bigint                   NULL,
    "comment"       varchar(256)             NULL,
    "date"          timestamp with time zone NULL,
    "price"         integer                  NULL,
    "duration_min"  integer                  NULL,
    "created_date"  timestamp with time zone NULL,
    "deleted_date"  timestamp with time zone NULL,
    "modified_date" timestamp with time zone NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_message"
(
    "id"             bigint                   NOT NULL,
    "id_chat"        bigint                   NOT NULL,
    "id_customer"    bigint                   NULL,
    "id_cutter"      bigint                   NULL,
    "text"           varchar(1024)            NULL,
    "has_attachment" boolean                  NULL,
    "created_date"   timestamp with time zone NOT NULL,
    "deleted_date"   timestamp with time zone NULL,
    "modified_date"  timestamp with time zone NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_appointment_services"
(
    "id"             bigint NOT NULL,
    "id_appointment" bigint NOT NULL,
    "id_services"    bigint NOT NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_favorites"
(
    "id"          bigint NOT NULL,
    "id_customer" bigint NOT NULL,
    "id_cutter"   bigint NOT NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "public"."db_attachment"
(
    "id"            bigint                   NOT NULL,
    "id_message"    bigint                   NOT NULL,
    "content"       varchar(100000)          NOT NULL,
    "extension"     varchar(16)              NULL,
    "created_date"  timestamp with time zone NOT NULL,
    "deleted_date"  timestamp with time zone NULL,
    "modified_date" timestamp with time zone NULL,
    PRIMARY KEY ("id")
);

ALTER TABLE "public"."db_cutter"
    ADD FOREIGN KEY ("id_address") REFERENCES "public"."db_address" ("id");

ALTER TABLE "public"."db_cutter_session"
    ADD FOREIGN KEY ("id_cutter") REFERENCES "public"."db_cutter" ("id");

ALTER TABLE "public"."db_cutter_services"
    ADD FOREIGN KEY ("id_cutter") REFERENCES "public"."db_cutter" ("id");

ALTER TABLE "public"."db_cutter_services"
    ADD FOREIGN KEY ("id_services") REFERENCES "public"."dictionary_cut_services" ("id");

ALTER TABLE "public"."db_customer"
    ADD FOREIGN KEY ("id_address") REFERENCES "public"."db_address" ("id");

ALTER TABLE "public"."db_comment"
    ADD FOREIGN KEY ("id_customer") REFERENCES "public"."db_customer" ("id");

ALTER TABLE "public"."db_comment"
    ADD FOREIGN KEY ("id_cutter") REFERENCES "public"."db_cutter" ("id");

ALTER TABLE "public"."db_chat"
    ADD FOREIGN KEY ("id_customer") REFERENCES "public"."db_customer" ("id");

ALTER TABLE "public"."db_chat"
    ADD FOREIGN KEY ("id_cutter") REFERENCES "public"."db_cutter" ("id");

ALTER TABLE "public"."db_customer_session"
    ADD FOREIGN KEY ("id_customer") REFERENCES "public"."db_customer" ("id");

ALTER TABLE "public"."db_appointment"
    ADD FOREIGN KEY ("id_address") REFERENCES "public"."db_address" ("id");

ALTER TABLE "public"."db_appointment"
    ADD FOREIGN KEY ("id_customer") REFERENCES "public"."db_customer" ("id");

ALTER TABLE "public"."db_appointment"
    ADD FOREIGN KEY ("id_cutter") REFERENCES "public"."db_cutter" ("id");

ALTER TABLE "public"."db_message"
    ADD FOREIGN KEY ("id_chat") REFERENCES "public"."db_chat" ("id");

ALTER TABLE "public"."db_message"
    ADD FOREIGN KEY ("id_customer") REFERENCES "public"."db_customer" ("id");

ALTER TABLE "public"."db_message"
    ADD FOREIGN KEY ("id_cutter") REFERENCES "public"."db_cutter" ("id");

ALTER TABLE "public"."db_appointment_services"
    ADD FOREIGN KEY ("id_appointment") REFERENCES "public"."db_appointment" ("id");

ALTER TABLE "public"."db_appointment_services"
    ADD FOREIGN KEY ("id_services") REFERENCES "public"."dictionary_cut_services" ("id");

ALTER TABLE "public"."db_favorites"
    ADD FOREIGN KEY ("id_customer") REFERENCES "public"."db_customer" ("id");

ALTER TABLE "public"."db_favorites"
    ADD FOREIGN KEY ("id_cutter") REFERENCES "public"."db_cutter" ("id");

ALTER TABLE "public"."db_attachment"
    ADD FOREIGN KEY ("id_message") REFERENCES "public"."db_message" ("id");

CREATE SEQUENCE "public"."pk_db_address" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_appointment" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_appointment_services" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_attachment" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_chat" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_comment" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_content" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_customer" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_customer_session" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_cutter" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_cutter_services" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_cutter_session" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_favorites" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_db_message" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_dictionary_cut_services" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_dictionary_email_template" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_dictionary_gender" INCREMENT 1 START 1;

CREATE SEQUENCE "public"."pk_dictionary_specialization" INCREMENT 1 START 1;

