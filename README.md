mvrs
===========

Auditing Component Description
The Auditing Component provides an interface to track all events on a system by creating an Audit Record into the system’s database.

The auditing component requires a client to post a JSON formatted string to the web service over HTTP.
This HTTP Request must have a parameter called jsondata. (See schema document for format of JSON parameter)

The web service will insert an audit record into the event_audit table upon a successful request with valid parameter values.

Service Endpoint: 	http://<<host-name>>:<<port>>/Auditing/Audit	

Argument (Parameter Name: jsondata)
Database Credentials 
	Port                       Integer
	Database name   String
	Host		String
	Username	String
	Password	String
Username           String
Comment 	String
Event_id 	Integer
Audit_dTime 	Date


Database Structure
Tables that must exist in the system that will be using this Auditing component:

CREATE TABLE `event` (
  `event_id` int(11) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `event_audit` (
  `audit_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `comment` text,
  `dtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `event_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`audit_id`),
  KEY `event_id_idx` (`event_id`),
  CONSTRAINT `event_id` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;


