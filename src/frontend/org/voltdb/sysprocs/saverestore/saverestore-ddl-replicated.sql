-- Simple table to test replicated save/restore
CREATE TABLE REPLICATED_TESTER (
  RT_ID INTEGER DEFAULT '0' NOT NULL,
  RT_NAME VARCHAR(32) DEFAULT NULL,
  RT_INTVAL INTEGER DEFAULT NULL,
  RT_FLOATVAL FLOAT DEFAULT NULL,
  PRIMARY KEY (RT_ID)
);
 
