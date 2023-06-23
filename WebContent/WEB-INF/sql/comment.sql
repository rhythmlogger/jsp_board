CREATE TABLE `comment` (
	`num` INT(11) NULL DEFAULT NULL,
	`cnum` INT(11) NOT NULL AUTO_INCREMENT,
	`contents` TEXT NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`id` VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	PRIMARY KEY (`cnum`) USING BTREE,
	INDEX `FK__member` (`id`) USING BTREE,
	INDEX `FK__data` (`num`) USING BTREE,
	CONSTRAINT `FK__data` FOREIGN KEY (`num`) REFERENCES `data` (`num`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `FK__member` FOREIGN KEY (`id`) REFERENCES `member` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='private int num;\r\nprivate int rnum;\r\nprivate String contents;\r\nprivate String id;'
COLLATE='utf8mb3_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=8
;
