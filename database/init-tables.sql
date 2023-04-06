-- ROLLBACK;
START TRANSACTION;

DROP TABLE IF EXISTS endpoint, project, endpoint_param;

CREATE TABLE project 
(
	project_id SERIAL,
	project_name VARCHAR(128) NOT NULL,
	project_description VARCHAR(128) NOT NULL,
	project_logo VARCHAR(128),
	
	CONSTRAINT pk_project_id PRIMARY KEY (project_id)
);

CREATE TABLE endpoint
(
	endpoint_id SERIAL,
	project_id INT NOT NULL,
	endpoint_url VARCHAR(128) NOT NULL,
	endpoint_method VARCHAR(16) NOT NULL,
	
	CONSTRAINT pk_endpoint_id PRIMARY KEY (endpoint_id),
	CONSTRAINT fk_project_id FOREIGN KEY (project_id) REFERENCES project(project_id)
);

CREATE TABLE endpoint_param
(
	param_id SERIAL,
	endpoint_id INT NOT NULL,
	param_name VARCHAR(32) NOT NULL,
	param_description VARCHAR(128) NOT NULL,
	param_optional BOOLEAN DEFAULT FALSE,
	
	CONSTRAINT pk_param_id PRIMARY KEY (param_id),
	CONSTRAINT fk_endpoint_id FOREIGN KEY (endpoint_id) REFERENCES endpoint(endpoint_id)
);

COMMIT TRANSACTION;