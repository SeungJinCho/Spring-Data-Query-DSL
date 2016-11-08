USE test;

DROP TABLE IF EXISTS HOTELS;

CREATE TABLE HOTELS (
  id      BIGINT(11)       NOT NULL AUTO_INCREMENT
  COMMENT 'id',
  name    VARCHAR(255)
          COLLATE utf8_bin NOT NULL,
  address VARCHAR(255)
          COLLATE utf8_bin NOT NULL,
  rating  BIGINT(11)       NULL,
  PRIMARY KEY (id)
);
INSERT INTO HOTELS (name, address, rating) VALUES
  ("Marriott 1", "Futakotamagawa", 100),
  ("Hilton", "Sinagawa", 50);
