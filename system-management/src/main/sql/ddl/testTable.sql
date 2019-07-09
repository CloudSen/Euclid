-- \c euclid_system_management

CREATE TABLE public.test_jpa
(
    id          character(36) NOT NULL,
    name        character varying(20),
    create_date date          NOT NULL,
    update_date date,
    PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    );

ALTER TABLE public.test_jpa
    OWNER to postgres;
COMMENT ON TABLE public.test_jpa
    IS 'table for test jpa';

COMMENT ON COLUMN public.test_jpa.id
    IS 'UUID';

COMMENT ON COLUMN public.test_jpa.name
    IS '姓名';

COMMENT ON COLUMN public.test_jpa.create_date
    IS '创建时间';

COMMENT ON COLUMN public.test_jpa.update_date
    IS '更新时间';