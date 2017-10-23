--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-10-23 09:52:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 185 (class 1259 OID 16815)
-- Name: auto_increment_employee; Type: SEQUENCE; Schema: public; Owner: edu
--

CREATE SEQUENCE auto_increment_employee
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auto_increment_employee OWNER TO edu;

--
-- TOC entry 186 (class 1259 OID 16817)
-- Name: auto_increment_ingredient; Type: SEQUENCE; Schema: public; Owner: edu
--

CREATE SEQUENCE auto_increment_ingredient
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auto_increment_ingredient OWNER TO edu;

--
-- TOC entry 187 (class 1259 OID 16819)
-- Name: auto_increment_ingredientcontent; Type: SEQUENCE; Schema: public; Owner: edu
--

CREATE SEQUENCE auto_increment_ingredientcontent
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auto_increment_ingredientcontent OWNER TO edu;

--
-- TOC entry 188 (class 1259 OID 16821)
-- Name: auto_increment_pastry; Type: SEQUENCE; Schema: public; Owner: edu
--

CREATE SEQUENCE auto_increment_pastry
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auto_increment_pastry OWNER TO edu;

--
-- TOC entry 189 (class 1259 OID 16823)
-- Name: auto_increment_pastrysale; Type: SEQUENCE; Schema: public; Owner: edu
--

CREATE SEQUENCE auto_increment_pastrysale
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auto_increment_pastrysale OWNER TO edu;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 190 (class 1259 OID 16825)
-- Name: employee; Type: TABLE; Schema: public; Owner: edu
--

CREATE TABLE employee (
    employeeid bigint DEFAULT nextval('auto_increment_employee'::regclass) NOT NULL,
    fullname character varying NOT NULL,
    salary real
);


ALTER TABLE employee OWNER TO edu;

--
-- TOC entry 191 (class 1259 OID 16832)
-- Name: ingredient; Type: TABLE; Schema: public; Owner: edu
--

CREATE TABLE ingredient (
    ingredientid bigint DEFAULT nextval('auto_increment_ingredient'::regclass) NOT NULL,
    ingredientname character varying NOT NULL,
    unitprice real NOT NULL
);


ALTER TABLE ingredient OWNER TO edu;

--
-- TOC entry 192 (class 1259 OID 16839)
-- Name: pastry; Type: TABLE; Schema: public; Owner: edu
--

CREATE TABLE pastry (
    pastryid bigint DEFAULT nextval('auto_increment_pastry'::regclass) NOT NULL,
    pastryname character varying NOT NULL,
    sellprice real NOT NULL
);


ALTER TABLE pastry OWNER TO edu;

--
-- TOC entry 193 (class 1259 OID 16846)
-- Name: pastryingredient; Type: TABLE; Schema: public; Owner: edu
--

CREATE TABLE pastryingredient (
    pastryid bigint NOT NULL,
    ingredientid bigint NOT NULL,
    amount real,
    contentid bigint DEFAULT nextval('auto_increment_ingredientcontent'::regclass) NOT NULL
);


ALTER TABLE pastryingredient OWNER TO edu;

--
-- TOC entry 194 (class 1259 OID 16850)
-- Name: pastrysale; Type: TABLE; Schema: public; Owner: edu
--

CREATE TABLE pastrysale (
    saleid bigint DEFAULT nextval('auto_increment_employee'::regclass) NOT NULL,
    amount integer,
    saledate date,
    pastryid bigint NOT NULL
);


ALTER TABLE pastrysale OWNER TO edu;

--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 185
-- Name: auto_increment_employee; Type: SEQUENCE SET; Schema: public; Owner: edu
--

SELECT pg_catalog.setval('auto_increment_employee', 10, true);


--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 186
-- Name: auto_increment_ingredient; Type: SEQUENCE SET; Schema: public; Owner: edu
--

SELECT pg_catalog.setval('auto_increment_ingredient', 4, true);


--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 187
-- Name: auto_increment_ingredientcontent; Type: SEQUENCE SET; Schema: public; Owner: edu
--

SELECT pg_catalog.setval('auto_increment_ingredientcontent', 9, true);


--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 188
-- Name: auto_increment_pastry; Type: SEQUENCE SET; Schema: public; Owner: edu
--

SELECT pg_catalog.setval('auto_increment_pastry', 3, true);


--
-- TOC entry 2185 (class 0 OID 0)
-- Dependencies: 189
-- Name: auto_increment_pastrysale; Type: SEQUENCE SET; Schema: public; Owner: edu
--

SELECT pg_catalog.setval('auto_increment_pastrysale', 1, false);


--
-- TOC entry 2170 (class 0 OID 16825)
-- Dependencies: 190
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: edu
--

