=== Create Self Signed Certificate for Server and Client ===
1) Generating the Server Keystore:
keytool -genkeypair
 -alias secure-server
 -keyalg RSA
 -keysize 2048
 -validity 365
 -dname "CN=localhost,OU=myorg,O=myorg,L=mycity,S=mystate,C=es"
 -keypass secret
 -keystore server-keystore.p12
 -storepass secret
 -storetype PKCS12

2) Generating the Client Keystore:
keytool -genkeypair
 -alias secure-client 
 -keyalg RSA
 -keysize 2048
 -validity 365
 -dname "CN=codependent-client,OU=myorg,O=myorg,L=mycity,S=mystate,C=es"
 -keypass secret
 -keystore client-keystore.p12
 -storepass secret
 -storetype PKCS12
 
 === Import the supported client's public certificates intro the server truststore: ===
1) Export the client public certificate: 
keytool -exportcert -alias secure-client -file client-public.cer -keystore client-keystore.p12 -storepass secret

2) Import it in the server truststore: 
keytool -importcert -keystore server-truststore.jks -alias clientcert -file client-public.cer -storepass secret

 === Import the server's public certificate into the client truststores: ===
 1) Export the server public certificate:
 keytool -exportcert -alias secure-server -file server-public.cer -keystore server-keystore.p12 -storepass secret

2) Import it in the client truststore:
keytool -importcert -keystore client-truststore.jks -alias servercert -file server-public.cer -storepass secret