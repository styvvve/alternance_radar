ALTER TABLE application
DROP CONSTRAINT ck_application_status;

ALTER TABLE application
    ADD CONSTRAINT ck_application_status CHECK (status IN ('APPLIED', 'INTERVIEW', 'ACCEPTED', 'REJECTED', 'WITHDRAWN'));