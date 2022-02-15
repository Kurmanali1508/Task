CREATE TABLE products
(
    id                BIGSERIAL PRIMARY KEY NOT NULL,
    name              VARCHAR(255)          NOT NULL,
    description       VARCHAR(255),
    price             DECIMAL               NOT NULL,
    creation_date     TIMESTAMPTZ,
    modification_date TIMESTAMPTZ,
    language_id       BIGINT REFERENCES languages (id),
    currency_id       BIGINT REFERENCES currencies (id)
);