CREATE TABLE `memberboard` (
	`num` INT(11) NOT NULL AUTO_INCREMENT,
	`id` VARCHAR(256) NOT NULL COLLATE 'utf8mb3_general_ci',
	`password` TEXT NOT NULL COLLATE 'utf8mb3_general_ci',
	`email` TEXT NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	PRIMARY KEY (`num`) USING BTREE,
	UNIQUE INDEX `id` (`id`) USING BTREE
)
COMMENT='private int num;\r\nprivate String id;\r\nprivate String password;\r\nprivate String email;'
COLLATE='utf8mb3_general_ci'
ENGINE=InnoDB
;
