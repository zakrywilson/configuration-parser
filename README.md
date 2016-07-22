# configuration-parser

A simple configuration file parser and container. 

## How to use

Simply provide a config file name and the file will be parsed on creation of the object
```java
Config config = new Config("path/to/config/file");
```

Access data element values
```java
String configValue = config.getElement("configValueName");
```

Even parse the values into any primitive value
```java
char charValue = config.getElementAsChar("charConfigValue");
short shortValue = config.getElementAsShort("shortConfigValue");
byte byteValue = config.getElementAsByte("byteConfigValue");
long longValue = config.getElementAsLong("longConfigValue");
int intValue = config.getElementAsInt("intConfigValue");
float floatValue = config.getElementAsFloat("floatConfigValue");
double doubleValue = config.getElementAsDouble("doubleConfigValue");
```

And get the values back as a java.io.File
```java
File file = config.getElementAsFile("filePathConfigValue");
File verifiedFile = config.getElementAsVerifiedFile("filePathConfigValue");
File verifiedDirectory = config.getElementAsVerifiedDirectory("directoryPathConfigValue");
```

Iterate over keys, values, or entry sets
```java
for (String name : config.getNames()) {
    System.out.println("Name: " + name);
}
for (String value : config.getElements()) {
    System.out.println("Value: " + value);
}
for (Map.Entry<String, String> entry : config.getEntries()) {
    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
}
```

## Requirements

* Java 8


## Valid configuration file set up

Three basic configuration file styles are accepted by this library:

1. Equals-delimited (`=`)
   ```
  config_element_1 = first_value

  config_element_2 = 200
  ```
2. Colon-delimited (`:`)
  ```
  config_element_1: first_value
  
  config_element_2: 200
  ```
3. White space-delimited
  ```
  config_element_1       first_value
  
  config_element_2       200
  ```
