
Postman requestleri Postman'den bu api ile edinilebilir: https://api.postman.com/collections/9577214-4fff8d40-5982-4edc-b111-59499e1cb40b?access_key=PMAT-01GJ9J665MSJ406YN5SMBFZEX4



Database PostgreSQL ile olusturuldu, DockerFile ve DockerCompose, database hostu localhost olduğu için bağlantı kuramadı.

## Sign up ve Sign in
"customer" endpointlerine request atabilmek icin oncelikle signup urisi ile Bearer Token"i almamiz gerekiyor. aksi taktirde "forbidden" response`u (403) donecektir.

Burada RSA encryption tool ile 1024 bitlik bir public ve private key aldigim keyler Json Web Token ile auth islemleri gerceklestiriyor. Spring Security HTTP filtrelemesini authentication icin kullandim. Bu filtreleme AuthenticationManager ile dogrulama yoneticisine gonderir. her kullanicinin ismi , sifresi dogru mu ya da token suresi doldu mu diye kontrol eder. Kimlik dogrulamasindan sonra JWT ile yetki alinir.

Sign-Up ve Sign-in Post Requestleri ayni olmalidir. Ornek request:

### Sign up
```POST /api/authentication/sign-up HTTP/1.1
Host: localhost:5555
Content-Type: application/json
Cookie: JSESSIONID=9725488E7C60637F0720D745EB19B071
Content-Length: 84

{
    "username": "erdem",
    "password": "erdem",
    "name": "deneme"
    
```

### Sign in
````POST /api/authentication/sign-in HTTP/1.1
Host: localhost:5555
Content-Type: application/json
Cookie: JSESSIONID=9725488E7C60637F0720D745EB19B071
Content-Length: 84

{
    "username": "erdem",
    "password": "erdem",
    "name": "deneme"
    
}
````


### Sign in

Sign-up isleminden sonra
``localhost:5555/api/authentication/sign-in`` endpointi ile sign in islemi yapilir gelen cevap daha sonra Customer
Controller`inde bulunan enpointler icin kullanilacak olan "Bearer token" i olacaktir. ornek olarak donen response su
sekilde olacaktir.


`"eyJhbGciOiJSUzUxMiJ9.eyJzdWIiOiJlcmRlbSIsInVzZXJJZCI6Mywicm9sZXMiOiJVU0VSIiwiZXhwIjoxNjQxODYyMDQ1fQ.RIkABnxDQZswYGI7lzcyjXc4bKf0tcGHCC4OyIkJFDgwQ9HlVivEKDazK7ePAbWv3Y4brD5SYrR5BObkxUGd0dSpnVdVRvIMNBmBWK2QCRPjr_TMwmyTtJOINoyhmS18T1WkvFu38Ze9__ygJsNyzm3B5_Bf_MmAVmLiRScAPzxnPB9zWLNMYQJHBorvE0BlMkXAHO21ZAyrC77dh-A7CPZaaKtde2aWHEKKldRsndKBnOI5IRYQk10j3EproTSH8M98tKVom6pjC3IzrN2218-QdnyJskhbz458m_xyyF_bVXZD4mEmZL1_IlHo2JlwikacJzxxFVwAihih3t2I8A"`



## Endpoints

#### List Users
````
GET localhost:5555/gateway/customers

GET /api/v1/customers HTTP/1.1
Host: localhost:5555
Authorization: Basic c2VjdXJlS2V5VXNlcm5hbWUhOnNlY3VyZUtleVBhc3N3b3JkIQ==
Cookie: JSESSIONID=B5B9AD173522F7CF449BD530066807C5
````

### Get User By id

GET localhost:5555/gateway/customers/{id}
```/gateway/customers/4```



###Delete user by id

DELETE localhost:5555/gateway/customers/{id}

```/gateway/customers/2```



###Create a Customer

POST localhost:5555/gateway/customers

```
POST /api/v1/customers HTTP/1.1
Host: localhost:5555
Authorization: Basic c2VjdXJlS2V5VXNlcm5hbWUhOnNlY3VyZUtleVBhc3N3b3JkIQ==
Content-Type: application/json
Cookie: JSESSIONID=8B449557FD997BB9D684A671D5A61AED
Content-Length: 162

{
    "firstName": "Ricardo",
    "lastName": "Quaresma",
    "custMail": "Ricardo@Q7.com",
    "street": "Besiktas",
    "phoneNum":"+90 555 1903 93"


}
```

### Update Customer

PUT localhost:5555/gateway/customers/{id}

```
PUT /api/v1/customers/4 HTTP/1.1
Host: localhost:5555
Authorization: Basic c2VjdXJlS2V5VXNlcm5hbWUhOnNlY3VyZUtleVBhc3N3b3JkIQ==
Content-Type: application/json
Cookie: JSESSIONID=B48E7FC82F111A90A28150593C8FFF19
Content-Length: 152

{
    "firstName": "Gary",
    "lastName": "Medel",
    "custMail": "Ricardo@Q7.com",
    "street": "Besiktas",
    "phoneNum":"+90 555 1903 93"
}``
