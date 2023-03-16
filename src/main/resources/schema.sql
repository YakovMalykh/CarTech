CREATE TABLE IF NOT EXISTS users_info (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    uuid UUID UNIQUE NOT NULL ,
    money BIGINT,
    country VARCHAR(50),
    registry DATE
);

CREATE TABLE IF NOT EXISTS activity (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    uuid UUID,
    activity BIGINT,
    update_date DATE
);

