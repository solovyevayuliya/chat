-- public.message definition

-- Drop table

-- DROP TABLE public.message;

CREATE TABLE public.message (
                                id bigserial NOT NULL,
                                "text" varchar(255) NULL,
                                username varchar(255) NULL,
                                CONSTRAINT message_pkey PRIMARY KEY (id)
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
                              enabled bool NOT NULL,
                              user_id varchar(255) NOT NULL,
                              "password" varchar(255) NULL,
                              "role" varchar(255) NULL,
                              username varchar(255) NULL,
                              CONSTRAINT uc_username UNIQUE (username),
                              CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

INSERT INTO public.users
(enabled, user_id, "password", "role", username)
VALUES(true, 'uuid', '$2a$10$gUeuNn3Gu9koG19VbmjwI.XT0q0hFP30KzKBkby2zffGyG9huclVS', 'USER', 'User');