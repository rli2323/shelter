CREATE TABLE IF NOT EXISTS game
(
    id             uuid not null primary key,
    code           varchar(5),
    created_date   timestamp,
    end_date       timestamp,
    is_finished    boolean default false,
    is_active      boolean default true,
    players_number int
);


CREATE TABLE IF NOT EXISTS occupation
(
    id int not null primary key,
    name varchar(100)
);

CREATE TABLE IF NOT EXISTS health
(
    id int not null primary key,
    name varchar(100)
);

CREATE TABLE IF NOT EXISTS catastrophe
(
    id int not null primary key,
    name varchar not null,
    description text not null
);

CREATE TABLE IF NOT EXISTS facts
(
    id int not null primary key,
    name varchar not null
);

CREATE TABLE IF NOT EXISTS baggage
(
    id int not null primary key,
    name varchar not null
);

CREATE TABLE IF NOT EXISTS phobia
(
    id int not null primary key,
    name varchar not null
);

CREATE TABLE IF NOT EXISTS character (
    id UUID PRIMARY KEY,
    player_name VARCHAR(255),
    occupation_id int REFERENCES occupation(id),
    health_id int REFERENCES health(id),
    sex VARCHAR(10),
    age INTEGER,
    game_id UUID REFERENCES game(id),
    fact_id int REFERENCES facts(id),
    baggage_id int REFERENCES baggage(id),
    phobia_id int REFERENCES phobia(id)
);
