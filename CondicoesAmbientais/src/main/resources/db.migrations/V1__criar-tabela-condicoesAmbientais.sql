CREATE SEQUENCE TBL_CondicoesAmbiental_SEQ
start With 1
increment by 1
nocache
nocycle;

CREATE Table TBL_CondicoesAmbientais (
    ID INTEGER DEFAULT TBL_CondicoesAmbiental_SEQ.nextval NOT NULL,
    qualidadeAr VARCHAR2(100) NOT NULL,
    umidade VARCHAR2(100) NOT NULL,
    temperatura VARCHAR2(100) NOT NULL,
    contatoEmergencia VARCHAR2(100) NOT NULL,
    desastreNatural VARCHAR2(100) NOT NULL
);
