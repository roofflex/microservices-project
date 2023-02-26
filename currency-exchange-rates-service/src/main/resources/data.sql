--Spring Data JPA will execute this script on app start to prepopulate DB with data

insert into exchange_rate (from_currency, to_currency, rate, environment)
    values
        ('USD', 'EUR', 0.93, ''),
        ('EUR', 'GBP', 0.81, ''),
        ('GBP', 'USD', 1.42, '');
