CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.person (
	id text NOT NULL DEFAULT uuid_generate_v4(),
	first_name text NULL,
	last_name text NULL,
	birth_date date NULL,
	gender bpchar(1) NULL,
	income numeric NULL,
	CONSTRAINT person_pk PRIMARY KEY (id)
);

CREATE TABLE public.person_attendance (
	id text NOT NULL DEFAULT uuid_generate_v4(),
	person_id text NOT NULL,
	scheduled_att numeric NOT NULL,
	real_att numeric NOT NULL,
	"month" int4 NOT NULL,
	"year" int4 NOT NULL,
	CONSTRAINT person_attendance_pk PRIMARY KEY (id),
	CONSTRAINT person_attendance_fk FOREIGN KEY (person_id) REFERENCES public.person(id)
);

CREATE TABLE public.person_attendance_detail (
	id text NOT NULL DEFAULT uuid_generate_v4(),
	person_id text NOT NULL,
	attendance_date date NOT NULL,
	CONSTRAINT person_attendance_detail_pk PRIMARY KEY (id),
	CONSTRAINT person_attendance_detail_fk FOREIGN KEY (person_id) REFERENCES public.person(id)
);
