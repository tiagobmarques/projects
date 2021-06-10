CREATE EXTENSION IF NOT EXISTS "pgcrypto";

------------------------------------------------------------------
-- Create invoice table
------------------------------------------------------------------
DO
$$
  BEGIN
    IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'invoice') THEN
      create table invoice (
        invoice_id UUID DEFAULT gen_random_uuid(),
        client varchar(100) not null,
        installment_date date not null,
        document varchar(14) not null,
        value numeric(13,2) not null,
        PRIMARY KEY (invoice_id)
      );

      RAISE INFO 'Added invoice table';
    ELSE
      RAISE INFO 'invoice table already added';
    END IF;
  END
$$;