JMX Basics
java -Dcom.sun.management.jmxremote.port=1234 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -jar target/JMX_Basics.jar

service:jmx:rmi:///jndi/rmi://192.168.0.150:1234/jmxrmi