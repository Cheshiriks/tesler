insert into responsibilities (id, dept_id, internal_role_cd) values (0, 0, 'ADMIN');

insert into responsibilities (id, resp_type, screens, dept_id, internal_role_cd) VALUES (responsibility_id.nextval, 'SCREEN', to_clob(
    '[{
      "id": "id11",
      "name": "admin",
      "text": "Администрирование",
      "url": "/screen/admin",
      "defaultScreen": true
    }]'), 0 , 'ADMIN');
