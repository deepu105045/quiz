DROP TABLE IF EXISTS `questions`;
CREATE TABLE questions (
  questionId INTEGER ,
  questionText VARCHAR(100) NOT NULL,
  questionType VARCHAR (10),
  active BOOLEAN,
  PRIMARY KEY(questionId)
);

DROP TABLE IF EXISTS `options`;
CREATE TABLE options(
  questionId INTEGER,
  optionsId VARCHAR(1),
  optionText VARCHAR(100),
  PRIMARY KEY (questionId,optionsId),
  FOREIGN KEY (questionId) REFERENCES questions (questionId)
);

DROP TABLE IF EXISTS `answers`;
CREATE TABLE answers(
  id INTEGER,
  questionId INTEGER,
  answerId VARCHAR(100),
  PRIMARY KEY (id),
  FOREIGN KEY (questionId)  REFERENCES questions (questionId)
);