COPY employee (employeeid, fullname, salary) FROM stdin;
1	Leif	20000
\.


--
-- TOC entry 2171 (class 0 OID 16832)
-- Dependencies: 191
-- Data for Name: ingredient; Type: TABLE DATA; Schema: public; Owner: edu
--

COPY ingredient (ingredientid, ingredientname, unitprice) FROM stdin;
1	Vetemjöl	5
2	Ägg	0.5
4	Socker	2
3	Mjölk	5
\.


--
-- TOC entry 2172 (class 0 OID 16839)
-- Dependencies: 192
-- Data for Name: pastry; Type: TABLE DATA; Schema: public; Owner: edu
--

COPY pastry (pastryid, pastryname, sellprice) FROM stdin;
1	Kanelbulle	20
2	Sockerkaka	10
3	Punschrulle	15
\.


--
-- TOC entry 2173 (class 0 OID 16846)
-- Dependencies: 193
-- Data for Name: pastryingredient; Type: TABLE DATA; Schema: public; Owner: edu
--

COPY pastryingredient (pastryid, ingredientid, amount, contentid) FROM stdin;
1	1	0.20	1
1	2	0.15	2
1	3	0.10	3
1	4	0.10	4
2	1	0.15	5
2	2	0.15	6
2	4	0.20	7
3	1	0.10	8
3	4	0.15	9
\.


--
-- TOC entry 2174 (class 0 OID 16850)
-- Dependencies: 194
-- Data for Name: pastrysale; Type: TABLE DATA; Schema: public; Owner: edu
--

COPY pastrysale (saleid, amount, saledate, pastryid) FROM stdin;
7	100	\N	1
8	75	\N	3
9	500	\N	2
10	50	\N	1
\.


--
-- TOC entry 2034 (class 2606 OID 16855)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: edu
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employeeid);


--
-- TOC entry 2036 (class 2606 OID 16857)
-- Name: ingredient ingredient_pkey; Type: CONSTRAINT; Schema: public; Owner: edu
--

ALTER TABLE ONLY ingredient
    ADD CONSTRAINT ingredient_pkey PRIMARY KEY (ingredientid);


--
-- TOC entry 2041 (class 2606 OID 16859)
-- Name: pastryingredient ingredientcontent_pkey; Type: CONSTRAINT; Schema: public; Owner: edu
--

ALTER TABLE ONLY pastryingredient
    ADD CONSTRAINT ingredientcontent_pkey PRIMARY KEY (contentid);


--
-- TOC entry 2038 (class 2606 OID 16861)
-- Name: pastry pastry_pkey; Type: CONSTRAINT; Schema: public; Owner: edu
--

ALTER TABLE ONLY pastry
    ADD CONSTRAINT pastry_pkey PRIMARY KEY (pastryid);


--
-- TOC entry 2044 (class 2606 OID 16863)
-- Name: pastrysale pastrysale_pkey; Type: CONSTRAINT; Schema: public; Owner: edu
--

ALTER TABLE ONLY pastrysale
    ADD CONSTRAINT pastrysale_pkey PRIMARY KEY (saleid);


--
-- TOC entry 2039 (class 1259 OID 16864)
-- Name: fki_ingredientid; Type: INDEX; Schema: public; Owner: edu
--

CREATE INDEX fki_ingredientid ON pastryingredient USING btree (ingredientid);


--
-- TOC entry 2042 (class 1259 OID 16865)
-- Name: fki_pastryid; Type: INDEX; Schema: public; Owner: edu
--

CREATE INDEX fki_pastryid ON pastrysale USING btree (pastryid);


--
-- TOC entry 2045 (class 2606 OID 16866)
-- Name: pastryingredient ingredientid; Type: FK CONSTRAINT; Schema: public; Owner: edu
--

ALTER TABLE ONLY pastryingredient
    ADD CONSTRAINT ingredientid FOREIGN KEY (ingredientid) REFERENCES ingredient(ingredientid);


--
-- TOC entry 2046 (class 2606 OID 16871)
-- Name: pastryingredient pastryid; Type: FK CONSTRAINT; Schema: public; Owner: edu
--

ALTER TABLE ONLY pastryingredient
    ADD CONSTRAINT pastryid FOREIGN KEY (pastryid) REFERENCES pastry(pastryid);


--
-- TOC entry 2047 (class 2606 OID 16876)
-- Name: pastrysale pastryid; Type: FK CONSTRAINT; Schema: public; Owner: edu
--

ALTER TABLE ONLY pastrysale
    ADD CONSTRAINT pastryid FOREIGN KEY (pastryid) REFERENCES pastry(pastryid);


-- Completed on 2017-10-23 09:52:33

--
-- PostgreSQL database dump complete
--

