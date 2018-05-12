DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `questionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `isActive` bit(1) NOT NULL,
  `questionText` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `options`;
CREATE TABLE `options` (
  `optionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `optionText` varchar(255) DEFAULT NULL,
  `questionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`optionId`),
  KEY `FKruf66ln49sgn8vipruw3nx5rq` (`questionId`),
  CONSTRAINT `FKruf66ln49sgn8vipruw3nx5rq` FOREIGN KEY (`questionId`) REFERENCES `questions` (`questionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `questions_options`;
CREATE TABLE `questions_options` (
  `questions_questionId` bigint(20) NOT NULL,
  `options_optionId` bigint(20) NOT NULL,
  PRIMARY KEY (`questions_questionId`,`options_optionId`),
  UNIQUE KEY `UK_qqme0emkwt3ugd0ym2wim1ymq` (`options_optionId`),
  CONSTRAINT `FK74wvsiedt7d66t08ry7rvleor` FOREIGN KEY (`questions_questionId`) REFERENCES `questions` (`questionid`),
  CONSTRAINT `FKk0xeb5sbnvyi1ami1ibrmk57i` FOREIGN KEY (`options_optionId`) REFERENCES `options` (`optionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

