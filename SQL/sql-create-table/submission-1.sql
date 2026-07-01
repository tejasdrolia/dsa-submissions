


CREATE TABLE videos
(
    id Integer,
    name Text,
    created_at Date,
    published Boolean
);




-- Do not modify below this line --
SELECT table_name, column_name, data_type
FROM information_schema.columns
WHERE table_name = 'videos';
