CREATE TABLE IF NOT EXISTS tb_order
(
    ID                   SERIAL NOT NULL,
    IDENTIFY            VARCHAR NOT NULL,
    CREATED_AT         TIMESTAMP NOT NULL,
    PAYMENT_ID          INTEGER NOT NULL,
    IS_ACTIVE      BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (ID)
);


CREATE TABLE IF NOT EXISTS tb_person
(
    ID                   SERIAL NOT NULL,
    IDENTIFY            VARCHAR NOT NULL,
    NAME                VARCHAR NOT NULL,
    CPF                 VARCHAR NOT NULL,
    CNPJ                VARCHAR NOT NULL,
    PHONE               VARCHAR NOT NULL,
    EMAIL               VARCHAR NOT NULL,
    BOX_TYPE            VARCHAR NOT NULL,
    PASSWORD            VARCHAR NOT NULL,
    USER_TYPE           VARCHAR NOT NULL,
    ADDRESS             VARCHAR NOT NULL,
    IS_ACTIVE      BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (ID)
);


CREATE TABLE IF NOT EXISTS tb_company
(
    ID                   SERIAL NOT NULL,
    IDENTIFY            VARCHAR NOT NULL,
    NAME                VARCHAR NOT NULL,
    CPF                 VARCHAR NOT NULL,
    CNPJ                VARCHAR NOT NULL,
    PHONE               VARCHAR NOT NULL,
    EMAIL               VARCHAR NOT NULL,
    BOX_TYPE            VARCHAR NOT NULL,
    PASSWORD            VARCHAR NOT NULL,
    USER_TYPE           VARCHAR NOT NULL,
    ADDRESS             VARCHAR NOT NULL,
    IS_ACTIVE      BOOLEAN DEFAULT FALSE,
    MIDIA               VARCHAR NOT NULL,
    TEMPLATE_STYLE_ID          INTEGER NULL,
    PRIMARY KEY (ID)

);


CREATE TABLE IF NOT EXISTS tb_deashboard
(
    ID                           SERIAL NOT NULL,
    IDENTIFY                    VARCHAR NOT NULL,
    QUANTITY_ORDER_SERVICE          INTEGER NULL,
    QUANTITY_ORDER_PRODUCER         INTEGER NULL,
    QUANTITY_WORKER                 INTEGER NULL,
    QUANTITY_PENDING                INTEGER NULL,
    QUANTITY_LOST                   INTEGER NULL,
    QUANTITY_DEVELOPMENT            INTEGER NULL,
    PRIMARY KEY (ID)

);

CREATE TABLE IF NOT EXISTS tb_payment
(
    ID                      SERIAL NOT NULL,
    NAME                   VARCHAR NOT NULL,
    CPF                    VARCHAR NOT NULL,
    PAY_TYPE               VARCHAR NOT NULL,
    PRODUCT_TYPE           VARCHAR NOT NULL,
    PRODUCT_VALUE          FLOAT NOT NULL,
    APPROVED_PAYMENT  BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (ID)

);

CREATE TABLE IF NOT EXISTS tb_template_style
(
    ID                   SERIAL NOT NULL,
    IDENTIFY            VARCHAR NOT NULL,
    TEXT_COLOR          VARCHAR(10) NULL,
    BACKGROUND_COLOR    VARCHAR(10) NULL,
    PRIMARY KEY (ID)

);


DO
$$
    BEGIN IF NOT EXISTS(SELECT 1
                        FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
                        WHERE CONSTRAINT_NAME = 'fk_tb_order_payment_id') THEN
        ALTER TABLE tb_order
            ADD CONSTRAINT FK_TB_ORDER_PAYMENT_ID FOREIGN KEY (PAYMENT_ID)
                REFERENCES TB_PAYMENT (ID)
                ON DELETE RESTRICT ON UPDATE RESTRICT;
    END IF;
    END;
$$;


DO
$$
    BEGIN IF NOT EXISTS(SELECT 1
                        FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
                        WHERE CONSTRAINT_NAME = 'fk_tb_order_template_style_id') THEN
        ALTER TABLE tb_company
            ADD CONSTRAINT FK_TB_ORDER_TEMPLATE_STYLE_ID FOREIGN KEY (TEMPLATE_STYLE_ID)
                REFERENCES TB_TEMPLATE_STYLE (ID)
                ON DELETE RESTRICT ON UPDATE RESTRICT;
    END IF;
    END;
$$;