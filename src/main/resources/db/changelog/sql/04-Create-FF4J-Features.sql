--changeset mark:7
CREATE TABLE `ff4j_features` (   `FEAT_UID` varchar(100) NOT NULL,   `ENABLE` int NOT NULL,   `DESCRIPTION` varchar(1000) DEFAULT NULL,   `STRATEGY` varchar(1000) DEFAULT NULL,   `EXPRESSION` varchar(255) DEFAULT NULL,   `GROUPNAME` varchar(100) DEFAULT NULL,   PRIMARY KEY (`FEAT_UID`) );
