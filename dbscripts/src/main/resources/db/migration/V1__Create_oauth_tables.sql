DROP TABLE IF EXISTS oauth_client_details;

CREATE TABLE oauth_client_details (
  client_id varchar(255) NOT NULL,
  resource_ids varchar(255) DEFAULT NULL,
  client_secret varchar(255) DEFAULT NULL,
  scope varchar(255) DEFAULT NULL,
  authorized_grant_types varchar(255) DEFAULT NULL,
  web_server_redirect_uri varchar(255) DEFAULT NULL,
  authorities varchar(255) DEFAULT NULL,
  access_token_validity int(11) DEFAULT NULL,
  refresh_token_validity int(11) DEFAULT NULL,
  additional_information varchar(4096) DEFAULT NULL,
  autoapprove varchar(4096) DEFAULT NULL
) engine=innodb;

DROP TABLE IF EXISTS oauth_access_token;

CREATE TABLE oauth_access_token (
  token_id varchar(255) DEFAULT NULL,
  token blob,
  authentication_id varchar(255) DEFAULT NULL,
  user_name varchar(255) DEFAULT NULL,
  client_id varchar(255) DEFAULT NULL,
  authentication blob,
  refresh_token varchar(255) DEFAULT NULL
) engine=innodb;


DROP TABLE IF EXISTS oauth_refresh_token;

CREATE TABLE oauth_refresh_token (
  token_id varchar(255) DEFAULT NULL,
  token blob,
  authentication blob
) engine=innodb;

/* to insert basic client detail use */
INSERT INTO oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities, access_token_validity, refresh_token_validity)
VALUES ('myapi', 'myapi', '$2a$11$gxpnezmYfNJRYnw/EpIK5Oe08TlwZDmcmUeKkrGcSGGHXvWaxUwQ2', 'trust,read,write', 'client_credentials,authorization_code,implicit,password,refresh_token', 'ROLE_API_USER', '31104000', '31104000');

/*

to generate basic client details we have used
public static void main(String[] args){
//        byte[] bytes1 = Base64.encodeBase64(("demo@email.com" + ":" + "fe01ce2a7fbac8fafaed7c982a04e229").getBytes());
//        System.out.println("Basic "+new String(bytes1));

        String id = "myapi";
        String password = "$2a$11$gxpnezmYfNJRYnw/EpIK5Oe08TlwZDmcmUeKkrGcSGGHXvWaxUwQ2";

        byte[] bytes = Base64.encodeBase64((id + ":" + password).getBytes());
        System.out.println("Basic " + new String(bytes));
    }
    Basic bXlhcGk6JDJhJDExJGd4cG5lem1ZZk5KUlludy9FcElLNU9lMDhUbHdaRG1jbVVlS2tyR2NTR0dIWHZXYXhVd1Ey
 */