
------------------------------------------------------------------
-- Create card table
------------------------------------------------------------------
DO
$$
  BEGIN
    IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'card') THEN
      create table card (
        card_id UUID DEFAULT gen_random_uuid(),
        number VARCHAR(20) NOT NULL,
        name_on_card VARCHAR(200) NOT NULL,
        expiration_date DATE NOT NULL,
        security_code INTEGER,
        type VARCHAR(20) NOT NULL,
        client_id UUID NOT NULL,
        PRIMARY KEY (card_id),
        CONSTRAINT card_id_fk FOREIGN KEY (card_id)
        REFERENCES card (card_id)
      );

      RAISE INFO 'Added card table';
    ELSE
      RAISE INFO 'card table already added';
    END IF;
  END
$$;