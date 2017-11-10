create table invoices (
    invoiceId bigint(20) not null auto_increment,
    payorName varchar(255),
    originalAmount double,

    primary key(invoiceId)
)