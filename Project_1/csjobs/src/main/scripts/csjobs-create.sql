
    create table application_degrees (
        application_id int8 not null,
        name varchar(255),
        school varchar(255),
        year int4
    );

    create table applications (
        id int8 not null,
        curriculum_vitae bytea,
        company varchar(255),
        research_statement bytea,
        start_year int4,
        teaching_statement bytea,
        title varchar(255),
        applicant_id int8,
        job_id int8,
        primary key (id)
    );

    create table authorities (
        user_id int8 not null,
        authority varchar(255)
    );

    create table files (
        id int8 not null,
        date timestamp not null,
        name varchar(255) not null,
        path varchar(255),
        size int8,
        type varchar(255),
        owner_id int8 not null,
        primary key (id)
    );

    create table job_committee_members (
        job_id int8 not null,
        user_id int8 not null
    );

    create table jobs (
        id int8 not null,
        closed_on timestamp,
        closed boolean not null,
        description varchar(255),
        published_on timestamp,
        title varchar(255),
        committee_chair_id int8,
        primary key (id)
    );

    create table reviews (
        id int8 not null,
        comments varchar(255),
        date timestamp,
        rank int4,
        reviewer_id int8,
        round_id int8,
        primary key (id)
    );

    create table rounds (
        id int8 not null,
        round_index int4 not null,
        passed boolean not null,
        application_id int8,
        primary key (id)
    );

    create table users (
        id int8 not null,
        address varchar(255),
        enabled boolean not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255) not null,
        phone varchar(255),
        username varchar(255) not null,
        primary key (id)
    );

    alter table applications 
        add constraint UK_64ys5tle1oyk7oolbnglyrws3 unique (job_id, applicant_id);

    alter table users 
        add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table application_degrees 
        add constraint FK_p23g7k8rypw0ba1ekhgytb5g 
        foreign key (application_id) 
        references applications;

    alter table applications 
        add constraint FK_lmcomkxa52fc4kw1pgin4ov1i 
        foreign key (applicant_id) 
        references users;

    alter table applications 
        add constraint FK_3k2w7gtt3v412p8xhjmrfdjqo 
        foreign key (job_id) 
        references jobs;

    alter table authorities 
        add constraint FK_s21btj9mlob1djhm3amivbe5e 
        foreign key (user_id) 
        references users;

    alter table files 
        add constraint FK_5ok1awgnfwcf01537ylbycyq1 
        foreign key (owner_id) 
        references users;

    alter table job_committee_members 
        add constraint FK_8i1xpob5ig8dunf8go0gceh4b 
        foreign key (user_id) 
        references users;

    alter table job_committee_members 
        add constraint FK_d12kbfko72rgnlcp96meiykvv 
        foreign key (job_id) 
        references jobs;

    alter table jobs 
        add constraint FK_4gbcg6sweyjppsfb9tw4fk1yp 
        foreign key (committee_chair_id) 
        references users;

    alter table reviews 
        add constraint FK_bnaf4eil2cek30ntv43920vu 
        foreign key (reviewer_id) 
        references users;

    alter table reviews 
        add constraint FK_lrodxjcqcl3wfmb4bkhvrxolx 
        foreign key (round_id) 
        references rounds;

    alter table rounds 
        add constraint FK_38dtvawacp71xvc1dpfrpapin 
        foreign key (application_id) 
        references applications;

    create sequence hibernate_sequence minvalue 100;

        
    INSERT INTO users (id, username, password, first_name, last_name, enabled) VALUES
    (1, 'admin@localhost.localdomain', 'abcd', 'John', 'Doe', true),
    (2, 'reviewer1@localhost.localdomain', 'abcd', 'Revi', 'Ewer', true),
    (3, 'reviewer2@localhost.localdomain', 'abcd', 'Rewe', 'Iver', true),
    (4, 'reviewer3@localhost.localdomain', 'abcd', 'Dan', 'First', true),
    (5, 'reviewer4@localhost.localdomain', 'abcd', 'Ann', 'Second', true),
    (6, 'applicant1@localhost.localdomain', 'abcd', 'Appli', 'Cant', true),
    (7, 'applicant2@localhost.localdomain', 'abcd', 'Sam', 'Smit', true);
    
    INSERT INTO authorities (user_id, authority) VALUES
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_REVIEWER'),
    (3, 'ROLE_REVIEWER'),
    (4, 'ROLE_REVIEWER'),
    (5, 'ROLE_REVIEWER'),
    (6, 'ROLE_USER'),
    (7, 'ROLE_USER');
    
    INSERT INTO jobs (id, closed_on, closed, description, published_on, title, committee_chair_id) VALUES
    (1, '8/30/2015', false, 'Start Fall 2015', '7/11/2015', 'Tenure-Track Faculty Position (Start Fall 2015)', 2),
    (2, '8/30/2015', false, 'Start Fall 2016', '7/11/2015', 'Tenure-Track Faculty Position (Start Fall 2016)', 4);
    
    INSERT INTO job_committee_members (user_id, job_id) VALUES
    (2, 1),
    (3, 1),
    (4, 1),
    (3, 2),
    (4, 2),
    (5, 2);
    
    INSERT INTO applications (id, company, start_year, title, job_id, applicant_id) VALUES
    (1, 'Etekcity', 2014, 'System Administrator', 1, 6),
    (2, 'California State University - LA', 2013, 'Teacher', 1, 7);
    
    INSERT INTO application_degrees (application_id, name, school, year) VALUES
    (2, 'Ph.D. in Computer Science', 'UCLA', 2014),
    (2, 'MS in Computer Science', 'UCLA', 2011),
    (2, 'BS in Computer Science', 'CSULA', 2009);