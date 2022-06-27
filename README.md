# teamfresh_project
VOC에 대한 배상 개발
(VOC 목록 API, 배상 목록 API, VOC 등록 API, 배상정보 등록 API)
------------
# 구성
- 환경
  - github
  - mysql
  - Spring Boot 2.7.0
  - java 1.8
  - QueryDSL
  - Spring Data JPA
  
# 개발
- 구조
project
    ├─api api controller 폴더
    │  └─dto api Request Response 폴더
    │      └─common
    ├─domain 도메인 폴더
    │  └─dto
    ├─repository 레포지토리 폴더
    └─service 서비스 

- DDL
```
-- VOC
CREATE TABLE `voc` (
	`voc_id`           INT                        NOT NULL COMMENT 'VOC번호', -- VOC번호
	`voc_type`         ENUM('CUSTOMER','CARRIER') NOT NULL COMMENT '귀책당사자', -- 귀책당사자
	`voc_content`      VARCHAR(255)               NOT NULL COMMENT '귀책내용', -- 귀책내용
	`carrier_id`       INT                        NOT NULL COMMENT '운송사기사번호', -- 운송사기사번호
	`customer_id`      INT                        NOT NULL COMMENT '고객사번호', -- 고객사번호
	`create_date`      DATETIME                   NOT NULL COMMENT '생성일', -- 생성일
	`last_modify_date` DATETIME                   NOT NULL COMMENT '수정일' -- 수정일
)
COMMENT 'VOC';

-- VOC
ALTER TABLE `voc`
	ADD CONSTRAINT `PK_voc` -- VOC 기본키
		PRIMARY KEY (
			`voc_id` -- VOC번호
		);

ALTER TABLE `voc`
	MODIFY COLUMN `voc_id` INT NOT NULL AUTO_INCREMENT COMMENT 'VOC번호';

-- 배상
CREATE TABLE `compensation` (
	`compensation_id`     INT           NOT NULL COMMENT '배상번호', -- 배상번호
	`voc_id`              INT           NOT NULL COMMENT 'VOC번호', -- VOC번호
	`compensation_amount` INT           NOT NULL COMMENT '배상금액', -- 배상금액
	`compensation_yn`     ENUM('Y','N') NOT NULL COMMENT '배상요청여부', -- 배상요청여부
	`create_date`         DATETIME      NOT NULL COMMENT '생성일', -- 생성일
	`last_modify_date`    DATETIME      NOT NULL COMMENT '수정일' -- 수정일
)
COMMENT '배상';

-- 배상
ALTER TABLE `compensation`
	ADD CONSTRAINT `PK_compensation` -- 배상 기본키
		PRIMARY KEY (
			`compensation_id` -- 배상번호
		);

ALTER TABLE `compensation`
	MODIFY COLUMN `compensation_id` INT NOT NULL AUTO_INCREMENT COMMENT '배상번호';

-- 운송사기사
CREATE TABLE `carrier` (
	`carrier_id`       INT          NOT NULL COMMENT '운송사기사번호', -- 운송사기사번호
	`carrier_company`  VARCHAR(255) NOT NULL COMMENT '운송사명', -- 운송사명
	`carrier_name`     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	`carrier_phone`    VARCHAR(100) NOT NULL COMMENT '연락처', -- 연락처
	`create_date`      DATETIME     NOT NULL COMMENT '생성일', -- 생성일
	`last_modify_date` DATETIME     NOT NULL COMMENT '수정일' -- 수정일
)
COMMENT '운송사기사';

-- 운송사기사
ALTER TABLE `carrier`
	ADD CONSTRAINT `PK_carrier` -- 운송사기사 기본키
		PRIMARY KEY (
			`carrier_id` -- 운송사기사번호
		);

ALTER TABLE `carrier`
	MODIFY COLUMN `carrier_id` INT NOT NULL AUTO_INCREMENT COMMENT '운송사기사번호';

-- 고객사
CREATE TABLE `customer` (
	`customer_id`      INT          NOT NULL COMMENT '고객사번호', -- 고객사번호
	`customer_company` VARCHAR(255) NOT NULL COMMENT '고객사명', -- 고객사명
	`customer_name`    VARCHAR(50)  NOT NULL COMMENT '고객사담당자', -- 고객사담당자
	`customer_phone`   VARCHAR(100) NOT NULL COMMENT '연락처', -- 연락처
	`create_date`      DATETIME     NOT NULL COMMENT '생성일', -- 생성일
	`last_modify_date` DATETIME     NOT NULL COMMENT '수정일' -- 수정일
)
COMMENT '고객사';

-- 고객사
ALTER TABLE `customer`
	ADD CONSTRAINT `PK_customer` -- 고객사 기본키
		PRIMARY KEY (
			`customer_id` -- 고객사번호
		);

ALTER TABLE `customer`
	MODIFY COLUMN `customer_id` INT NOT NULL AUTO_INCREMENT COMMENT '고객사번호';

-- 패널티
CREATE TABLE `penalty` (
	`penalty_id`       INT           NOT NULL COMMENT '패널티번호', -- 패널티번호
	`voc_id`           INT           NOT NULL COMMENT 'VOC번호', -- VOC번호
	`confirm_yn`       ENUM('Y','N') NOT NULL COMMENT '확인여부', -- 확인여부
	`appeal_yn`        ENUM('Y','N') NOT NULL COMMENT '이의제기여부', -- 이의제기여부
	`create_date`      DATETIME      NOT NULL COMMENT '생성일', -- 생성일
	`last_modify_date` DATETIME      NOT NULL COMMENT '수정일' -- 수정일
)
COMMENT '패널티';

-- 패널티
ALTER TABLE `penalty`
	ADD CONSTRAINT `PK_penalty` -- 패널티 기본키
		PRIMARY KEY (
			`penalty_id` -- 패널티번호
		);

ALTER TABLE `penalty`
	MODIFY COLUMN `penalty_id` INT NOT NULL AUTO_INCREMENT COMMENT '패널티번호';

-- VOC
ALTER TABLE `voc`
	ADD CONSTRAINT `FK_carrier_TO_voc` -- 운송사기사 -> VOC
		FOREIGN KEY (
			`carrier_id` -- 운송사기사번호
		)
		REFERENCES `carrier` ( -- 운송사기사
			`carrier_id` -- 운송사기사번호
		);

-- VOC
ALTER TABLE `voc`
	ADD CONSTRAINT `FK_customer_TO_voc` -- 고객사 -> VOC
		FOREIGN KEY (
			`customer_id` -- 고객사번호
		)
		REFERENCES `customer` ( -- 고객사
			`customer_id` -- 고객사번호
		);

-- 배상
ALTER TABLE `compensation`
	ADD CONSTRAINT `FK_voc_TO_compensation` -- VOC -> 배상
		FOREIGN KEY (
			`voc_id` -- VOC번호
		)
		REFERENCES `voc` ( -- VOC
			`voc_id` -- VOC번호
		);

-- 패널티
ALTER TABLE `penalty`
	ADD CONSTRAINT `FK_voc_TO_penalty` -- VOC -> 패널티
		FOREIGN KEY (
			`voc_id` -- VOC번호
		)
		REFERENCES `voc` ( -- VOC
			`voc_id` -- VOC번호
		);
```
