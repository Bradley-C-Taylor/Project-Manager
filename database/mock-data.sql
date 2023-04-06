SELECT * FROM project;
SELECT * FROM endpoint;

INSERT INTO project (project_name, project_description) VALUES ('Recipe Manager', 'Application for creating recipes, creating a meal plan, and creating a shopping list');
INSERT INTO endpoint (project_id, endpoint_url, endpoint_method) 
VALUES ((SELECT project_id FROM project WHERE project_name = 'Recipe Manager'), '/recipes', 'GET');
INSERT INTO endpoint (project_id, endpoint_url, endpoint_method) 
VALUES ((SELECT project_id FROM project WHERE project_name = 'Recipe Manager'), '/recipe', 'GET');

INSERT INTO endpoint_param (endpoint_id, param_name, param_description, param_optional)
VALUES ((SELECT endpoint_id FROM endpoint WHERE endpoint_url = '/recipe' AND endpoint_method = 'GET'), 'name: String', 'Name of the recipe to look for', true);
INSERT INTO endpoint_param (endpoint_id, param_name, param_description, param_optional)
VALUES ((SELECT endpoint_id FROM endpoint WHERE endpoint_url = '/recipe' AND endpoint_method = 'GET'), 'id: Integer', 'Id of the recipe to look for', true);

INSERT INTO endpoint (project_id, endpoint_url, endpoint_method) 
VALUES ((SELECT project_id FROM project WHERE project_name = 'Recipe Manager'), '/ingredients', 'GET');

SELECT e.endpoint_url, e.endpoint_method, ep.param_name, ep.param_description, ep.param_optional FROM endpoint e
JOIN project p ON e.project_id = p.project_id
LEFT JOIN endpoint_param ep ON e.endpoint_id = ep.endpoint_id
WHERE p.project_name = 'Recipe Manager';