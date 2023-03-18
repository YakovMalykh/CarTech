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


CREATE INDEX CONCURRENTLY IF NOT EXISTS idx_uuid_update_date
    ON activity (uuid, update_date);

CREATE INDEX IF NOT EXISTS idx_uuid ON users_info(uuid);

CREATE INDEX IF NOT EXISTS idx_money_country ON users_info(money,country);

CREATE INDEX IF NOT EXISTS idx_date_country ON users_info (registry, country);
