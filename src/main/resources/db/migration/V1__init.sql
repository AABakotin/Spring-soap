    create table categories (
                            id                      bigserial primary key,
                            title                   varchar(255)
                            );

    insert into categories (title)
        values  (
              'Food'
                );

    create table products (
                        id bigserial            primary key,
                        name                    varchar(255),
                        cost                    integer,
                        categories_id           bigint
                                                references categories(id)
                        );

    insert into products (name, cost, categories_id)
        values      ('Bread',     30, 1),
                    ('Milk',      35, 1);

