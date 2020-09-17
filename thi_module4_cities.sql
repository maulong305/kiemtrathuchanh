create table cities
(
    id          bigint auto_increment
        primary key,
    area        bigint       null,
    description varchar(255) null,
    gdp         bigint       null,
    name        varchar(255) null,
    population  bigint       null,
    country_id  bigint       null
)
    engine = MyISAM;

create index FK6gatmv9dwedve82icy8wrkdmk
    on cities (country_id);

INSERT INTO thi_module4.cities (id, area, description, gdp, name, population, country_id) VALUES (1, 3359, 'Thanh pho vi hoa binh', 3000, 'Ha Noi', 9000000, 1);
INSERT INTO thi_module4.cities (id, area, description, gdp, name, population, country_id) VALUES (2, 1290, 'Thanh pho dang song', 3000, 'Da Nang', 1200000, 1);