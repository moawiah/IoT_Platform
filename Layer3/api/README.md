## install node.js using

apt-get install nodejs-legacy

## install express

npm install express –-save

## install elastic search express

npm install elasticsearch express

## open the port to be accessed from internet
iptables -I INPUT -p tcp -m tcp --dport 9092 -j ACCEPT

## run the server
npm run start

## connect to the server on http://localhost:3000/indices for example
