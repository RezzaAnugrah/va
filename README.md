# API Virtual Account
- Customer List [GET] http://localhost:1001/list/customer
````json
# Default Customer List
{
    "data": [
        {
            "customerID": "CSM01",
            "name": "Jhon",
            "email": "Jhon@gmail.com",
            "phone": "0812"
        },
        {
            "customerID": "CSM02",
            "name": "Rezza",
            "email": "Rezza@gmail.com",
            "phone": "0813"
        }
    ]
}
````
- Promo List [GET] http://localhost:1001/list/promo
````json
# Default Promo List
{
    "data": [
        {
            "promoID": "PRM01",
            "promoName": "Promo Kartini",
            "promoDiscont": 10000
        },
        {
            "promoID": "PRM02",
            "promoName": "Promo Mei",
            "promoDiscont": 25000
        }
    ]
}
````
- Transaction [POST] http://localhost:1001/transaction/create
``` json
# Request
{
    "customerID": "CSM02",
    "customerName": "Rezza",
    "amount": "250000",
    "promotID": "PRM02"
}
```
- Transaction List [GET] http://localhost:1001/transaction/report
- Payment [POST] http://localhost:1001/payment/confirm
``` json
# Request
{
    "virtualAccountNo": "485995976135",
    "amount": "225000",
    "paymentDate": "2024-04-30T06:30:52.584+00:00",
    "remark": "Test"
}
```
- Payment List [GET] http://localhost:1001/payment/report