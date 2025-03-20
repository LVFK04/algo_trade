\set QUIET true
SET client_min_messages TO WARNING; -- Less talk please.
-- This script deletes everything in your database
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO CURRENT_USER;
-- This line makes psql stop on the first error it encounters
-- You may want to remove this when running tests that are intended to fail
\set ON_ERROR_STOP OFF
SET client_min_messages TO NOTICE; -- More talk



CREATE TABLE Users(
    name TEXT PRIMARY KEY,
    password TEXT NOT NULL,
    revenue FLOAT DEFAULT 0.0,
    money INT DEFAULT 0
);

CREATE TABLE Watchlist(
    "user" TEXT REFERENCES Users,
    company TEXT,
    company_avanza_url TEXT NOT NULL,
    company_history_url TEXT NOT NULL,
    PRIMARY KEY ("user", company)
);

CREATE TABLE CompanyHistory (
    company_name TEXT,
    
);


INSERT INTO Users (name, password) VALUES ('Viktor F. Kristiansson', 'Green Pass');
SELECT * FROM Users;




-- Command to run setup.sql:
-- &"C:\Program Files\PostgreSQL\17\bin\psql.exe" -U postgres -d postgres -f "D:\Programmering_Egen\Projects\algo_trade\src\db_setup\setup.sql"