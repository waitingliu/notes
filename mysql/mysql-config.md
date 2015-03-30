#mysql configuration

##mysql encode setting

*  `/etc/my.cnf` file (server encoding)
	```
	[mysqld]
	character-set-server=utf8
	collation-server=utf8_general_ci
	```
* database (DB encoding)
	`alter database testDB character set utf8;`
* `show variables like 'character%'`
* `status`

##create/drop user

1. login as root
2.```
	 insert into mysql.user(Host,User,Password,ssl_cipher,x509_issuer,x509_subject) values("localhost","用户名",password("密码")，'','','');
	grant all privileges on 数据库名.* to '用户名'@'localhost' identified by '密码';
	flush privileges;
```
3. `DROP USER 'username'@'localhost';` 

### show user:`select Host, User from mysql.user;`
