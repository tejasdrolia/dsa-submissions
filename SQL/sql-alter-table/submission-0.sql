CREATE TABLE books (
  id INTEGER,
  title TEXT,
  author TEXT
);
-- Do not modify above this line --




alter table books add column published_year Integer;


AlTER TABLE books RENAME COLUMn id TO isbn;

ALTER TABLE books DROP COLUMN author;


-- Do not modify below this line --
SELECT column_name, data_type, column_default
FROM information_schema.columns
WHERE table_name = 'books'
ORDER BY column_name;
