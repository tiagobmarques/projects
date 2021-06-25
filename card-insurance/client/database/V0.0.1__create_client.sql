
------------------------------------------------------------------
-- Create client table
------------------------------------------------------------------
DO
$$
  BEGIN
    IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'client') THEN
      create table client (
        client_id UUID DEFAULT gen_random_uuid(),
        name  VARCHAR(200) NOT NULL,
        email VARCHAR(200) NOT NULL,
        address VARCHAR(200) NOT NULL,
        neighborhood VARCHAR(200) NOT NULL,
        city VARCHAR(200) NOT NULL,
        state VARCHAR(200) NOT NULL,
        country VARCHAR(200) NOT NULL,
        registry_date DATE NOT NULL,
        bank_branch VARCHAR(20) NOT NULL,
        bank_account VARCHAR(20) NOT NULL,
        PRIMARY KEY (client_id)
      );
      RAISE INFO 'Added client table';
    ELSE
      RAISE INFO 'client table already added';
    END IF;
  END
$$;