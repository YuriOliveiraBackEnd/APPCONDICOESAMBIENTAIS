CREATE SEQUENCE SEQ_USUARIO
start With 1
increment by 1
nocache
nocycle;

CREATE Table TBL_USUARIO (
    IDUsuario INTEGER DEFAULT SEQ_USUARIO.nextval NOT NULL,
    nome VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) UNIQUE NOT NULL,
    senha VARCHAR2(20) NOT NULL,
    role VARCHAR2(50) DEFAULT 'user',
);