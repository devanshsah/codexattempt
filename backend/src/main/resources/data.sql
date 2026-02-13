INSERT INTO app_user(name,email,role) VALUES ('Super Admin','superadmin@nobroker.local','SUPER_ADMIN');
INSERT INTO app_user(name,email,role) VALUES ('Moderator One','moderator@nobroker.local','PROPERTY_MODERATOR');
INSERT INTO app_user(name,email,role) VALUES ('Owner One','owner@nobroker.local','OWNER');
INSERT INTO app_user(name,email,role) VALUES ('Tenant One','tenant@nobroker.local','TENANT');

INSERT INTO property(title,city,locality,rent,bhk,owner_email,moderation_status,active)
VALUES ('2BHK near Metro','Bengaluru','Indiranagar',32000,2,'owner@nobroker.local','PENDING',true);
