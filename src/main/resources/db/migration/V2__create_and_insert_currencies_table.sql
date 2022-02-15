CREATE TABLE currencies
(
    id       BIGSERIAL PRIMARY KEY NOT NULL,
    currency VARCHAR(77)
);

INSERT INTO currencies (currency)
VALUES ('руб'),
       ('$'),
       ('€'),
       ('ر.ق'),
       ('£'),
       ('AMD'),
       ('¥'),
       ('₱'),
       ('сом'),
       ('YTL'),
       ('руб'),
       ('F'),
       ('₣');