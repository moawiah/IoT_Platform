import time
import random
from kafka import KafkaProducer


print("====== Welcome to our dummy generator ======")

producer=KafkaProducer(bootstrap_servers=['141.40.254.59:9092'])

def temperature():
    """ returns the temperature in degrees """
    temp=random.randint(15,40)
    print("temperature:", temp ,"'C")
    #for x in range(0, 1000):
    while True: 
                 producer.send('viper_test', "TempretatureValue:\t"+repr(temp))
            

def humidity():
    """ returns the humidity in percentage """
    hum=random.randint(15,30)
    print("humidity:", hum ,"%")

def pressure():
    """ returns the pressure in hPa """
    press=random.randint(1000,1050)
    print("pressure:", press ,"hPa")  

def altitude():
    """ returns the altitude in meters """
    alt=random.randint(40,50)
    print("altitude:", alt ,"hPa")      



def UltraV():
    """ returns the UV """
    uv=random.randint(1,3)
    print("UV:", uv)   

def visible():
    """ returns the visibility in Lux """
    vis=random.randint(200,205)
    print("altitude:", vis ,"Lux")              

def IR():
    """ returns the IR in Lux """
    ir=random.randint(390,400)
    print("altitude:", ir ,"Lux")   

temperature()
humidity()
pressure()
altitude()
print("====== Other sensors ======")  
UltraV()
visible()
IR()
print("===========================")

