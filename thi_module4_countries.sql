create table countries
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

INSERT INTO thi_module4.countries (id, name) VALUES (1, 'Viet Nam');
INSERT INTO thi_module4.countries (id, name) VALUES (2, 'England');
INSERT INTO thi_module4.countries (id, name) VALUES (3, 'France');