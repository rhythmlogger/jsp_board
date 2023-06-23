CREATE TABLE `data` (
	`num` INT(11) NOT NULL AUTO_INCREMENT,
	`title` TEXT NOT NULL COLLATE 'utf8mb3_general_ci',
	`contents` TEXT NOT NULL COLLATE 'utf8mb3_general_ci',
	`id` VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	PRIMARY KEY (`num`) USING BTREE,
	INDEX `FK_data_member` (`id`) USING BTREE,
	CONSTRAINT `FK_data_member` FOREIGN KEY (`id`) REFERENCES `member` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='private int num;\r\nprivate String title;\r\nprivate String contents;\r\nprivate String id;'
COLLATE='utf8mb3_general_ci'
ENGINE=InnoDB
;
