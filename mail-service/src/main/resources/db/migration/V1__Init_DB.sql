create table emails
(
    id bigserial not null constraint mails_pkey primary key,
    send_to varchar(255),
    subject varchar(255),
    text text,
    created_at timestamp,
    sent_at timestamp
);



